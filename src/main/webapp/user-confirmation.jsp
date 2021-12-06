<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="/WEB-INF/tlds/da.tld" prefix="da" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" 
    integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
  <link rel="stylesheet" href="css/style.css"/>
  <title>SynAck | Lounge</title>
</head>

<body>
<div id="container">
  <header>
    <nav id="navbar">
      <div id="brand">
        <a href="welcome.jsp"><i class="fas fa-2x fa-code brd-clr"></i></a> 
        <h3>SynAck Lounge</h3>
      </div>
      <div>
        <ul>
          <li><a href="welcome.jsp">Home</a></li>
          <li><a href="about.jsp">About</a></li>
          <c:if test="${sessionScope.loggedIn == true}">
  	  		<li><a href="profile.jsp">Profile</a></li>
  		  </c:if>
  		  <c:if test="${sessionScope.loggedIn == null || sessionScope.loggedIn == false }">
  	  		<li><a href="login.jsp">Login</a></li>
  		  </c:if>
        </ul>
      </div>
    </nav>
  </header>

  <section id="showcase">
    <div class="flex-normal">
	 <div id="main-msg">
	 	 <h1>Thank you for <span class="brd-clr">Registering</span>!</h1>
	 	</div>
  </div>
  </section>

  <footer id="footer">

   <div>
         <p> <da:Copyright/> SynAck Lounge LLC. All Rights Reserved.</p>
    </div>
  </footer>
</div>
</body>

</html>