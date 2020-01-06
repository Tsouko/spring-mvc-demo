<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment">

	<h3>Add an std app</h3>

	<form:form action="saveStdapps" modelAttribute="Studentapplications" method="POST" class="ui form">
	
			<div class="field">
			<label>id</label> 
			<form:input path="id"/>
		</div>
		<div class="field">
			<label>First Name</label> 
			<form:input path="firstName"/>
		</div>
		<div class="field">
			<label>Last Name</label>
			<form:input path="lastName"/>
		</div>
		<div class="field">
			<label>Email</label> 
			<form:input path="email"/>
		</div>
			<div class="field">
			<label>Job</label> 
			<form:input path="job"/>
		</div>
		<button class="ui button" type="submit">Save</button>
	</form:form>

</div>