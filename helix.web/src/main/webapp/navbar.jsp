<%-- CSS --%>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css"/>
<link rel="stylesheet" href="css/helix.css"/>
<link rel="stylesheet" href="https://cdn.datatables.net/plug-ins/28e7751dbec/integration/bootstrap/3/dataTables.bootstrap.css"/>

<%-- Font --%>
<link href='https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,300,600' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=PT+Sans:400,700' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Oxygen:300,400,700' rel='stylesheet' type='text/css'>

<%-- JavaScript --%>
<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/validator.js"></script>
<script src="http://code.highcharts.com/highcharts.js"></script>

<%-- JSTL --%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.Customer"%>
<%@page import="model.Container"%>
<%@page import="daoImpl.DatabaseConnection"%>
<%@page import="daoImpl.ContainerDaoImpl"%>

<%	
	Customer c = null ;
	String account = null ;
	if(request.getSession().getAttribute("user") != null){
		c = (Customer)request.getSession().getAttribute("user");
		account = c.getAccount();
	}
%>
	
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <%if (account == null){%>
                <a class="navbar-brand" href="index.jsp">Helix</a>
            <%}
           else if(account.equals("free")){%>
           <a class="navbar-brand" href="index.jsp">Helix</a>
           <%
            }
           else {%>
            <a class="navbar-brand" href="index.jsp">Helix Premium</a>
            <% } %>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
            
                                        <%
            if(session.getAttribute("user") != null){
            %>
                <li>
                    <a href="userhome.jsp">Dashboard</a>
                </li>
            <% 
            }
            %>
            
            <%
            if(session.getAttribute("user") == null){
            %>
                <li>
                    <a href="signup.jsp">Sign up</a>
                </li>
                <li>
                    <a href="login.jsp">Login</a>
                </li>
            <% 
            }
            %>
                
                <li>
                    <a href="services.jsp">Services</a>
                </li>
                <li>
                    <a href="about.jsp">About</a>
                </li>
                 <li>
                    <a href="contact.jsp">Contact</a>
                </li>
                
                                            <%
            if(session.getAttribute("user") != null){
            %>
                <li>
                    <a href="${pageContext.request.contextPath}/Logout">Log out</a>
                </li>
            <% 
            }
            %>
                

            </ul>
        </div>
    </div>
</nav>
