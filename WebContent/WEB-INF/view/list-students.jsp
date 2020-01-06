
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/view/jspf/header.jspf"%>
<body>
	<div class="ui segment">
		<h3>List of Students</h3>

		<!--  add our html table here -->
		<table class="ui celled  striped table">
			<thead>
				<th>id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Semester</th>
				<th>Subjects Owned</th>
				<th>resume</th>
			<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_OFFICE')">
				<th>enabled</th>
				<th>Actions</th>
			</sec:authorize>
			</thead>
			<!-- loop over and print our customers -->
			<c:forEach var="tempStudent" items="${students}">

				<tr>
					<td>${tempStudent.id}</td>
					<td>${tempStudent.firstName}</td>
					<td>${tempStudent.lastName}</td>
					<td>${tempStudent.email}</td>
					<td>${tempStudent.semester}</td>
					<td>${tempStudent.subjects_owned}</td>
					<td>${tempStudent.resume}</td>
					<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_OFFICE')">
					
					<td>${tempStudent.enabled}</td>
					<td>
					
					
					<a
						href="<c:url value="deleteStudent/${tempStudent.id}"></c:url>"><button
								type="submit" id="${tempStudent.id}" name="deleteStudent">
								<i class="remove user icon"></i> Delete
							</button></a> 

<c:if test="${tempStudent.enabled=='0'}">
<a
						href="<c:url value="able/${tempStudent.id}"></c:url>"><button
								type="submit" id="${tempStudent.id}" name="able">
								<i class="remove user icon"></i> Enable 
							</button></a> 
</c:if>							
							
					</sec:authorize>
							
							
				</tr>
			</c:forEach>
		</table>
	</div>
	<!-- 
<script type="text/javascript">
	$("[name='deleteCustomer']").click(function() {
		var urlCall = "<c:url value="/api/customer/delete/"></c:url>";
		$.ajax({
			url : urlCall + $(this).attr('id'),
			type : 'DELETE',
			success : function(result) {
				console.log(result);
				$(location).attr("href", "<c:url value="/customer/list"></c:url>");
			},
			error : function(result) {
				console.log(result);
			},
		});
	});
</script>-->


	<%@ include file="/WEB-INF/view/jspf/footer.jspf"%>