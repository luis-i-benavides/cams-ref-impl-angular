<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html data-ng-app="mainApp">
<head>
	<title>HowToNet</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta charset="utf-8">

<spring:eval var="inDevelopment" expression="@environment.acceptsProfiles('development')"/>
<c:choose>
	<c:when test="${inDevelopment}">
		<!-- JS libraries -->
		<script src="<spring:url value="/lib/jquery/jquery.js"/>"></script>
		<script src="<spring:url value="/lib/angular/angular.js"/>"></script>
		<script src="<spring:url value="/lib/angular-resource/angular-resource.js"/>"></script>
		<script src="<spring:url value="/lib/angular-route/angular-route.js"/>"></script>
		<script src="<spring:url value="/lib/angular-ui-router/release/angular-ui-router.js"/>"></script>
		<script src="<spring:url value="/lib/angular-cookies/angular-cookies.js"/>"></script>
		<script src="<spring:url value="/lib/angular-bootstrap/ui-bootstrap-tpls.js"/>"></script>
		<script src="<spring:url value="/lib/angular-ui-utils/ui-utils.js"/>"></script>
		<script src="<spring:url value="/lib/oclazyload/dist/ocLazyLoad.js"/>"></script>
		<script src="<spring:url value="/lib/bootstrap/dist/js/bootstrap.js"/>"></script>
		<script src="<spring:url value="/lib/moment/moment.js"/>"></script>
		<script src="<spring:url value="/lib/eonasdan-bootstrap-datetimepicker/build/js/bootstrap-datetimepicker.min.js"/>"></script>
		<script src="https://code.angularjs.org/1.2.5/i18n/angular-locale_fr-fr.js"></script>

		<!-- Main application JS -->
		<script src="<spring:url value="/js/Main/app.js"/>"></script>
 		<script src="<spring:url value="/js/Main/app.config.js"/>"></script>
		<script src="<spring:url value="/js/Main/app.directives.js"/>"></script>
		<script src="<spring:url value="/js/Main/DataTableShellCtrl.js"/>"></script> 
		<script src="<spring:url value="/js/common/transferSrv.js"/>"></script>
		<script src="<spring:url value="/js/Main/app.router.js"/>"></script>

		<!-- CSS libraries -->
	    <link rel="stylesheet" type="text/css" href="<spring:url value="/lib/bootstrap/dist/css/bootstrap.css"/>">
	    <link rel="stylesheet" type="text/css" href="<spring:url value="/lib/bootstrap/dist/css/bootstrap-theme.css"/>">
	    <link rel="stylesheet" type="text/css" href="<spring:url value="/lib/eonasdan-bootstrap-datetimepicker/build/css/bootstrap-datetimepicker.css"/>">

		<!-- Application CSS -->
	    <link rel="stylesheet" type="text/css" href="<spring:url value="/css/dataTableShell.css"/>">
	    <link rel="stylesheet" type="text/css" href="<spring:url value="/css/animate.css"/>">
	    <link rel="stylesheet" type="text/css" href="<spring:url value="/css/app.css"/>">
	    <link rel="stylesheet" type="text/css" href="<spring:url value="/css/font-awesome.min.css"/>">
	    <link rel="stylesheet" type="text/css" href="<spring:url value="/css/font.css"/>">
	    <link rel="stylesheet" type="text/css" href="<spring:url value="/css/simple-line-icons.css"/>">
    </c:when>
	<c:otherwise>
		<!-- JS libraries -->
		<script src="<spring:url value="/lib/all.min.js"/>"></script>
	
		<!-- Application common JS -->

		<!-- Application main entrypoint JS -->

		<!-- CSS -->
	</c:otherwise>	
</c:choose>

</head>
<body>
	<div ui-view ng-cloak></div>
	
</html>
