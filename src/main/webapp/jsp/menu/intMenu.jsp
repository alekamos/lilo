<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>


<nav class="navbar navbar-default navbar-custom">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="gotoDashboard">Lifelog</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
				<li><a class="upper-case" href="gotoModuleTypeManagement">module management</a></li>
				<li class="dropdown"><a href="#" class="upper-case" data-toggle="dropdown">search<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a class="upper-case" href="viewModule?moduleFinder.criteria=mstrcnt">last day</a></li>
						<li><a class="upper-case" href="viewModule?moduleFinder.criteria=rnd">random day</a></li>
						<li><a class="upper-case" href="gotoSearchModule">search day</a></li>
					</ul></li>

				<li class="dropdown"><a href="#" class="upper-case" data-toggle="dropdown">write<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a class="upper-case" href="gotoWriteModule">write module</a></li>
						<li><a class="upper-case" href="gotoMassiveImport">massive import</a></li>
					</ul></li>


				<li class="divider"></li>
				<li class="dropdown"><a href="#" class="upper-case" data-toggle="dropdown"><c:out
							value="${session.user.name} ${session.user.surname}" /> <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a class="upper-case" href="">Settings</a></li>
						<li class="divider"></li>
						<li><a class="upper-case" href="logout">Logout</a></li>
					</ul></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>


