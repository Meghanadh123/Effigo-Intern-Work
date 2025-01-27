<%@ page contentType="text/html; charset=ISO-8859-1" isELIgnored="false"%>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <style>
        /* Style for the table */
        table {
            border-collapse: collapse;
            width: 80%;
            margin: 0 auto; /* Center the table on the page */
        }

        th, td {
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #007BFF; /* Blue background for table headers */
            color: #fff; /* White text for table headers */
        }

        tr:nth-child(even) {
            background-color: #f2f2f2; /* Light gray background for even rows */
        }
         /* Style for the Register button */
        .button {
            background-color: #FF0000; /* Red background for the button */
            color: #fff; /* White text for the button */
            padding: 10px 20px;
            border: none;
            cursor: pointer;

    </style>
</head>
<body>
    <%@ include file="navbar.jsp" %>
    <br>
    <h3 align="center"><u>Employee Registration</u></h3>
    <br>
    <form method="post" action="insertemp">
        <table>
            <tr>
                <th><label>Name</label></th>
                <td><input type="text" name="name" required="required"/></td>
            </tr>
            <tr>
                <th><label>Gender</label></th>
                <td>
                    <input type="radio" name="gender" value="MALE" required/>Male
                    <input type="radio" name="gender" value="FEMALE" required/>Female
                    <input type="radio" name="gender" value="OTHERS" required/>Others
                </td>
            </tr>
            <tr>
                <th><label>Date of Birth</label></th>
                <td><input type="date" name="dob" required="required"/></td>
            </tr>
            <tr>
                <th><label>Department</label></th>
                <td>
                    <select name="dept" required>
                        <option value="">---Select---</option>
                        <option value="SALES">Sales</option>
                        <option value="TECHNICAL">Technical</option>
                        <option value="MARKETING">Marketing</option>
                        <option value="OTHERS">Others</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th><label>Salary</label></th>
                <td><input type="number" name="salary" step="0.01" required/></td>
            </tr>
            <tr>
                <th><label>Email ID</label></th>
                <td><input type="email" name="email" required/></td>
            </tr>
            <tr>
                <th><label>Password</label></th>
                <td><input type="password" name="pwd" required/></td>
            </tr>
            <tr>
                <th><label>Location</label></th>
                <td><input type="text" name="location" required/></td>
            </tr>
            <tr>
                <th><label>Contact No</label></th>
                <td><input type="text" name="contact" pattern="[789][0-9]{9}" placeholder="Must be 10 digits" required/></td>
            </tr>
            <tr align="center">
                <td colspan="2"><input type="submit" value="Register" class="button"></td>
            </tr>
        </table>
    </form>
</body>
</html>
