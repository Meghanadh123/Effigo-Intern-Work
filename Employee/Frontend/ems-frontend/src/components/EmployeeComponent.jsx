import React, { useEffect, useState } from "react";
import { useForm } from "react-hook-form";
import { Container, TextField, Button, Typography, Paper, Grid } from "@mui/material";
import { listEmployees, createEmployee } from "../services/EmployeeService"; // Import API calls

export default function EmployeeComponent() {
  const [employees, setEmployees] = useState([]); // Store fetched employees

  useEffect(() => {
    // Fetch employees when component loads
    listEmployees()
      .then((response) => {
        setEmployees(response.data);
      })
      .catch((error) => {
        console.error("Error fetching employees:", error);
      });
  }, []);

  const {
    register,
    handleSubmit,
    formState: { errors },
    reset,
  } = useForm();

  const onSubmit = (data) => {
    createEmployee(data) // Send data to API
      .then((response) => {
        console.log("Employee Added:", response.data);
        alert("Employee Added Successfully!");
        setEmployees([...employees, response.data]); // Update state with new employee
        reset(); // Clear form fields
      })
      .catch((error) => {
        console.error("Error adding employee:", error);
        alert("Failed to add employee.");
      });
  };

  return (
    <Container maxWidth="sm">
      <Paper
        elevation={3}
        style={{
          padding: "20px",
          marginTop: "20px",
          borderRadius: "10px",
          textAlign: "center",
        }}
      >
        
        <Typography variant="h5" fontWeight="bold" gutterBottom>
          Add Employee
        </Typography>
        <form onSubmit={handleSubmit(onSubmit)}>
          <Grid container spacing={2}>
            <Grid item xs={12}>
              <TextField
                fullWidth
                label="First Name"
                variant="outlined"
                {...register("firstName", { required: "First Name is required" })}
                error={!!errors.firstName}
                helperText={errors.firstName?.message}
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                fullWidth
                label="Last Name"
                variant="outlined"
                {...register("lastName", { required: "Last Name is required" })}
                error={!!errors.lastName}
                helperText={errors.lastName?.message}
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                fullWidth
                label="Email ID"
                variant="outlined"
                {...register("email", {
                  required: "Email is required",
                  pattern: {
                    value: /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/,
                    message: "Invalid email format",
                  },
                })}
                error={!!errors.email}
                helperText={errors.email?.message}
              />
            </Grid>
            <Grid item xs={12}>
              <Button
                type="submit"
                variant="contained"
                color="primary"
                fullWidth
                style={{ padding: "10px", fontSize: "16px" }}
              >
                Submit
              </Button>
            </Grid>
          </Grid>
        </form>
      </Paper>

      {/* Display Existing Employees */}
      <Typography variant="h6" fontWeight="bold" mt={3}>
        Existing Employees:
      </Typography>
      <ul>
        {employees.map((emp) => (
          <li key={emp.id}>
            {emp.firstName} {emp.lastName} - {emp.email}
          </li>
        ))}
      </ul>
    </Container>
  );
}
