<!doctype html>
<html lang="en">
<head>
	<%@ include file="navbar.jsp" %>
    <title>Helix - Cloud service provider</title>
</head>
<body>
<div class="container">
<header class="jumbotron spacer">
<h3>Deploy your application right away.</h3>
            <p>Helix offers high availability docker-based cloud services.</p>
            </br>
            <p align="justify">Thanks to Helix, you will be able to create, manage, and backup containers, where you will be able to deploy databases and servers.</p>
            <p align="justify">Helix comes in two flavors, try the free version to deploy your first containers; and when you feel ready, go for the <a href="#" data-toggle="tooltip" title="Just pay for what you actualy use!">pay as you go</a> version;
             where you will be able to access to some advanced features like <b>container monitoring, container cloning, and more!</b> </p>
            </br>
            <a href="#" data-toggle="popover" title="Using Helix" data-content="The interface of Helix enables users to rapidly configure and manage containers. Use Helix to avoid leading directly with docker containers, servers and databases initial configurations.">Why use Helix?</a>
            </br></br>
            <p><a class="btn btn-primary btn-large">About Helix</a>
            </p>
        </header>
        <hr>
        <div class="row">
            <div class="col-lg-12">
                <h3>Services</h3>
                <br>
            </div>
        </div>
        <div class="row text-center">
            <div class="col-md-5 col-sm-6 service">
                <div class="thumbnail">
                    <img src="images/Free_Version.PNG" alt="Free" height="400" width="300">
                    <div class="caption"> 
                        <h3>Free</h3>
                        <p>The best way to try Helix cloud service</p>
						</br>
        				<div class="row text-left"> 
							<ul> 
				  				<li>Create an account to access to your containers.</li>
				  				<li>Availability</li>
								<ul>
									<li>90% Availability.</li>
									<li>Downtime per year: 35.5 days.</li>
									<li>Downtime per month: 72 hours.</li>
									<li>Downtime per week: 16.8 hours.</li>
								</ul>
							</ul> 
							</br></br></br>
                    	</div>
                        <p>
                            <a href="signup.jsp" class="btn btn-primary">Sign up</a> <a href="services.jsp" class="btn btn-default">Learn more</a>
                        </p>
                	</div>
                </div>
            </div>

            <div class="col-md-5 col-sm-6 service">
                <div class="thumbnail">
                    <img src="images/Pay_as_you_go.PNG" alt="Premium" height="400" width="300">
                    <div class="caption">
                    </br></br>
                        <h3>Pay-as-you-go</h3>
                        <p>The premium services</p>
        				<div class="row text-left">  
        				</br>       				
							<ul>
				  				<li>Monitor your containers.</li>
				  				<li>Database automatic back-up.</li>
				  				<li>Clone your containers.</li>
				  				<li>Availability</li>
								<ul>
									<li>95% Guaranteed Availability.</li>
									<li>Downtime per year: 18.25 days.</li>
									<li>Downtime per month: 36 hours.</li>
									<li>Downtime per week: 8.4 hours.</li>
								</ul>
							</ul>  
							</br>
                    	</div>						
                        <p>
                        <a href="signup.jsp" class="btn btn-primary">Sign up</a> <a href="services.jsp" class="btn btn-default">Learn more</a>
                        </p>
                    </div>
                </div>
            </div>
        </div>
        <hr>
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; Helix 2015</p>
                </div>
            </div>
        </footer>
    </div>
    
    <script>
$(document).ready(function(){
    $('[data-toggle="tooltip"]').tooltip();   
});
</script>
    
    <script>
$(document).ready(function(){
    $('[data-toggle="popover"]').popover();   
});
</script>
</body>
</html>
