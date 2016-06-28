 function validation(){
	 
	 var lettertype=$("#lettertype").val();
	 var purpose=$("#purpose").val();
	 
	 var regexForAlphabet=/^[a-zA-Z ]+$/i;
	 var regexForAlphabetandNume=/^[0-9 ]+$/i;
	 
	 if(lettertype == ""){
		 $("#errordiv").show();
		 $("#errordiv").text("Enter  Letter Type");
		 $(".error-box").css({'visibility': 'visible'});
		 return false;
	 }else if(lettertype.match(regexForAlphabetandNume)){
		 $("#errordiv").show();
		 $("#errordiv").text("'Letter Type' field should be Alphabet");
		 $(".error-box").css({'visibility': 'visible'});
		 return false;
	 }else if(purpose == ""){
		 $("#errordiv").show();
		 $("#errordiv").text("Enter Purpose");
		 $(".error-box").css({'visibility': 'visible'});
	   return false;
	 }else if(!purpose.match(regexForAlphabet)){
		 $("#errordiv").show();
		 $("#errordiv").text("'Purpose' field  should be Alphabet");
		 $(".error-box").css({'visibility': 'visible'});
	   return false;
	 }else{
		 $("#errordiv").hide();
		 $(".error-box").css({'visibility': 'hidden'});
		 return true;
	 }
	 
	 
	 
 }