<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/easyui.css">
    <link rel="stylesheet" href="/css/icon.css">
    <script src="/js/jquery-1.8.0.min.js"></script>
    <script src="/js/jquery.easyui.min.js"></script>
</head>
<body class="easyui-layout">
    <div data-options="region:'north',title:'North Title',split:true" style="height:100px;">
        <shiro:hasRole name="admin">
            <a href="/loginout">退出</a>
            <shiro:authenticated>
                [<shiro:principal/>]身份验证通过
            </shiro:authenticated>
        </shiro:hasRole>
        <shiro:guest>
            欢迎游客访问
        </shiro:guest>
    </div>
    <div data-options="region:'south',title:'South Title',split:true" style="height:100px;"></div>
    <div data-options="region:'east',title:'East',split:true" style="width:100px;">
        <a href="/buy">购买</a>
    </div>
    <div data-options="region:'west',title:'West',split:true" style="width:100px;"></div>
    <div data-options="region:'center',title:'center title'" style="padding:5px;background:#eee;">
        当前在线:${sessionsCount} 人
        <table>
            <thead>
                <tr>
                    <th style="width: 150px;">会话ID</th>
                    <th>用户名</th>
                    <th>主机地址</th>
                    <th>最后访问时间</th>
                    <th>已强制退出</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${sessions}" var="session">
                    <tr>
                        <td>${session.id}</td>
                        <td><shiro:principal/></td>
                        <td>${session.host}</td>
                        <td>${session.lastAccessTime}</td>
                        <td></td>
                        <td></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
