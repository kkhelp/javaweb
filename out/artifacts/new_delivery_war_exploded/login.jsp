<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>快递管理系统</title>
    <meta name="Copyright" content="Douco Design." />
    <link href="css/public.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/global.js"></script>
  </head>
  <body>
    <div id="dcWrap">

      <div id="dcMain">
        <!-- 当前位置 -->
        <div id="manager" class="mainBox"
          style="height:auto!important;height:550px;min-height:550px;">
          <h3>用户登陆</h3>
          <form action="/user/login" method="post" onsubmit="return checkForm()">
            <table width="100%" border="0" cellpadding="8" cellspacing="0"
              class="tableBasic">
              <tr>
                <td id="login-error-message" colspan="2" style="color: red"></td>
              </tr>
              <tr>
                <td width="100" align="right">用户名</td>
                <td>
                  <input id="usernameInput" type="text" name="account" size="40"
                    class="inpMain" onchange="checkUsername()" />
                  &nbsp; &nbsp;
                  <span id="accountMsg"></span>
                </td>
              </tr>
              <tr>
                <td width="100" align="right">密码</td>
                <td>
                  <input id="userPwdInput" type="password" name="password"
                    size="40" class="inpMain" onchange="checkUserPwd()" />
                  &nbsp; &nbsp;
                  <span id="passwordMsg"></span>
                </td>
              </tr>
              <tr>
                <td></td>
                <td>
                  <input type="submit" name="submit" class="btn" value="登录" />
                </td>
              </tr>
            </table>
          </form>
        </div>
      </div>

      <!-- 代码实现-->
      <script>

  // 定义账号正则表示字符串的规则
  var  usernameReg= /^[a-zA-Z][a-zA-Z0-9]{5,9}$/
  // 定义正则表示字符串的规则
  var  userPwdReg= /^[a-zA-Z0-9]{6,12}$/

  //定义记录账号和密码对应校验状态
  var  accountState = false;
  var  passwdState = false;


  // 检验用户名格式是否合法的函数
  function checkUsername(){
      // 获得用户在页面上输入的信息
      var usernameInput =document.getElementById("usernameInput")
      var username = usernameInput.value
      // 获得格式提示的框
      var accountMsg =document.getElementById("accountMsg")
      // 格式有误时,返回false,在页面上提示
      if(!usernameReg.test(username)){ 
          accountMsg.innerHTML="<font color='red'>用户名格式错误!</font>"
          accountState = false;
          return; 
      }
      // 格式OK,返回true 在页面上提示OK
      accountState = true;
      accountMsg.innerHTML="<font color='green'>用户名可以使用!</font>"
  }
  // 检验密码格式是否合法的函数
  function checkUserPwd(){
      // 获得用户在页面上输入的信息
      var userPwdInput =document.getElementById("userPwdInput")
      var userPwd = userPwdInput.value
      // 获得格式提示的框
      var userPwdMsg =document.getElementById("passwordMsg")
      // 格式有误时,返回false,在页面上提示
      if(!userPwdReg.test(userPwd)){ 
          userPwdMsg.innerHTML="<font color='red'>密码格式错误!</font>"
          passwdState = false;
          return;
      }
      // 格式OK,返回true 在页面上提示OK
      passwdState = true;
      userPwdMsg.innerHTML="<font color='green'>密码可以使用!</font>"
  }
  // 表单在提交时,校验用户名和密码格式,格式OK才会提交
  function checkForm(){
      //账号和密码都可以用
      return accountState&&passwdState
  }
  let btn = document.getElementsByClassName("btn")[0];
  btn.addEventListener("click", e => {
    event.preventDefault();
    if (!checkForm()) return;
    $.post("/user/login", {
      userName: document.getElementById("usernameInput").value,
      password: document.getElementById("userPwdInput").value
    }, function (res) {
      console.log("res = ", res);
      if (res == null) return;
      if (res?.code === 200) {
        window.location.href = "/index.jsp";
      }
      if (res?.code === 500) {
        document.getElementById("login-error-message").innerText = res.message;
      }
    })
  })

</script>
      <div class="clear"></div>
      <div id="dcFooter">
        <div id="footer">
          <div class="line"></div>
          <ul>
            版权所有 © 2024-2025 尚硅谷教育，并保留所有权利。
          </ul>
        </div>
      </div><!-- dcFooter 结束 -->
      <div class="clear"></div> </div>
  </body>
</html>