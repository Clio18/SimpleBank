<%@page contentType="text/html" pageEncoding = "UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
       <meta http-equiv = "Content-Type" content = "text/html; charset=UTF-8">
       <title>Pay Bill</title>
 </head>
 <body>
       <font size = '4' color = 'black'>
       <center>
<i>You may pay your bills here</i><br>
       </center>
       </font><br>

<font size = '3' color = 'black'>
<form action="/payment">
     <i>Please enter your current account number</i><br>
     <i>Please enter the number of desire account for payment</i><br>
     <i>Please put desire amount of money:</i><br>

     <table>
        <tr><td>Current account number</td><td><input type='integer' name='current_id' size='15'></td></tr>
        <tr><td>Number of desire account</td><td><input type='integer' name='desire_id' size='15'></td></tr>
        <tr><td>Money</td><td><input type='integer' name='money' size='15'></td></tr>
     </table>
     <button type="submit">
        Pay
     </button>
</form>

       </font><br>
          <p><a href="mainPage.jsp">Return</a></p>
</body>
</html>