<html>
<body>
	<h2>登録完了</h2>
	<form:form modelAttribute="entryForm">
		<div>ユーザー登録が完了しました。</div>
		<div>登録したEmail
			<c:out value="${entryForm.email}" />
		</div>
		<div>
			<a href="<c:url value='/' />">トップへ戻る</a>
		</div>
	</form:form>
</body>
</html>