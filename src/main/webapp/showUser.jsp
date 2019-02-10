<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css" integrity="sha384-PmY9l28YgO4JwMKbTvgaS7XNZJ30MK9FAZjjzXtlqyZCqBY6X6bXIkM++IkyinN+" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap-theme.min.css" integrity="sha384-jzngWsPS6op3fgRCDTESqrEJwRKck+CILhJVO5VvaAZCq8JYf8HsR/HPpBOOPZfR" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js" integrity="sha384-vhJnz1OVIdLktyixHY4Uk3OHEwdQqPppqYR8+5mjsauETgLOcEynD9oPHhhz18Nw" crossorigin="anonymous"></script>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding = "UTF-8"%>
       <!DOCTYPE html>
       <html>
        <head>
              <meta http-equiv = "Content-Type" content = "text/html; charset=UTF-8">
              <title>Show User Page </title>
        </head>
        <body>


 <a href="mainPage.jsp" class="btn btn-primary" role="button">Return</a><br><br>

<div class="p-3 mb-2 bg-info text-white">
              <font size = '4' color = 'RoyalBlue'>
                 <center>
                   <b>User information:</b>
                 </center>
               </font>
               <table style="width:40%">
                <tr>
                   <th>Firstname</th>
                   <th>Lastname</th>
                   <th>Login</th>
                   <th>Password</th>
                   <th>Type</th>
                   <th>Id</th>
                 </tr>
                <c:forEach var="num" items="${info}">
                  <tr>
                   <td>${num.name}</td>
                   <td>${num.lastName}</td>
                   <td>${num.login}</td>
                   <td>${num.password}</td>
                   <td>${num.type}</td>
                   <td>${num.id}</td>
                 </tr>
                 </c:forEach>
               </table><br>
</div>

<div class="row">
          <div class="col-xs-6">
              <font size = '4' color = 'RoyalBlue'>
                 <center>
                   <b>Account information:</b>
                 </center>
              </font>
            <table style="width:90%">
                <tr>
                   <th>Number</th>
                   <th>Money</th>
                   <th>Type</th>
                </tr>
                <c:forEach var="nu" items="${accounts}">
                  <tr>
                   <td>${nu.id}</td>
                   <td>${nu.money}</td>
                   <td>${nu.type}</td>
                </tr>
                 </c:forEach>
             </table><br>
          </div>

          <div class="col-xs-6">
              <font size = '4' color = 'RoyalBlue'>
                 <center>
                    <b>Credit Account information:</b>
                 </center>
              </font>
                          <table style="width:90%">
                              <tr>
                                 <th>Number</th>
                                 <th>Money</th>
                                 <th>Type</th>
                                 <th>SumRate</th>
                                 <th>Duration</th>
                                 <th>Withdraw</th>
                              </tr>
                              <c:forEach var="nu" items="${creditAccounts}">
                                <tr>
                                 <td>${nu.id}</td>
                                 <td>${nu.money}</td>
                                 <td>${nu.type}</td>
                                 <td>${nu.sumRate}</td>
                                 <td>${nu.duration}</td>
                                 <td>${nu.withdraw}</td>
                               </tr>
                               </c:forEach>
                           </table><br>
          </div>
        </div>
<div class="p-3 mb-2 bg-success text-white">
         <font size = '4' color = 'RoyalBlue'>
                 <center>
                   <b>Activity:</b>
                 </center>
              </font>

               <table style="width:90%">
                              <tr>
                                 <th>Account type</th>
                                 <th>Money</th>
                                 <th>Date</th>
                                 <th>Message</th>
                              </tr>
                              <c:forEach var="num" items="${history}">
                                <tr>
                                 <td>${num.account_type}</td>
                                 <td>${num.money}</td>
                                 <td>${num.date}</td>
                                 <td>${num.message}</td>
                                </tr>
                               </c:forEach>
                             </table><br>
</div>

 <a href="mainPage.jsp" class="btn btn-primary" role="button">Return</a><br><br>
       </body>
       </html>