<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>SoussTalents101</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">
	<style>
	.is-square{
	border-radius:0;
	}
	</style>
</head>
<body>
	<%
	if (request.getParameter("email") != null && request.getParameter("password") != null) {
		if (request.getParameter("email").equals("najib@anmoon.ma")
		&& request.getParameter("password").equals("password")) {
			response.sendRedirect("/dashboard");
	%>

	<%=request.getParameter("email")%>

	<%
	} else {
	%>
	<script>
		alert("Wrong Email or Password!");
	</script>

	<%
	}
	}
	%>

	<section class="hero is-dark is-fullheight">
		<div class="hero-header">
			<%@include file="hero-header.jsp"%>

		</div>
		<div class="hero-body">
			<div class="container">
				<div class="columns is-centered">
	
			<div class="column is-5-tablet is-4-desktop is-4-widescreen">
			
<div class="tile is-primary">
    <article class="tile is-child p-4 box has-background-white">
        <p class="title has-text-dark">
            6
        </p>
        <p class="subtitle has-text-dark">
            Category
        </p>
        <progress class="progress is-success" value="70" max="100">
            70%
        </progress>
    </article>
</div>
</div>
			<div class="column is-5-tablet is-4-desktop is-4-widescreen">

<div class="tile is-primary">
    <article class="tile is-child p-4 box has-background-white">
        <p class="title has-text-dark">
            23
        </p>
        <p class="subtitle has-text-dark">
            Task
        </p>
        <progress class="progress is-success" value="70" max="100">
            70%
        </progress>
    </article>
</div>
			</div>		
				</div>
			</div>
		</div>
		</div>

		<footer class="pb-2">
			<div class="content has-text-centered">
				<p>
					<strong> Doer </strong> by <a target="_blank"
						href="https://anmoon.ma/"> Najib Rachid, SoussTalents101. </a>

				</p>
			</div>
		</footer>
	</section>

</body>
</html>
