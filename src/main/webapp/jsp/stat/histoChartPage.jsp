<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<script src="http://www.amcharts.com/lib/3/amcharts.js"></script>
<script src="http://www.amcharts.com/lib/3/serial.js"></script>
<script src="http://www.amcharts.com/lib/3/themes/light.js"></script>
<script>

var chart = AmCharts.makeChart( "chartdiv", {
	"type": "serial",
	"theme": "light",
	"dataProvider": [ ${dashBoardBean.graphBean.dataset}],
	"valueAxes": [ {
		"gridColor": "#FFFFFF",
		"gridAlpha": 0.2,
		"dashLength": 0
	} ],
	"gridAboveGraphs": true,
	"startDuration": 1,
	"graphs": [ {
		"balloonText": "[[category]]: <b>[[value]]</b>",
		"fillAlphas": 0.8,
		"lineAlpha": 0.2,
		"type": "column",
		"valueField": ${dashBoardBean.graphBean.ylabel}
	} ],
	"categoryField": ${dashBoardBean.graphBean.xlabel},
	"dataDateFormat" : "YYYYMMDD",
	"categoryAxis": {
		"parseDates" : true,
		"gridPosition": "start",
		"labelRotation": 0,
		"gridAlpha": 0,
		"tickPosition": "start",
		"tickLength": 5,
		"boldPeriodBeginning" : false

	}
} );
</script>
<div id="chartdiv"></div>



