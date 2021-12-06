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
  <!-- header -->
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
          <li><a href="profile.jsp" class="current">Profile</a></li>
          <li><a href="shopping-cart.jsp"><i class="fas fa-shopping-cart"></i></a></li>
        </ul>
      </div>
    </nav>
  </header>

  <!-- main -->
 <section id="showcase">
   <div class="flex-evenly">
	  <div id="form">
	      <h1>Here are you Account Details</h1>
	      <form action="loginServlet?action=logout" method="POST">
                  <p>Username:  <span class="brd-clr">${sessionScope.user.credentials.username}</span></p><br>
                  <p>First Name:  <span class="brd-clr">${sessionScope.user.firstName}</span></p><br>
                  <p>Last Name:  <span class="brd-clr">${sessionScope.user.lastName}</span></p><br>
                  <p>Email:  <span class="brd-clr">${sessionScope.user.email}</span></p><br>
                  <br/>
                  <p><a href="#" class="hvr-change">Change Username or Password</a></p>
                  <br/><br/>
	        <input type="submit" value="Logout">
	      </form>
	    </div>
	    <div id="attraction">
	      <i class="fas fa-6x fa-code brd-clr"></i>
	      <p>57 65 6c 63 6f 6d 65</p>
	    </div>
  </div>
 </section>

  <!-- footer -->
  <footer id="footer">

    <div>
         <p> <da:Copyright/> SynAck Lounge LLC. All Rights Reserved.</p>
    </div>
  </footer>
</div>
</body>

</html>