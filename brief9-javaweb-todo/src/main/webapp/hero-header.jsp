      

    <section class="hero is-info is-medium">
      <div class="hero-body p-5">
        <div class="container has-text-centered">
          <br />
          <img src="img/doer.PNG" class="is-48x48" style="height:32px"/>
          
          <%
          //HttpSession session=request.getSession(false);  
          //String n=(String)session.getAttribute("email");  
          %>
          <h1 class="title is-1">Doer ToDo Web App</h1>

          <h2 class="subtitle is-5">
            Make it Work..., Make it Right..., Make it Fast...
          </h2>
        </div>
      </div>
    </section> 
    
<%
 String currentName = this.getClass().getSimpleName().replaceAll("_", ".");
 %>
 <% if(!currentName.equals("signin.jsp") && !currentName.equals("signup.jsp")){ %>
<div class="is-flex">
<a href="dashboard.jsp" class="button <% if(currentName.equals("dashboard.jsp")){ %> is-info <% } else { %> is-dark <% } %> is-square">
   <i class="fa fa-tachometer mr-1" aria-hidden="true"></i> Dashboard
</a>		
<a href="tasks.jsp" class="button <% if(currentName.equals("tasks.jsp")){ %> is-info <% } else { %> is-dark <% } %> is-square">
  <i class="fa fa-tasks mr-1" aria-hidden="true"></i> Tasks
</a>
		
<a href="categories.jsp" class="button <% if(currentName.equals("categories.jsp")){ %> is-info <% } else { %> is-dark <% } %> is-square">
   <i class="fa fa-tags mr-1" aria-hidden="true"></i> Categories
</a>
		
<a href="kanaban.jsp" class="button <% if(currentName.equals("kanaban.jsp")){ %> is-info <% } else { %> is-dark <% } %> is-square">
   <i class="fa fa-window-maximize mr-1" aria-hidden="true"></i>  Kanaban Board
</a>
<div class="ml-auto">
	<a href="profile.jsp" class="button <% if(currentName.equals("profile.jsp")){ %> is-info <% } else { %> is-dark <% } %> is-square">
 <i class="fa fa-user-circle mr-1" aria-hidden="true"></i>
  Profile
</a>	
	<a  href="sign-out.jsp" class="button is-dark ">
  <i class="fa fa-sign-out mr-1" aria-hidden="true"></i>
  Sign-out
</a>
</div>	
		</div>
	<% } %>	