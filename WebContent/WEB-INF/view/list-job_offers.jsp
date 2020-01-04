
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/view/jspf/header.jspf" %>
<body>
	<div class="ui segment">
	<h3>List of Job Offers</h3>

	<!--  add our html table here -->
	<table class="ui celled  striped table">
		<thead>
			<th>Company Name</th>
			<th>Job Name</th>
			<th>Available Positions</th>
			<th>Job Description</th>
			<th>Actions</th>
		</thead>
		<!-- loop over and print our customers -->
		<c:forEach var="tempjob_offers" items="${job_offers}">

			<tr>
				<td>${tempjob_offers.companyName}</td>
				<td>${tempjob_offers.jobName}</td>
				<td>${tempjob_offers.availablePositions}</td>
				<td>${tempjob_offers.jobDescription}</td>
				<td><a
					href="<c:url value="deleteJob_offers/${tempjob_offers.id}"></c:url>"><button type="submit" id="${tempjob_offers.id}"
					name="deleteJob_offers"><i class="remove user icon"></i>
					 Delete</button></a>
				<!--   <a
					href="<c:url value="/customer/${tempCustomer.id}"></c:url>"><i class="unhide icon"></i>
					View</a>-->	
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


<%@ include file="/WEB-INF/view/jspf/footer.jspf" %>
