document.onmousedown = disableclick; status = "Right Click Disabled";
  function disableclick(event) { 
	  if (event.button == 2) { 
		  alert(status); 
		  return  false; 
		 } 
	  }
  $(document).ready(function(){
	  $("#errordiv").hide();
	  setTimeout(function(){
		  $.ajax({
			  url:"ContactUsMail.do?method=removeSessionObject",
			  async:false,
			  success:function(){
				  $("#errordiv").hide();
				  $("#successMessage").hide();
			  }
		  });
		
	  },4000);
  });

			function validate() {
				$('#checkFormFiled').val("Form Filed Properly");
				
				var bValid = true;
				var mailSub = $("#mailSub"), mailContent = $("#mailContent"), mailFrom = $("#mailFrom"), cusMobile = $("#cusMobile");
				
						tips = $("#errordiv");
				var bValid = true;
			
				bValid = bValid && checkRegexpText(mailSub,
								/^(.)+$/,
								"Please Enter Subject");
			
				bValid = bValid && checkRegexpText(mailContent,
								/^(.)+$/i,
								"Please Describe Your Problem");
			
				bValid = bValid && checkRegexpText(	mailFrom,
						/^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/,
								"Please Enter Valid Email Id");
				bValid = bValid && checkRegexpText( cusMobile,
						/^[0-9]+$/i,
						"Mobile No Should be Numeric");
				if(bValid){
					
					$("#loader").show();
					$("#sendMail").hide();
				}		
				
				return bValid;
			}
			
			function updateTips(t) {
				$("#errordiv").show();
				tips.text(t).addClass("ui-state-highlight");
				setTimeout(function() {
				tips.removeClass("ui-state-highlight", 500);
			}, 500);
		}
	
	 function checkRegexpText( o, regexp, n ) {
	             if ( !( regexp.test( o.val() ) ) ) {
	             o.addClass( "ui-state-error" );
	             updateTips(n);
	             return false;
	            } else {
				o.removeClass("ui-state-error");
	            return true;
	            }
	      }
	