var val_val1 = [];
var val_val2 = [];
var val_val3 = [];

function callAjax(urlWithMethod, dataToBeSend) {
	var jsonResult = "";
	$.ajax({
		url : urlWithMethod,
		data : dataToBeSend,
		async : false,
		method : 'POST',
		success : function(data) {
			var result = $.parseJSON(data);
			jsonResult = result;
		}
	});
	return jsonResult;
}

$(document).ready(function() {
	var ProjectUrl = "kendoReport.do?parameter=getEmpAttendanceDetails";
	var jsonData = callAjax(ProjectUrl, "");

	for ( var j = 0; j < jsonData.allDetails.length; j++) {

		val_val1.push(jsonData.allDetails[j].empDep);
		val_val2.push(jsonData.allDetails[j].empPresent);
		val_val3.push(jsonData.allDetails[j].empAbsent);

	}
});

$(document).ready(createChart);
$(document).bind("kendo:skinChange", createChart);

function createChart() {
	$(".chart").kendoChart({
		title : {
			text : "Today Attendance Report"
		},
		legend : {
			position : "top",

		},
		seriesDefaults : {
			type : "column",
			stack : true
		},
		series : [ {
			name : "Present",
			data : val_val2
		}, {
			name : "Absent",
			data : val_val3
		} ],
		valueAxis : {
			min : 0,
			max : 100,
			line : {
				visible : true
			},
			minorGridLines : {
				visible : false
			}
		},
		categoryAxis : {
			categories : val_val1,
			majorGridLines : {
				visible : false
			}
		},
		tooltip : {
			visible : true,
			format : "{0}%",
			template : "#= series.name #: #= value #"
		},

	});
}