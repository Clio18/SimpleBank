<%@page contentType="text/html" pageEncoding = "UTF-8"%>
       <!DOCTYPE html>
       <html>
        <head>
              <meta http-equiv = "Content-Type" content = "text/html; charset=UTF-8">
              <title>Change Type Page</title>
        </head>
        <body>
              <font size = '4' color = 'black'>
       Please, enter desire users login:
              </font><br>

  <form action = 'changeType' method = 'get'>

            <table>
              <tr><td>Login: </td><td><input type='text' name='login' size='15'></td></tr>
            </table>

             <form action="/changeType">
                  <button type="submit">Submit</button>
             </form>

             <p><a href="administrator.jsp">Return</a></p>

  </form>

       </body>
       </html>