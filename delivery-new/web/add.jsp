<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>快递管理系统</title>
    <meta name="Copyright" content="Douco Design."/>
    <link href="css/public.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/global.js"></script>
</head>
<body>
<div id="dcWrap">
    <div id="dcHead">
        <div id="head">
            <div class="logo"><a href="index.jsp"><img width="100px"
                                                       height="25px" src="images/dclogo.gif"
                                                       alt="logo"></a></div>
            <div class="nav">
                <ul class="navRight">
                    <li class="M noLeft"><a
                            href="JavaScript:void(0);">您好，${sessionScope.sysUser.nickName}</a>
                        <div class="drop mUser">
                            <a href="password.html">修改密码</a>
                        </div>
                    </li>
                    <li class="noRight"><a
                            href="login.php?rec=logout">退出</a></li>
                </ul>
            </div>
        </div>
    </div>
    <!-- dcHead 结束 -->
    <div id="dcLeft">
        <div id="menu">
            <ul class="top">
                <li><a href="index.jsp"><i
                        class="home"></i><em>管理首页</em></a></li>
            </ul>
            <ul>
                <li><a href="password.html"><i
                        class="system"></i><em>修改密码</em></a></li>
                <li><a href="list.html"><i
                        class="nav"></i><em>快递管理</em></a></li>

            </ul>
        </div>
    </div>
    <div id="dcMain">
        <!-- 当前位置 -->
        <div id="urHere">快递管理系统<b>></b><strong>添加快递</strong></div>
        <div
                id="manager" class="mainBox"
                style="height:auto!important;height:550px;min-height:550px;">
            <h3><a href="index.jsp" class="actionBtn">返回首页</a>添加快递</h3>
            <form action="#" method="post">
                <table width="100%" border="0" cellpadding="8"
                       cellspacing="0" class="tableBasic">
                    <tr>
                        <td width="100" align="right">收件人</td>
                        <td>
                            <input type="text" name="user_name"
                                   size="40" class="inpMain"/>
                        </td>
                    </tr>
                    <tr>
                        <td width="100" align="right">快递公司</td>
                        <td>
                            <select name="cat_id">
                                <option value>请选择</option>
                               <%-- <c:forEach items="${sessionScope.sysUser.roles}" var="role">
                                    <option value="${role.id}">${role.name}</option>
                                </c:forEach>--%>
                                <option value="1"> 申通快递</option>
                                <option value="2"> 圆通快递</option>
                                <option value="3"> 韵达快递</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td width="100" align="right">手机号</td>
                        <td>
                            <input type="text" size="40"
                                   class="inpMain"/>
                        </td>
                    </tr>
                    <tr>
                        <td align="right">收货地址</td>
                        <td>
                            <input type="text" name="password" size="40"
                                   class="inpMain"/>
                        </td>
                    </tr>
                    <tr>
                        <td align="right">收货日期</td>
                        <td>
                            <input type="text" name="date" size="40"
                                   class="inpMain"
                                   placeholder="yyyy-MM-dd"/>
                        </td>
                    </tr>
                    <tr>
                        <td align="right">收货状态</td>
                        <td>
                            <input type="radio" name="a" size="40"
                                   checked/> 已签收
                            <input type="radio" name="a" size="40"/>
                            未签收
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <!-- <input type="hidden" name="token"
                                value="5a58b748" /> -->
                            <input type="submit" name="submit"
                                   class="btn" value="提交"/>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
    <div class="clear"></div>
    <div id="dcFooter">
        <div id="footer">
            <div class="line"></div>
            <ul>
                版权所有 © 2024-2025 尚硅谷教育，并保留所有权利。
            </ul>
        </div>
    </div><!-- dcFooter 结束 -->
    <div class="clear"></div>
</div>
</body>
</html>