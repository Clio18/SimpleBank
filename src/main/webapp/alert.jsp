<%@page contentType="text/html" pageEncoding = "UTF-8"%>
       <!DOCTYPE html>
       <html>
        <head>
              <meta http-equiv = "Content-Type" content = "text/html; charset=UTF-8">
              <title>Alert Page </title>
              </head>
        <body>

        <form method = 'get'>
           <%=request.getAttribute("alert").toString()%>
        </form>

 <p><a href="/user_form">Registration</a></p>
 <p><a href="/login">Login</a></p>


       </body>
       </html>