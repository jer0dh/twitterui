<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="main"/>
<title>Insert title here</title>

</head>
<body>
	<div class="container">

			<g:render template="/layouts/detailList" model="['detail' : detail, 'fields' : fields]"></g:render>
			<g:paginate next="Forward" prev="Back"
	             controller="detail" params = "[max: 20]"
	            action="index" total="${detailCount}" />	

     </div>
</body>
</html>