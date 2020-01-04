<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment">

	<h3>Add a Job_offer</h3>

	<form:form action="saveJob_offers" modelAttribute="job_offers" method="POST" class="ui form">
		<div class="field">
			<label>Company Name</label> 
			<form:input path="companyName"/>
		</div>
		<div class="field">
			<label>Job Name</label>
			<form:input path="jobName"/>
		</div>
		<div class="field">
			<label>Available Positions</label> 
			<form:input path="availablePositions"/>
		</div>
			<div class="field">
			<label>Job Description</label> 
			<form:input path="jobDescription"/>
		</div>
			<div class="field">
			<label>Enabled</label> 
			<form:input path="enabled"/>
		</div>
		<button class="ui button" type="submit">Save</button>
	</form:form>

</div>