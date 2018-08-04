<%@ include file="common/header.jspf"%>
<div class="container">
	<form action="/login" method="POST">
		<font color="red">${errorMessage}</font>
		<div class="form-group">
			<label for="name">Name:</label> <input type="text"
				class="form-control" name="name" id="name">
		</div>
		<div class="form-group">
			<label for="password">Password:</label> <input type="password"
				class="form-control" name="password" id="password">
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
</div>
<%@ include file="common/footer.jspf"%>