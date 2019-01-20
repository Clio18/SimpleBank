<%@page contentType="text/html" pageEncoding = "UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
       <meta http-equiv = "Content-Type" content = "text/html; charset=UTF-8">
       <title>Current Account Request</title>
 </head>
 <body>
       <font size = '3' color = 'black'>
<i>You make a request for current account creation</i><br>
<i>After submitting your request will be added to the pool of requests</i><br>
<i>Just after accepting from administrator it will appears in the list of yours account</i><br>
<i>Please put desire amount of money:</i>
       </font><br>

          <form action="/current">
          <table>
                 <tr><td></td><td><input type='double' name='money' size='15'></td></tr>
          </table>
                       <button type="submit">Request</button>
          </form>
          <p><a href="administrator.jsp">Return</a></p>

</body>
</html>