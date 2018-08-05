<%@ include file="common/header.jspf"%>
<%@ include file="common/nav.jspf"%>
<div class="container">
	<div class="jumbotron">
		<h1 class="display-4">Welcome ${name} !</h1>

		<hr class="my-4">
		<p>Get your todo list.</p>
		<p class="lead">
			<a class="btn btn-primary btn-lg" href="/list-todos" role="button">Todo
				List</a>
		</p>
	</div>
</div>
<%@ include file="common/footer.jspf"%>