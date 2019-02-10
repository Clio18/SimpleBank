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
              <title>Main Page</title>
              <style>
                 .text {
                  text-align:  center;
                 }
               </style>
        </head>
        <body>
<div class="container" style="background-color: #cdd6e9">
        <form method = 'get'>
           <font size = '3' color = 'black'>
            <em><b>
               <%=request.getSession().getAttribute("username").toString()%>
           </b></em>
           </font>
        </form>

        <div class="text">
              <font size = '5' color = 'green'><b>
               USER PAGES
             </b></font><br>

              <font size = '4' color = 'black'>
       Make a chose:
               </font><br>
        </div>
    <ul>
        <li><a href="/show"><font size = '3' color = 'black'>Show all information</font></a></li>
        <li><a href="request.jsp"><font size = '3' color = 'black'>Make request for new account</font></a></li>
        <li><a href="payBill.jsp"><font size = '3' color = 'black'>Pay the bill</font></a></li>

        <li><a href="login.jsp"><font size = '3' color = 'black'>Exit</font></a></li>

    </ul>
</div>
       </body>
       </html>