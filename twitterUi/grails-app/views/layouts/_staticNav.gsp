<!-- Static navbar -->
    <div class="navbar navbar-default navbar-static-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">ExiseApp</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="${createLink(uri: '/') }">Home</a></li>
            <li><a href="${createLink(controller:'upload') }">Upload</a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">Tax Forms <span class="caret"></span></a>
              <ul class="dropdown-menu" role="menu">
                <li><a href="#">Form 1</a></li>
                <li><a href="#">Form 2</a></li>
                <li><a href="#">Form 3</a></li>
              </ul>
            </li>
            <sec:ifLoggedIn>
            <li><a href="${createLink(controller:'edit', action:'multiple') }">Edit Import</a></li>
            </sec:ifLoggedIn>
          </ul>
          <ul class="nav navbar-nav navbar-right">
          	<sec:ifNotLoggedIn>
            	<li><a href="${createLink(controller:'login') }">Login</a></li>
            </sec:ifNotLoggedIn>
            <sec:ifLoggedIn>
            	<li class="dropdown">
            	<a href="#" class="dropdown-toggle" data-toggle="dropdown"><sec:loggedInUserInfo field="username"/><span class="caret"></span></a>
      				<ul class="dropdown-menu" role=menu">
      					<li><g:remoteLink class="logout" controller="logout" method="post" asynchronous="false" onSuccess="location.reload()">Logout</g:remoteLink></li>
      				</ul>
      				</li>      	
            </sec:ifLoggedIn>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>
		<div class="container">	