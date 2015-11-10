<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<script src="http://www.amcharts.com/lib/3/amcharts.js"></script>
<script src="http://www.amcharts.com/lib/3/serial.js"></script>
<script src="http://www.amcharts.com/lib/3/themes/light.js"></script>



<script>

var chart = AmCharts.makeChart( "chartdiv", {
	  "type": "serial",
	  "theme": "light",
	  "dataProvider": [ ${dataset}],
	  "valueAxes": [ {
	    "gridColor": "#FFFFFF",
	    "gridAlpha": 0.2,
	    "dashLength": 0
	  } ],
	  "gridAboveGraphs": true,
	  "startDuration": 1,
	  "graphs": [ {
	    "fillAlphas": 0.8,
	    "lineAlpha": 0.2,
	    "type": "column",
	    "valueField": ${ylabel}
	  } ],
	  "categoryField": ${xlabel},
	  "categoryAxis": {
	    "gridPosition": "start",
	    "labelRotation": 45,
	    "gridAlpha": 0,
	    "tickPosition": "start",
	    "tickLength": 20
	  }
	} );

</script>
<div class="container-fluid">
<h3>DashBoard</h3><h4>Word weight</h4>
<div id="chartdiv"></div>
</div>					