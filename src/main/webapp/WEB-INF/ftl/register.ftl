<!DOCTYPE html>
<html>
    <head>
        <title>CoolMeeting会议管理系统</title>
        <link rel="stylesheet" href="/styles/common.css"/>
        <style type="text/css">
            
        </style>
    </head>
    <body>
    <#include 'reftl/top.ftl'>
        <div class="page-body">
            <#include 'reftl/liftMenu.ftl'>
            <div class="page-content">
                <div class="content-nav">
                    人员管理 > 员工注册
                </div>
                <form action="/doReg" method="post">
                    <fieldset>
                        <legend>员工信息</legend>
                        <table class="formtable" style="width:50%">
                            <tr>
                                <td>姓名：</td>
                                <td>
                                    <input type="text" name="employeename" value="<#if employee??>${employee.employeename}</#if>" id="employeename" maxlength="20"/>
                                </td>
                            </tr>
                            <tr>
                                <td>账户名：</td>
                                <td>
                                    <input type="text" name="username" value="<#if employee??>${employee.username}</#if>" id="accountname" maxlength="20"/>
                                </td>
                            </tr>
                            <tr>
                                <td>密码：</td>
                                <td>
                                    <input type="password" name="password"  id="password" maxlength="20" placeholder="请输入6位以上的密码"/>
                                </td>
                            </tr>
                            <tr>
                                <td>确认密码：</td>
                                <td>
                                    <input type="password" id="confirm" maxlength="20" onchange="check()"/>
                                    <div style="color: red" id="confirmInfo"></div>
                                </td>
                            </tr>
                            <tr>
                                <td>联系电话：</td>
                                <td>
                                    <input type="text" name="phone" value="<#if employee??>${employee.phone}</#if>" id="phone" maxlength="20"/>
                                </td>
                            </tr>
                            <tr>
                                <td>电子邮件：</td>
                                <td>
                                    <input type="text" name="email" value="<#if employee??>${employee.email}</#if>" id="email" maxlength="20"/>
                                </td>
                            </tr>
							<td>所在部门：</td>
                                <td>
                                    <select name="departmentid">
                                        <#if deps??>
                                            <#list deps as dep>
                                                <option value="${dep.departmentid}">${dep.departmentname}</option>
                                            </#list>
                                        </#if>
                                     </select>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="6" class="command">
                                    <input type="submit" class="clickbutton" value="注册"/>
                                    <input type="reset" class="clickbutton" value="重置"/>
                                    <div style="color: red">${error!''}</div>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </form>
            </div>
        </div>
        <div class="page-footer">
            <hr/>
            更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a>
            <img src="/images/footer.png" alt="CoolMeeting"/>
        </div>
    <script>
        function check() {
            let pwd = document.getElementById("password");
            let pwd2 = document.getElementById("confirm");
            let cfmInfo = document.getElementById("confirmInfo");
            if (pwd.value != null || pwd.value != '') {
                if (pwd.value != pwd2.value) {
                    cfmInfo.innerText = "两次密码不一致";
                }
            }
        }
    </script>
    </body>
</html>