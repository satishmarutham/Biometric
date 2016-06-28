$(document).ready(
		function() {
			
			$('#div1').hide();
			$('#div2').hide();
			$('#div3').hide();
			$('#div4').hide();
			$('#div5').hide();

			$('#type').change(function() {

				var dateformat = $('#type').val();
				
				if (dateformat == "day") {
					$('#div3').hide();
					$('#div4').hide();
					$('#div5').hide();
					$('#div1').show();
					$('#div2').show();
					$('#div5').hide();

				} else if (dateformat == "week") {
					$('#div1').hide();
					$('#div2').hide();
					$('#div3').show();
					$('#div4').show();
					$('#div5').hide();

				} else if (dateformat == "month") {
					$('#div1').hide();
					$('#div2').hide();
					$('#div3').hide();
					$('#div4').hide();
					$('#div5').show();
				}

			});
			
			$('#startdate,#enddate').change(function()
					{
				alert("date");
			var date1 = $('#startdate').val();
			startDate = date1.split("-");
			var dstartdate = new Date(startDate[2], startDate[1] - 1, startDate[0]);


			var date2 = $('#enddate').val();
			endDate = date2.split("-");
			var denddate = new Date(endDate[2], endDate[1] - 1, endDate[0]);

		//	alert("startDate" + dstartdate);
		//	alert("endDate" + denddate);
			
			var oneDay = 24*60*60*1000; // hours*minutes*seconds*milliseconds
						
			var diffDays = Math.round(Math.abs((dstartdate.getTime() - denddate.getTime())/(oneDay)));
		//	alert("diffDays" +diffDays);
			
			if(diffDays > 7)
				{
								
				$('.error-box').text("Enter date within 7 days");
				$("#errordiv").show();
				
				}
			
			});


			$("#startdate").datepicker(

			{
				dateFormat : "dd-mm-yy",
				defaultDate : "+1w",
				maxDate : 0,
				changeYear : true,
				changeMonth : true,
				numberOfMonths : 1
			});

			$("#enddate").datepicker(

			{

				dateFormat : "dd-mm-yy",
				defaultDate : "+1w",
				maxDate : 0,
				changeYear : true,
				changeMonth : true,
				numberOfMonths : 1
			});

			$("#errordiv").hide();
			
			
			$("#departmentid").change(function() {

				var optionlength = $('#departmentid > option').length;
				var selectedoptionlength = $('#departmentid :selected').length;

				if (optionlength == selectedoptionlength) 
				{

					$("#deptcheckbox").attr('checked', true);
				} 
				else
				{
					$("#deptcheckbox").attr('checked', false);
				}

				getEmployees();

			});
			

			$("#employee").change(function() {

				var optionlength = $('#employee > option').length;
				var selectedoptionlength = $('#employee :selected').length;

				if (optionlength == selectedoptionlength) {

					$("#empcheckbox").attr('checked', true);
				} else {
					$("#empcheckbox").attr('checked', false);
				}

			});
		});


    
    



function selectAllDepartments()
{
	
if ($("#deptcheckbox").is(':checked'))
            {
				$("#departmentid option").attr('selected', true);
			} 
	else
	{
			$("#departmentid option").attr('selected', false);
	}
	
	getEmployees();
	
	}

function selectAllEmployees() {

	if ($("#empcheckbox").is(':checked')) 
	{

		$("#employee option").attr('selected', true);

	} 
	else
	{

		$("#employee option").attr('selected', false);
	}

}

function getEmployees() {
	
	 var deptList = []; 
		$('#departmentid :selected').each(function(i, selected){ 
			deptList[i] = $(selected).val(); 
		});
	    
		//alert(JSON.stringify(deptList));
		var sendParam = {
				'dept' : deptList.join(",")
			};
		

	$.ajax({
		type:'POST',
		url:"productivity.do?parameter=getEmployeeByDept",
		data:sendParam,
		async:false,
		success:function(response){
			var result=$.parseJSON(response);
			$("#employee").html("");
		for(var j=0;j<result.employeeList.length;j++){
		
			$("#employee").append('<option value="'
					+ result.employeeList[j].empid
					+ '">'
					+ result.employeeList[j].empname
					+ '</option>');
			}
		}
	});
	
}

