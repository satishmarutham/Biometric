$(document)
		.ready(
				function() {
					
				$.ajax({
						url:"expensesReport.do?method=getAllAcadamicYears",
						async:false,
						success : function(data) {
							var result = $.parseJSON(data);
				
							for ( var j = 0; j < result.acadamicYearlist.length; j++) {

								$("#year").append(
												'<option value="'
														+ result.acadamicYearlist[j].acadamicyearcode
														+ '">'
														+ result.acadamicYearlist[j].acadamicyear
														+ '</option>');
							}
					
						
						}
					});
					
					
					var hmonth=$("#hmonth").val().trim();
					var hyear=$("#hyear").val().trim();
					var hstatus=$("#hstatus").val().trim();
					var hgroupby=$("#hgroupby").val().trim();
					
									
					if(hmonth!=""){
						
						$("#month option[value="+hmonth+"]").attr('selected','true');
					}
					
					if(hyear!=""){
						
						$("#year option[value="+hyear+"]").attr('selected','true');
					}
					
                    if(hstatus!=""){
						
						$("#status option[value="+hstatus+"]").attr('selected','true');
					}
					
					if(hgroupby!=""){
						
						$("#groupby option[value="+hgroupby+"]").attr('selected','true');
					}
				
					
					
					$('.accordHead').click(function() {
						var displaypro = $(this).next('div').css('display');
						if (displaypro == 'none') {
							$(this).next('div').css({
								'display' : 'block'
							});
						} else {
							$(this).next('div').css({
								'display' : 'none'
							});
						}
					
					});
					
								
				$("#downloadExpenseDetails").click(function(){
					
					window.location.href = 'expensesReport.do?method=getExpensesfordownload&month='
										+ $("#month").val()
										+ ' &year='
										+ $("#year").val()
					                    + ' &Status='
					                    + $("#status").val()
					                    + ' &Groupby='
					                    + $("#groupby").val();
					                
					                    
					                   
				});
				
			
					
				});




function validate(){
	
	
	var month=$("#month").val();
	var year=$("#year").val();
	var status=$("#status").val();
	var groupby=$("#groupby").val();
	
	if(month==""){
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").show();
		$("#errordiv").text("Select Month");
		$("#month").addClass("ui-state-error");
		
		return false;
		
	}else if(year==""){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").show();
		$("#errordiv").text("Select Year");
		$("#year").addClass("ui-state-error");
			
		return false;
		
	}else if(status==""){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").show();
		$("#errordiv").text("Select Status");
		$("#status").addClass("ui-state-error");
			
		return false;
		
	 }else if(groupby==""){
	
	    $('.error-box').css({'visibility' : 'visible'});
	    $("#errordiv").show();
	     $("#errordiv").text("Select Group By");
	     $("#groupby").addClass("ui-state-error");
		
	return false;
	
     }else{
		
		$("#errordiv").hide();
		$('.error-box').css({'visibility' : 'hidden'});
		return true;
	}
	
	
}