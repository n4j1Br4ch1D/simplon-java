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
						<form method="post" action="" class="box">
							<div class="field">
								<div class="columns row-one">
									<div class="column">
										<label class="label" for="firstName">First Name</label>
										<div class="control">
											<input class="input" type="text" placeholder="First Name"
												name="firstName">
										</div>
									</div>
									<div class="column">
										<label class="label" for="lastName">Last Name</label>
										<div class="control">
											<input class="input" type="text" placeholder="Last Name"
												name="lastName">
										</div>
									</div>
								</div>
							</div>
							<div class="field">
								<label for="" class="label">Email</label>
								<div class="control has-icons-left">
									<input type="email" placeholder="e.g. jhon-doe@gmail.com"
										name="email" value="najib@anmoon.ma" class="input" required>
									<span class="icon is-small is-left"> <i
										class="fa fa-envelope"></i>
									</span>
								</div>
							</div>
							<div class="field">
								<label for="" class="label">Password</label>
								<div class="control has-icons-left">
									<input type="password" placeholder="*******" class="input"
										name="password" value="password" required> <span
										class="icon is-small is-left"> <i class="fa fa-lock"></i>
									</span>
								</div>
							</div>
							<div class="field">
								<label for="" class="label">Repeat Password</label>
								<div class="control has-icons-left">
									<input type="password" placeholder="*******" class="input"
										name="re-password" value="password" required> <span
										class="icon is-small is-left"> <i class="fa fa-lock"></i>
									</span>
								</div>
							</div>
				
                            <div class="field">
								<button class="button is-info">Sign-in</button>
							</div>
		
							<div class="field is-size-7 has-text-right mt-2">
								You Already Have An Account? <a class="has-text-weight-bold"
									href="signin.jsp">Sign-In</a>
							</div>
							
						</form>
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
