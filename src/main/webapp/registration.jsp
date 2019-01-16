<%@page contentType="text/html" pageEncoding = "UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
       <meta http-equiv = "Content-Type" content = "text/html; charset=UTF-8">
       <title>Registration Page </title>
 </head>
 <body>
       <font size = '4' color = 'green'>
Please fill the registration form:
       </font><br>

       <form action = 'user_form' method = 'post'>

     <table>
       <tr><td>Name: </td><td><input type='text' name='name' size='15'></td></tr>
       <tr><td>Last Name: </td><td><input type='text' name='lastName' size='15'></td></tr>
       <tr><td>Login: </td><td><input type='text' name='login' size='15'></td></tr>
       <tr><td>Password: </td><td><input type='password' name='password' size='15'></td></tr>
     </table>

     <br><input type="submit" value="login">
      </form>
</body>
</html>