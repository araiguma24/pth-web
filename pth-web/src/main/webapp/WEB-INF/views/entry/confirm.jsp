<html>
<body>
	<h2>登録内容確認</h2>
	<form:form action="end" modelAttribute="entryForm">
		<div>Email:
			<c:out value="${entryForm.email}" />
			<form:hidden path="email"/>
		</div>
		<div>password:
			<c:out value="${entryForm.password}" />
			<form:hidden path="password"/>
		</div>
		<div>
			<form:button>この内容で登録する</form:button>
		</div>
	</form:form>
</body>
</html>