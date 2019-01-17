<%@page contentType="text/html" pageEncoding = "UTF-8"%>
       <!DOCTYPE html>
       <html>
        <head>
              <meta http-equiv = "Content-Type" content = "text/html; charset=UTF-8">
              <title>Login Page</title>
        </head>
        <body>
              <font size = '4' color = 'blue'>
       Security information:
              </font><br>

  <form action = 'login' method = 'post'>

            <table>
              <tr><td>Login: </td><td><input type='text' name='username' size='15'></td></tr>
              <tr><td>Password: </td><td><input type='password' name='password' size='15'></td></tr>
            </table>

             <form action="/login">
                  <button type="submit">Login</button>
             </form>

             <p><a href="/user_form">Registration</a></p>

  </form>


       </body>
       </html>