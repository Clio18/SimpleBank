<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding = "UTF-8"%>
       <!DOCTYPE html>
       <html>
        <head>
              <meta http-equiv = "Content-Type" content = "text/html; charset=UTF-8">
              <title>Alert ID Page</title>
        </head>
        <body>
              <font size = '4' color = 'pink'>
       Alert ID list:
              </font><br>


  <c:forEach var="num" items="${alertList}">
   <tr>
      <td>${num}</td><br>
   </tr>
  </c:forEach>
   <p><a href="requestOperation.jsp">Return</a></p>


  </body>
       </html>