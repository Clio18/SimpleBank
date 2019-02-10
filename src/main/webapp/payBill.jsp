<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css" integrity="sha384-PmY9l28YgO4JwMKbTvgaS7XNZJ30MK9FAZjjzXtlqyZCqBY6X6bXIkM++IkyinN+" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap-theme.min.css" integrity="sha384-jzngWsPS6op3fgRCDTESqrEJwRKck+CILhJVO5VvaAZCq8JYf8HsR/HPpBOOPZfR" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js" integrity="sha384-vhJnz1OVIdLktyixHY4Uk3OHEwdQqPppqYR8+5mjsauETgLOcEynD9oPHhhz18Nw" crossorigin="anonymous"></script>


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
        <tr><td>Money</td><td><input type='integer' name='money' size='15'></td></tr><br>
     </table><br>
     <button type="submit">
        Pay
     </button>
</form>

       </font><br>
          <a href="mainPage.jsp" class="btn btn-primary" role="button">Return</a>
</body>
</html>