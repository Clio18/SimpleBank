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
        <li><a href="deposit.jsp">Put a deposit</a></li>

    </ul>

       </body>
       </html>