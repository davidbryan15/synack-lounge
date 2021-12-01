<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
  <header>
    <nav id="navbar">
      <div id="brand">
        <a href="index.jsp"><i class="fas fa-2x fa-code brd-clr"></i></a> 
       <h3>SynAck Lounge</h3>
      </div>
      <div>
        <ul>
          <li><a href="welcome.jsp">Home</a></li>
          <li><a href="about.jsp">About</a></li>
          <li><a href="login.jsp" class="current">Login</a></li>
        </ul>
      </div>
    </nav>
  </header>

  <section id="showcase">
  <div class="flex-evenly">
	  <div id="form">
	      <h1>Login</h1>
	      <c:if test="${requestScope.loginerror.equalsIgnoreCase('true')}">
			<p class="error-msg">Username or password is incorrect... Please Try Again</p>
		 </c:if>
	      <form action="loginServlet?action=login" method="POST">
	        <label for="username">Username:</label><br>
	        <input type="text" name="username" id="username"><br>
	        <label for="password">Password:</label><br>
	        <input type="password" name="password" id="password"><br>
	        <input type="submit">
            <div class="flex-spc-btwn">
                <label class="hvr-change"><a href="register.jsp">Create New Account!</a></label>
                <label class="hvr-change"><a href="register.jsp">Forgot Password</a></label>
            </div>

	      </form>
	    </div>
	    <div id="attraction">
	      <i class="fas fa-6x fa-code brd-clr"></i>
	      <p>43 6f 6d 65 20 6f 6e 20 69 6e 21</p>
	    </div>
  </div>
    
  </section>

  <footer id="footer">

   <div>
         <p> <da:Copyright/> SynAck Lounge LLC. All Rights Reserved.</p>
    </div>
  </footer>

</body>

</html>