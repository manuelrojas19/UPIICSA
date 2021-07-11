<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jsp/jstl/core" version="2.0">
	<jsp:directive.page language="java"
		contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
	<jsp:text>
		<![CDATA[ <!DOCTYPE html> ]]>
	</jsp:text>
	<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Friends</title>
<jsp:text>
	<![CDATA[
		<script type="text/javascript" src="${pageContext.request.contextPath}/friends/js/index.js"></script>
	]]>
</jsp:text>
</head>
<body>
	<c:set var="friendList" value="${requestScope['friendList']}"></c:set>
	<h1>Friends</h1>
	<table id="tbl-friends" class="table table-striped table-bordered">
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Last Name</th>
				<th>Nickname</th>
				<th>Contacts</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${friendList}" var="friend">
				<tr>
					<td>${friend.id}</td>
					<td>${friend.name}</td>
					<td>${friend.lastName}</td>
					<td>${friend.nickName}</td>
					<td>
						<ul class="list-inline">
							<c:forEach items="${friend.contactList}" var="contact">
								<li class="list-inline-item"><c:choose>
										<c:when test="${contact.contactType.id eq 1}">
											<a class="btn btn-primary btn-sm" role="button"
												title="${contact.value}"> <i class="fas fa-phone"> <!--//-->
											</i>
											</a>
										</c:when>
										<c:when test="${contact.contactType.id eq 2}">
											<a class="btn btn-primary btn-sm" role="button"
												title="@${contact.value}"> <i class="fab fa-twitter">
													<!--//-->
											</i>
											</a>
										</c:when>
										<c:when test="${contact.contactType.id eq 3}">
											<a class="btn btn-primary btn-sm" role="button"
												title="@${contact.value}"> <i class="fab fa-facebook">
													<!--//-->
											</i>
											</a>
										</c:when>
										<c:when test="${contact.contactType.id eq 4}">
											<a class="btn btn-primary btn-sm" role="button"
												title="${contact.value}"><i class="fas fa-envelope">
													<!--//-->
											</i></a>
										</c:when>
									</c:choose> <!--/ ${contact.value}/--></li>
							</c:forEach>
						</ul>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
	</html>
</jsp:root>