<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <title>SoussTalents101</title>
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css"
    />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">
  </head>
  <body>


    <section class="hero is-dark is-fullheight">
        <div class="hero-header">
			<%@include file="hero-header.jsp"%>
        </div>
        <div class="hero-body">
          <div class="container">
            <div class="columns is-centered">
              <div class="column is-5-tablet is-4-desktop is-3-widescreen">
                <form id="signInForm"  action="SignIn" class="box" >
                  <div class="field">
                    <label for="" class="label">Email</label>
                    <div class="control has-icons-left">
                      <input type="email" placeholder="e.g. jhon-doe@gmail.com" name="email" value="najib@anmoon.ma" class="input" required>
                      <span class="icon is-small is-left">
                        <i class="fa fa-envelope"></i>
                      </span>
                    </div>
                  </div>
                  <div class="field">
                    <label for="" class="label">Password</label>
                    <div class="control has-icons-left">
                      <input type="password" placeholder="*******" class="input" name="password" value="password" required>
                      <span class="icon is-small is-left">
                        <i class="fa fa-lock"></i>
                      </span>
                    </div>
                  </div>
                  <div class="field">
                    <button class="button is-info">
                      Sign-in
                    </button>
                  </div>
                  <div class="field is-size-7 has-text-right mt-2">
                     You Don't Have An Account? <a class="has-text-weight-bold" href="signup.jsp">Sign-up</a>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>

      <footer class="pb-2">
    <div class="content has-text-centered">
        <p>
            <strong>
                Doer
            </strong>
            by
            <a target="_blank" href="https://anmoon.ma/">
                Najib Rachid, SoussTalents101.
                
            </a>
            
        </p>
    </div>
</footer>
           </section>
           <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
  <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10.10.1/dist/sweetalert2.all.min.js"></script>
  
   <script>
// this is the id of the form

var toastMixin = Swal.mixin({
    toast: true,
    icon: 'success',
    title: 'General Title',
    animation: false,
    position: 'top-right',
    showConfirmButton: false,
    timer: 3000,
    timerProgressBar: true,
    didOpen: (toast) => {
      toast.addEventListener('mouseenter', Swal.stopTimer)
      toast.addEventListener('mouseleave', Swal.resumeTimer)
    }
  });


   $("#signInForm").submit(function(e) {
	   

       e.preventDefault(); // avoid to execute the actual submit of the form.

       var form = $(this);
       var actionUrl = form.attr('action');
       
       $.ajax({
           type: "POST",
           url: actionUrl,
           data: form.serialize(), // serializes the form's elements.
           success: function(data)
           {
        	   if(data.response=="true"){
        		   location.assign('dashboard.jsp');

        	   }else{
        		   
        		   toastMixin.fire({
        			    title: data.response,
        			    icon: 'error'
        			  });
        	   }
        	  

           }
       });
       
   });
   
   </script>
   
  </body>
</html>
