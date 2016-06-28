$(document).ready(function(){
		var today = new Date();
		var dd = today.getDate();
		var mm = today.getMonth()+1;
		var yyyy = today.getFullYear();
		if(dd<10) { dd='0'+dd;
		} 
		if(mm<10) { mm='0'+mm;
		} 

		 var HOUR        = today.getHours();
		    var MINUTES     = today.getMinutes();
		    var SECONDS     = today.getSeconds();
	
		var result = (HOUR < 10 ? "0" + HOUR : HOUR) + ":" + (MINUTES < 10 ? "0" + MINUTES : MINUTES) + ":" + (SECONDS  < 10 ? "0" + SECONDS : SECONDS);
		
		today = dd+'-'+mm+'-'+yyyy+" "+result;
		$('span.pagebanner').parent().css({'text-align':'center'});
		
		$('#biometric #approve').click(function(){
		/* 	$('#biometric').css({'z-index':1,'position':'relative'});
			$('#imageDiv').css({'display':'block','width':$('html').width(),'height':'2000px'}); */
			var currentShift=$(this).parents('tr:first').find('td:nth-child(3)').text().trim();
			var selectedShift=$(this).parents('tr:first').find('select option:selected').text().trim();
			var x=true;
		/* 	if(currentShift==selectedShift)
			  x = confirm("Are you sure you want to Update, current shift and modified shift are same ?"); */
			if(x){
				$(this).val("Updating...");
				var shiftid=$(this).parents('tr:first').find('select').attr('id');
				var shiftid_split = shiftid.split("_");
				var id=shiftid_split[1];
				$.ajax({
					url:"shiftAmendment.do?method=updateShift",
					data:{'empId':id,shiftId:$('#shift_'+id).val(),'modifiedDate':today},
					async:false,
					success:function(response){}
				});
			}
			$(this).val("Approved");
			$(this).parents('tr:first').find('td:nth-child(5)').text(today);
			$(this).css({'background-color':'yellow','color':'black'});
			/* $('#biometric').css({'z-index':'','position':'static'});
			$('#imageDiv').css({'display':'none','width':$('html').width(),'height':'2000px'}); */
		});
	});
	