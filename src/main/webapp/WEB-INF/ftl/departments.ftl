<!DOCTYPE html>
<html>
    <head>
        <title>CoolMeeting会议管理系统</title>
        <link rel="stylesheet" href="/styles/common.css"/>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.js"></script>
    </head>
    <body>
    <#include 'reftl/top.ftl'>
        <div class="page-body">
            <#include 'reftl/liftMenu.ftl'>
            <div class="page-content">
                <div class="content-nav">
                    人员管理 > 部门管理
                </div>
                <form action="/admin/addDepartment" method="post">
                    <fieldset>
                        <legend>添加部门</legend>
                        部门名称:
                        <input name="departmentname" type="text" id="departmentname" maxlength="20"/>
                        <input type="submit" class="clickbutton" value="添加"/>
                    </fieldset>
                </form>
                <table class="listtable">
                    <caption>所有部门:</caption>
                    <tr class="listheader">
                        <th>部门编号</th>
                        <th>部门名称</th>
                        <th>操作</th>
                    </tr>
                    <#if deps ??>
                        <#list deps as dep>
                            <tr>
                                <td>${dep.departmentid}</td>
                                <td id="depname${dep.departmentid}">${dep.departmentname}</td>
                                <td>
                                    <a class="clickbutton" href="#" id="edit${dep.departmentid}" onclick="editDep(${dep.departmentid})">编辑</a>
                                    <a class="clickbutton" style="display: none" href="#" id="cancel${dep.departmentid}" onclick="cancelDep(${dep.departmentid}, '${dep.departmentname}')">取消</a>

                                    <a class="clickbutton" href="/admin/delDepartment?departmentid=${dep.departmentid}">删除</a>
                                </td>
                            </tr>
                        </#list>
                    </#if>
                </table>
            </div>
        </div>
        <div class="page-footer">
            <hr/>
            更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a>
            <img src="/images/footer.png" alt="CoolMeeting"/>
        </div>
    <script>
        let reDepartmentName;

        function editDep(depId) {
            let editBtn = $('#edit' + depId);
            let cancelBtn = $('#cancel' + depId);
            let ele = $('#depname' + depId);

            if (cancelBtn.css('display') == 'none') {
                cancelBtn.css('display', 'inline');
                editBtn.html('确定');
                let depName = ele.text();
                ele.html('<input type="text" value="'+depName+'"/>')
            }else {
                let children = ele.children('input');
                let val = children.val();
                $.post('/admin/updateDepartment', {departmentid: depId, departmentname: val}, function (msg) {
                    if (msg == 'success') {
                        cancelBtn.css('display', 'none');
                        editBtn.html('编辑');
                        ele.html(val);
                        reDepartmentName = val;
                    }
                });
            }

        }

        function cancelDep(departmentID) {
            let editBtn = $('#edit' + departmentID);
            let cancelBtn = $('#cancel' + departmentID);
            let ele = $('#depname' + departmentID);

            cancelBtn.css('display', 'none');
            editBtn.html('编辑');
            ele.html(reDepartmentName);
        }
    </script>
    </body>
</html>