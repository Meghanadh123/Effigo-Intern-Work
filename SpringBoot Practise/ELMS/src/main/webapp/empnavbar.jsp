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
            background-color: #555; /* Change the background color on hover */
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
            font-size: 18px; /* Increase the font size to 18px (you can adjust it) */
        }

        /* Change color of dropdown links on hover */
        .dropdown-content a:hover {
            background-color: #555; /* Change the background color on hover */
        }

        /* Increase the font size for the Logout link */
        ul.navbar li:last-child a {
            font-size: 18px; /* Increase the font size for the Logout link */
        }

        /* Show the dropdown content when hovering over the dropdown button */
        .dropdown:hover .dropdown-content {
            display: block;
        }
    </style>
</head>
<body>
    <ul class="navbar">
        <li><a href="emphome">Home</a></li>
        <li class="dropdown">
            <button class="dropbtn" style="font-size: 17.5px;">Leaves</button>
            <div class="dropdown-content">
                <a href="applyleave">Apply Leave</a>
                <a href="employeeappliedleaves">Leave Status</a>
            </div>
        </li>
        <li><a href="updateprofile">Update Profile</a></li>
        <li><a href="emplogout">Logout</a></li>
    </ul>
</body>
</html>
