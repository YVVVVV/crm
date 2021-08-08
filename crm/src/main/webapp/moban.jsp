<%--
  Created by IntelliJ IDEA.
  User: y
  Date: 2021/8/8
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>"><script type="text/javascript" src="<%=path %>/scripts/boot.js"></script>
    <title>Title</title>
</head>
<body>
$.ajax({
url:"",
data:{},
type:"",
dataType:"jasn",
success:function (data){


}
});



</body>
</html>
