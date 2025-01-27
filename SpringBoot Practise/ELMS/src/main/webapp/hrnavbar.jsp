<!DOCTYPE html>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <title>Spring Boot MVC</title>
    <style>
        /* Add CSS for the navbar */
        ul.navbar {
            list-style-type: none;
            margin: 0;
            padding: 0;
            background-color: #3498db; /* Change the background color to the previous navbar color */
            overflow: hidden;
            border-radius: 10px; /* Add border radius for curved edges */
        }

        ul.navbar li {
            float: left; /* Align the list items to the left */
        }

        ul.navbar li a {
            display: block;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        ul.navbar li a:hover {
            background-color: #555; /* Background color on hover */
        }

        /* Style the dropdown container */
        .dropdown {
            display: inline-block;
        }

        /* Style the dropdown button */
        .dropbtn {
            padding: 14px 16px;
            background-color: inherit;
            color: white;
            border: none;
        }

        /* Style the dropdown content (hidden by default) */
        .dropdown-content {
            display: none;
            position: absolute;
            background-color: #3498db; /* Change the background color to the previous navbar color */
            min-width: 160px;
            z-index: 1;
        }

        /* Style the dropdown links */
        .dropdown-content a {
            display: block;
            color: white;
            padding: 12px 16px;
            text-decoration: none;
        }

        .dropdown-content a:hover {
            background-color: #555; /* Background color on hover */
        }

        /* Show the dropdown content when hovering over the dropdown button */
        .dropdown:hover .dropdown-content {
            display: block;
        }
    </style>
</head>
<body>
    <ul class="navbar">
        <li><a href="hrhome">Home</a></li>
        <li class="dropdown">
            <button class="dropbtn" style="font-size: 17.5px;">Leaves</button>
            <div class="dropdown-content">
                <a href="hrleave">Apply Leave</a>
                <a href="hrleavestatus">Leave Status</a>
            </div>
        </li>
        <li><a href="updatehrprofile">Update Profile</a></li>
        <li class="dropdown">
            <button class="dropbtn" style="font-size: 17.5px;">Employee</button>
            <div class="dropdown-content">
                <a href="viewempbyhr">View All Employees</a>
                <a href="deleteempbyhr">Delete Employee</a>
            </div>
        </li>
        <li><a href="hrlogout">Logout</a></li>
    </ul>
</body>
</html>
