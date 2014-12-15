		<g:form >
		<table  class="editable table table-striped">
	<thead>
		<tr>
			<g:each in="${fields.findAll {it.field != "id"}}">
				<th>${it.displayName}</th>
			</g:each>
		</tr>
	</thead>
	<tbody>

			<g:each var="row" in="${detailCommand.detail}" status="i">
			<tr class="editRow">
			    <g:hiddenField name="detail[$i].id" value="${row.id }"/>
				<g:each var="fieldItem" in="${fields.findAll {it.field != "id"}}">
						<td class="form-group ${exa.classList('has-error':row.hasErrors())}" data-id="${row.id}">
							<g:textField class="unfocused form-control ${hasErrors(bean:row,field: fieldItem.field,'redBack')}" name="detail[$i].${fieldItem.field}" value=" ${row[fieldItem.field] }" data-field="${fieldItem.field}" title="${fieldItem.error}" ></g:textField></td>
				</g:each>
			</tr>
			</g:each>
			<g:submitToRemote url="[action: 'saveDetail']" update="updateMe" value="Save" ></g:submitToRemote>

	</tbody>
	</table>
			</g:form>