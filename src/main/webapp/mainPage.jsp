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
        <div class="text">
              <font size = '5' color = 'green'>
               USER PAGES
              </font><br>
              <font size = '4' color = 'black'>
       Make a chose:
               </font><br>
        </div>

          <form method = 'get'>
          <name='username'>
          <%=request.getParameter("j_username")%>
          </form>

    <ul>
        <li><a href="/show">Show all information</a></li>
        <li><a href="request.jsp">Make request for new account</a></li>
        <li><a href="payment.jsp">Pay the bill</a></li>
        <li><a href="transfer.jsp">Money transfer</a></li>

    </ul>

       </body>
       </html>