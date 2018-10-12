<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	pageContext.setAttribute("path", path);
%>

<link href="<%=request.getContextPath()%>/areaManagerStatic/lib/Hui-iconfont_v1.0.8/1.0.8/iconfont.css" rel="stylesheet" type="text/css" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Insert title here</title>
</head>
<body>
<a href="${path}/selectAll.do" >查询所有信息</a>

<a href="${path}/areaManager/index.do" >跳到区区管理员页面</a>

<a href="${path}/index.do" >tiaodaoceshiyemain信息</a>
tomanagerlogin.do

<a href="${path}/user/tobikepage.do" >跳到用户页面</a>
<a href="${path}/login/tomanagerlogin.do" >跳到manage登录页面</a>

</body>
</html>