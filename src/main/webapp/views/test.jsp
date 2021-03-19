<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 21. 3. 19.
  Time: 오후 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
    <title>Test</title>
</head>
<body>
<h1>다음은 ${team.name}의 정보입니다!!</h1>
팀 ID : ${team.id}
팀 이름 : ${team.name}
팀 설명 : ${team.description}
</body>
</html>
