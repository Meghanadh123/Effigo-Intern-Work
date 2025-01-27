<%@ page contentType="text/html; charset=ISO-8859-1" isELIgnored="false"%>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <style>
        
    </style>
</head>
<body>
    <%@ include file="empnavbar.jsp" %>
    <h3 align=right>Hi, ${ename}</h3>

    <div class="c1">
    <h3 align="center"><u>Apply Leave</u></h3>
    <form method="post" action="insertleave">
        <table>
        <tr>
                <th><label>EMPLOYEE ID</label></th>
                <td><input type="text" name="empid" required="required"/></td>
            </tr>
            <tr>
                <th><label>FROM</label></th>
                <td><input type="date" name="fromd" required="required"/></td>
            </tr>
            <tr>
                <th><label>TO</label></th>
                <td><input type="date" name="tod" required="required"/></td>
            </tr>
            <tr>
                <th><label>Leave Type</label></th>
                <td>
                    <select name="leavetype" required>
                        <option value="">---Select---</option>
                        <option value="medical">MEDICAL</option>
                        <option value="normal">NORMAL</option>
                        <option value="emergency">EMERGENCY</option>
                        <option value="casual">MONTHLY</option>
                    </select>
                </td>
            </tr>
            
            <tr>
                <th><label>REASON</label></th>
                <td><input type="text" name="reason" required/></td>
            </tr>
            
            <tr align="center">
                <td colspan="2"><input type="submit" value="Apply" class="button"></td>
            </tr>
        </table>
    </form>
    </div>
</body>
</html>
