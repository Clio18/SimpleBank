<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding = "UTF-8"%>
       <!DOCTYPE html>
       <html>
        <head>
              <meta http-equiv = "Content-Type" content = "text/html; charset=UTF-8">
              <title>Login Page </title>
        </head>
        <body>
              <font size = '4' color = 'blue'>
       User information:
              </font><br>

<table border=1>
  <c:forEach var="num" items="${info}">
   <tr>
      <td>${num}</td>
   </tr>
  </c:forEach>
</table>



       </body>
       </html>