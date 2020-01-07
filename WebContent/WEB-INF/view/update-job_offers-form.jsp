<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="/WEB-INF/view/jspf/header.jspf" %>

<div class="ui segment">

	<h3>Update a Job_offer</h3>

	<form:form action="updateJob_offers" modelAttribute="job_offers" method="POST" class="ui form">
		<div class="field" style="display: inline-block vertical-align: baseline; width: 125px;" >
			<label>Id</label>
			<form:input path="id" />
		
		
			<label>Company Name</label>
			<form:input path="companyName" />
		
		
			<label>Job Name</label>
			<form:input path="jobName" />
		
		
			<label>AvailablePositions</label>
			<form:input path="availablePositions" />
		
		
			<label>Job Description</label>
			<form:input path="jobDescription" />
		
		
	<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_OFFICE')">
	
		<div class="field">
			<label>Enabled</label>
			<form:input path="enabled" />
		</div>
	</sec:authorize>
		<button class="ui button" type="submit"
		style="background-color: #AFB0EF;
`								border: none;								
  								color: black;							
  								text-align: center;
 								text-decoration: none;
 								 display: inline-block;
 								 font-size: 16px;
 								 cursor: pointer;
  								-webkit-transition-duration: 0.4s; /* Safari */
 								 transition-duration: 0.4s; ">Save</button>
	</form:form>
</div>
</div>