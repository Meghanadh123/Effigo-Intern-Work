<!DOCTYPE html>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <title>Admin Navbar</title>
    <style>
        /* Add CSS for the navbar */
        ul.navbar {
            list-style-type: none;
            margin: 0;
            padding: 0;
            background-color: #3498db; /* Background color */
            overflow: hidden;
            border-radius: 10px; /* Add border radius for curved edges */
        }

        ul.navbar li {
            float: left; /* Align all contents to the left */
        }

        ul.navbar li a {
            display: block;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        ul.navbar li a:hover {
            background-color: #f39c12; /* Background color on hover */
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
            background-color: #3498db; /* Background color */
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
            background-color: #f39c12; /* Background color on hover */
        }

        /* Show the dropdown content when hovering over the dropdown button */
        .dropdown:hover .dropdown-content {
            display: block;
        }

        h3 {
            text-align: right;
        }
    </style>
</head>
<body>
    <ul class="navbar">
        <li><a href="adminhome">Home</a></li>
        <li class="dropdown">
            <button class="dropbtn" style="font-size: 17.5px">HR</button>
            <div class="dropdown-content">
                <a href="addhr">Add HR</a>
                <a href="viewallhr">View all HR</a>
                <a href="deletehr">Delete HR</a>
                <a href="updatestatushr">Update HR</a>
            </div>
        </li>
        <li class="dropdown">
            <button class="dropbtn" style="font-size: 17.5px">Employee</button>
            <div class="dropdown-content">
                <a href="viewallemps">View All Employees</a>
                <a href="deleteemp">Delete Employee</a>
                <a href="updatestatus">Update Status</a>
            </div>
        </li>
        <li class="dropdown">
            <button class="dropbtn" style="font-size: 17.5px">Leaves</button>
            <div class="dropdown-content">
                <a href="approvedleaves">Approved Leaves</a>
                <a href="rejectedleaves">Rejected Leaves</a>
                <a href="viewallleaves">Leave Requests</a>
            </div>
        </li>
        <li><a href="adminlogin">Logout</a></li>
    </ul>
    <h3 align="right">Hi Admin</h3>
</body>
</html>
