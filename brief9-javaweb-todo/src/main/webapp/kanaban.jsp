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
				<div class="column ">
				

							<section class="container">
<div class="level-item">
<div class="columns is-multiline is-centered cards-container" id="sectioncontainer">
    <div class="column is-narrow">
        <article class="message is-black">
            <div class="message-header">
                <p>To DO</p>
            </div>
            <div class="message-body">
                <div class="board-item">
                    <div class="board-item-content"><span>The Fort</span></div>
                </div>
                <div class="board-item">
                    <div class="board-item-content"><span>Fist Like a bullet</span></div>
                </div>

            </div>
        </article>
    </div>

    <div class="column is-narrow">
        <article class="message is-link">
            <div class="message-header">
                <p>Done</p>
            </div>
            <div class="message-body">
                <div class="board-item">
                    <div class="board-item-content"><span>Enter the Phoenix</span></div>
                </div>
                <div class="board-item">
                    <div class="board-item-content"><span>Moon Rises, Raven Seeks</span></div>
                </div>
                
            </div>
        </article>
    </div>
    
        <div class="column is-narrow">
        <article class="message is-primary">
            <div class="message-header">
                <p>Doing</p>
            </div>
            <div class="message-body">
                <div class="board-item">
                    <div class="board-item-content"><span>Tiger Pushes Mountain</span></div>
                </div>
                <div class="board-item">
                    <div class="board-item-content"><span>Force of Eagle's Claw</span></div>
                </div>
               
            </div>
        </article>
    </div>

   
</div>
</div>
</section>
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
