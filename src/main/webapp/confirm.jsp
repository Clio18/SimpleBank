<%@page contentType="text/html" pageEncoding = "UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
       <meta http-equiv = "Content-Type" content = "text/html; charset=UTF-8">
       <title>Confirm Request</title>
 </head>
 <body>
       <font size = '3' color = 'black'>
<i>Please, confirm request ID:</i>
       </font><br>

          <form action="/confirm">
          <table>
                 <tr><td></td><td><input type='int' name='id' size='15'></td></tr>
          </table>
                       <button type="submit">Confirm</button>
          </form>
          <p><a href="administrator.jsp">Return</a></p>

</body>
</html>