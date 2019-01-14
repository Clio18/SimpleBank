<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding = "UTF-8"%>
       <!DOCTYPE html>
       <html>
        <head>
              <meta http-equiv = "Content-Type" content = "text/html; charset=UTF-8">
              <title>Login Page </title>
        </head>
        <body>
              <font size = '4' color = 'pink'>
       Alert list:
              </font><br>


  <c:forEach var="num" items="${alertList}">
   <tr>
      <td>${num}</td><br>
   </tr>
  </c:forEach>
   <p><a href="/user_form">Registration</a></p>


  </body>
       </html>