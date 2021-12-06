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
<div id="container">
<header>
    <nav id="navbar">
        <div id="brand">
            <i class="fas fa-2x fa-code brd-clr"></i>
            <h3>SynAck</h3>
        </div>
        <div>
            <ul>
                <li><a href="welcome.jsp">Home</a></li>
                <li><a href="about.jsp">About</a></li>
                <li><a href="login.jsp">Login</a></li>
                <li><a href="shopping-cart.jsp"><i class="fas fa-shopping-cart"></i></a></li>
            </ul>
        </div>
    </nav>
</header>

<section id="showcase">
    <div class="flex-evenly">
        <div id="form">
            <h1>Register</h1>
            <c:if test="${requestScope.alreadyExists.equalsIgnoreCase('true')}">
                <p class="error-msg">An account is already associated with this email address. </p>
            </c:if>
            <c:if test="${requestScope.nullerror.equalsIgnoreCase('true')}">
                <p class="error-msg">All fields are required to register. </p>
            </c:if>
            <form action="register" method="POST">
                <label for="firstName">First Name:</label><br>
                <input type="text" name="firstName" id="firstName"><br>
                <label for="lastName">Last Name:</label><br>
                <input type="text" name="lastName" id="lastName"><br>
                <label for="email">Email:</label><br>
                <input type="text" name="email" id="email"><br>
                <label for="username">Username:</label><br>
                <input type="text" name="username" id="username"><br>
                <label for="lastName">Password</label><br>
                <input type="password" name="password" id="password"><br>
                <input type="submit">
                <label class="hvr-change"><a href="login.jsp">Already Registered? Try Logging In.</a></label>
            </form>
        </div>
    </div>
</section>

<footer id="footer">

    <div>
        <p>Copyright &copy;
            <script>document.write(new Date().getFullYear())</script>
            SynAck Lounge LLC. All Rights Reserved.
        </p>
    </div>
</footer>
</div>
</body>

</html>