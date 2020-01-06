<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="/WEB-INF/view/jspf/header.jspf" %>

<div class="ui segment">

	<h3>Update a Job_offer</h3>

	<form:form action="updateJob_offers" modelAttribute="job_offers" method="POST" class="ui form">
		<div class="field">
			<label>Id</label>
			<form:input path="id" />
		</div>
		<div class="field">
			<label>Company Name</label>
			<form:input path="companyName" />
		</div>
		<div class="field">
			<label>Job Name</label>
			<form:input path="jobName" />
		</div>
		<div class="field">
			<label>Available Positions</label>
			<form:input path="availablePositions" />
		</div>
		<div class="field">
			<label>Job Description</label>
			<form:input path="jobDescription" />
		</div>
		
	<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_OFFICE')">
	
		<div class="field">
			<label>Enabled</label>
			<form:input path="enabled" />
		</div>
	</sec:authorize>
		<button class="ui button" type="submit">Save</button>
	</form:form>

</div>