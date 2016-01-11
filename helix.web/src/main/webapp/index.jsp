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
<br>
<p>Helix offers high availability docker-based cloud services. Thanks to Helix, deploying webapp is never so easy. </p>
<p><a class="btn btn-primary btn-large">About Helix</a>
</p>
               <p>Helix comes in two flavors: Free and Premium. Start using Helix for free, then upgrade to Premium whenever you are ready.
Exclusive features for Premium user: <b>monitoring, migration, auto-scaling, and many more.</b> </p>
</header>

<div class="row">
            <div class="col-lg-12">
                <br>
            </div>
        </div>
        <div class="row text-center">
            <div class="col-md-5 col-sm-6 service">
                <div class="thumbnail">
                    <div class="caption"> 
                        <h3>Free</h3>
                        <p>The best way to try Helix</p>

        				<div class="row text-left"> 
							<ul> 
				  				<li>1-month trial</li>
				  				<li>Manage your containers</li>
				  				<li>Deploy application</li>
				  				<li>Link database to your webapp</li>
				  				<br/>
							</ul> 
                    	</div>
                        <p>
                           <a href="signup.jsp" class="btn btn-primary">Sign up</a> <a href="services.jsp" class="btn btn-default">Learn more</a>
                        </p>
                	</div>
                </div>
            </div>

            <div class="col-md-5 col-sm-6 service">
                <div class="thumbnail">
                    <div class="caption">
                        <h3>Premium</h3>
                        <p>Everything in your control</p>
        				<div class="row text-left">     				
							<ul>
				  				<li>Monitoring features</li>
				  				<li>Automatic back-up</li>
				  				<li>Migration support</li>
				  				<li>Zero down-time</li>
				  				<br/>
							</ul>  
                    	</div>						
                        <p>
                        <a href="signup.jsp" class="btn btn-primary">Sign up</a> <a href="services.jsp" class="btn btn-default">Learn more</a>
                        </p>
                    </div>
                </div>
            </div>
        </div>
        	<%@ include file="footer.jsp" %>

        </div>

</body>
</html>
