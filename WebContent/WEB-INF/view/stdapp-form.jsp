<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="/WEB-INF/view/jspf/header.jspf" %>


<div class="ui segment">

	<h3>List of Job Offers</h3>

	<!--  add our html table here -->
	<table class="ui celled  striped table">
		<c:forEach var="tempjob_offers" items="${job_offers}">
		<c:if test="${tempjob_offers.enabled=='1'}">
					<tr>
				<td>${tempjob_offers.companyName}</td>
				<td>${tempjob_offers.jobName}</td>
				<td>${tempjob_offers.availablePositions}</td>
				<td>${tempjob_offers.jobDescription}</td>
				<td>
			</tr>
		</c:if>
		</c:forEach>
	</table>



	<h3>Add an std app</h3>

	<form:form action="saveStdapps" modelAttribute="Studentapplications" method="POST" class="ui form">
	
			<div class="field">
			<label>Job</label> 
			<form:input path="job"/>
		</div>
		<button class="ui button" type="submit">Save</button>
	</form:form>

</div>