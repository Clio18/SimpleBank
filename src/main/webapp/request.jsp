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
              <title>Request Page </title>
              <style>
                 .text {
                  text-align:  center;
                 }
               </style>
        </head>
        <body>

        <form method = 'get'>
                  <name='username'>
                  <%=request.getSession().getAttribute("username").toString()%>
        </form>

        <div class="text">
              <font size = '5' color = 'green'>
               REQUEST ACCOUNT PAGE
              </font><br>
              <font size = '4' color = 'black'>
       Chose desire account:
               </font><br>
        </div>


      <ul>
        <li><a href="current.jsp">Create current account</a></li>
        <li><a href="credit.jsp">Take a credit</a></li>


    </ul>
    <a href="mainPage.jsp" class="btn btn-primary" role="button">Return</a>

       </body>
       </html>