<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tlds/da.tld" prefix="da"%>
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
    <%--main container--%>
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
                        <li><a href="welcome.jsp" class="current">Home</a></li>
                        <li><a href="about.jsp">About</a></li>
                        <c:if test="${sessionScope.loggedIn == true}">
                            <li><a href="profile.jsp">Profile</a></li>
                        </c:if>
                        <c:if test="${sessionScope.loggedIn == null || sessionScope.loggedIn == false }">
                            <li><a href="login.jsp">Login</a>
                        </c:if>
                        <li><a href="shopping-cart.jsp"><i class="fas fa-shopping-cart"></i></a></li>
                    </ul>
                </div>
            </nav>
        </header>

        <!-- main -->
        <section id="showcase">
            <div class="flex-column">
                <div>
                    <h1>Welcome ${sessionScope.user.firstName} to <span class="brd-clr">SynAck</span> | <span class="brd-clr">Lounge</span></h1>
                </div>
                <div><p><em>You're one-stop shop for everything technology!</em></p></div>
                <div id="products">
                    <c:forEach var="product" items="${sessionScope.products}">
                    <%--Hidden url to send product ID to servlet when form Submit is selected--%>
                            <c:url var="addproduct" value="/addproduct">
                                <c:param name="productId" value="${product.productId}"/>
                            </c:url>
                    <%--Form to redirect to servlet--%>
                        <form action="${addproduct}" method="POST">
                            <div class="single-product">
                                <c:set var="productid" value="${product.productId}"/>
                                <img src="${product.productImgUrl}" alt="product_img">
                                <h2>${product.productName}</h2>
                                <p>Price: <fmt:setLocale value="en_us"/>
                                          <fmt:formatNumber value="${product.productPrice}" type="currency"/> </p>
<%--                                <fmt:setLocale value="en_us"/>--%>
<%--                                <fmt:formatNumber value="${product.productPrice}" type="currency"/>--%>
                                <p>Quantity: ${product.productQuantity}</p>
                                <input type="number" name="quantity" value="1" min="1" max="${product.productQuantity}">
                                <input type="submit" value="Add to Cart">
                            </div>
                        </form>
                    </c:forEach>
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