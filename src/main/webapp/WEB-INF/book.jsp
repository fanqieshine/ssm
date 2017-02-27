<%@ page import="org.dom4j.Element" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta name="renderer" content="webkit">
    <title></title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 留言管理</strong></div>
    <table class="table table-hover text-small text-center">
        <tr>
            <th width="120">工号</th>
            <th>姓名</th>
            <th>部门</th>
            <th>科室</th>
            <th>职位</th>
            <th>手机</th>
            <th>短号</th>
            <th>邮箱</th>
            <th>操作</th>
        </tr>
        <c:forEach var="contact" items="${contactsOfPage}" varStatus="status">
            <tr>
                <td><input type="checkbox" name="id[]" value="1"/>
                        ${contact.id}
                </td>
                <td>${contact.name}</td>
                <td>${contact.dept}</td>
                <td>${contact.dept2}</td>
                <td>${contact.job}</td>
                <td>${contact.tel}</td>
                <td>${contact.sTel}</td>
                <td>${contact.email}</td>
                <td>
                    <div class="button-group">
                        <a class="button-small border-red" href="javascript:void(0)"
                           onclick="return del(1)"><span class="icon-edit"></span>修改</a>
                        <a class="button-small border-red" href="javascript:void(0)"
                           onclick="return del(1)"><span class="icon-trash-o"></span> 删除</a>
                    </div>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="9">
                <div class="current border-left">共${counts}条记录,当前第${page}/${pages}页</div>
                <div class="pagelist">
                    <a href="/contacts?page=1">首页</a>
                    <c:if test="${page==1}">
                        <span class="disable">上一页</span>
                    </c:if>
                    <c:if test="${page!=1}">
                        <a href="/contacts?page=${page-1}">上一页</a>
                    </c:if>
                    <c:if test="${page<4}">
                        <c:forEach var="currentpage" begin="1" end="5" varStatus="status">
                            <c:choose>
                                <c:when test="${currentpage==page}">
                                    <span class="current">${page}</span>
                                </c:when>
                                <c:otherwise>
                                    <a href="/contacts?page=${currentpage}">${currentpage}</a>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </c:if>
                    <c:if test="${page>=4&&page<=pages-2}">
                        <c:forEach var="currentpage" begin="${page-2}" end="${page+2}" varStatus="status">
                            <c:choose>
                                <c:when test="${currentpage==page}">
                                    <span class="current">${page}</span>
                                </c:when>
                                <c:otherwise>
                                    <a href="/contacts?page=${currentpage}">${currentpage}</a>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </c:if>
                    <c:if test="${page>pages-2}">
                        <c:forEach var="currentpage" begin="${pages-4}" end="${pages}" varStatus="status">
                            <c:choose>
                                <c:when test="${currentpage==page}">
                                    <span class="current">${page}</span>
                                </c:when>
                                <c:otherwise>
                                    <a href="/contacts?page=${currentpage}">${currentpage}</a>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                        <c:choose>
                            <c:when test="${page==pages}">
                                <span class="disable">下一页</span>
                            </c:when>
                            <c:otherwise>
                                <a href="/contacts?page=${page+1}">下一页</a>
                            </c:otherwise>
                        </c:choose>
                    </c:if>
                    <a href="/contacts?page=${(counts/pagelength).intValue()+(counts%pagelength==0?0:1)}">尾页</a>
                    <form style="display: inline" action="/contacts" method="post">
                        <input class="input-jump" id="page" name="page"/>
                        <button class="button button-little" name="jumppage" type="submit"
                                onclick="return check()">跳转
                        </button>
                    </form>
                </div>
            </td>
        </tr>
    </table>
</div>
<script type="text/javascript">

    function check() {
        var page = $("#page").val()
        if (page.trim() == "" || isNaN(page)) {
            alert("请输入正确的页码")
            return false;
        }
        if (page >${pages} || page < 1) {
            alert("页码超出范围！")
            return false;
        }
        return true;
    }

    function del(id) {
        if (confirm("您确定要删除吗?")) {

        }
    }

    function DelSelect() {
        var Checkbox = false;
        $("input[name='id[]']").each(function () {
            if (this.checked == true) {
                Checkbox = true;
            }
        });
        if (Checkbox) {
            var t = confirm("您确认要删除选中的内容吗？");
            if (t == false) return false;
        }
        else {
            alert("请选择您要删除的内容!");
            return false;
        }
    }
</script>
</body>
</html>