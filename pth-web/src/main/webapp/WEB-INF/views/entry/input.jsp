<html>
<body>
	<h2>ユーザー登録画面</h2>
	<form:form action="confirm" modelAttribute="entryForm">
		<div>Emailとパスワードを入力してください。</div>
		<div>Email:
			<form:input path="email" />
			<form:errors path="email" />
		</div>
		<div>password:
			<form:input path="password" />
			<form:errors path="password" />
		</div>
		<div>
			<form:button>登録内容を確認する</form:button>
		</div>
	</form:form>
</body>
</html>