<table class="table table-striped">
	<thead>
		<tr>
			<g:each in="${fields}">
				<th>${it.displayName}</th>
			</g:each>
		</tr>
	</thead>
	<tbody>
		<g:each var="row" in="${detail}" >
			<tr>
				<g:each var="fieldItem" in="${fields}">
					<td>${row[fieldItem.field] }</td>
				</g:each>
			</tr>
		</g:each>
	</tbody>
</table>

