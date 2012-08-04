<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
	<title><tiles:insertAttribute name="title" ignore="true" /></title>
	<link rel="stylesheet" href="/css/master.css" type="text/css">
	
</head>
<body>

<div id="header">
	<tiles:insertAttribute name="header" />
</div>

<div id="navigation">
	<ul>
		<li>
			<a href="/wineries/list">Wineries</a>
		</li>
		<li>
			<a href="/wines/list">Wines</a>
		</li>
	</ul>
	
</div>

<div id="nav-title">
	<tiles:insertAttribute name="title" />
</div>

<div id="body">
	<tiles:insertAttribute name="body" />
</div>

</body>
</html>