<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="main"/>
<title>Insert title here</title>
<style>
.unfocused {
	border: none;
	background: none;
	margin: 0 1px;
}
.form-control {
	padding: 2px 2px;
}
.redBack {
	border: 1px dotted #D9230F;
}
</style>
<script>
$(document).ready(function() {

	$(".editable.table").on('focus','input', function(e) {
			e.preventDefault();
			console.log('focus event');
			var $this = $(this);
			var id = $this.parent().data('id');
			var fieldName = $this.data('field');
			console.log('focus event on id: ' + id + ' field: ' + fieldName + ' current value: '+$this.val());
			$this.data('originalValue', $this.val());
			$this.removeClass('unfocused');
	});
	
	$(".editable.table").on('blur','input', function(e) {
			console.log('blur event');
			var $this = $(this);
			var id = $this.parent().data('id');
			var fieldName = $this.data('field');
			console.log('blur event on id: ' + id + ' field: ' + fieldName);
			if ($this.data('originalValue') != $this.val()) {
				console.log('changed!!!!');				
				}
			$this.addClass('unfocused');
	});
	


});

</script>
</head>
<body>
	<div class="container">
	     		<g:paginate next="Forward" prev="Back"
	             controller="edit" params = "[max: 20]"
	            action="multiple" total="${detailCount}" />	
	<div id="updateMe">
		
			<g:render template="editDetailList" ></g:render>

     </div>
     		<g:paginate next="Forward" prev="Back"
	             controller="edit" params = "[max: 20]"
	            action="multiple" total="${detailCount}" />	
     </div>
</body>
</html>