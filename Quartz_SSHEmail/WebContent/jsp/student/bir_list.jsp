<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix ="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="delForm" action="" method="POST">
		<table width="100%">
			<tr>
				<td width="5%" class="td_title">序号</td>
				<td width="5%" class="td_title">
					<div onclick="xjCommon.checkAll('ids')" style="cursor: pointer;">全选</div>
				</td>
				<td class="td_title">姓名</td>
				<td class="td_title">性别</td>
				<td class="td_title">出生年月</td>
				<td width="25%" class="td_title">操作</td>
			</tr>
			<s:iterator id="stu" value="list" status="i">
				<tr class="tabtd1">
					<td class="td_text_align td_nowrap"><s:property
							value="#i.count" /></td>
					<td class="td_text_align td_nowrap"><input type="checkbox"
						name="ids" value="<s:property value="#stu.cahId"/>" class="wu">
					</td>
					<td class="td_text_align td_nowrap"><s:property	value="#stu.name" /></td>
					<td class="td_text_align td_nowrap"><s:property	value="#stu.sex" /></td>
					<td class="td_text_align td_nowrap"><s:property	value="#stu.bir" /></td>
					<td class="td_text_align td_nowrap"><a
						href="javascript:editpage('<s:property value="#stu.cahId"/>')">[修改]</a>
					</td>
				</tr>
			</s:iterator>
		</table>
	</form>
</body>
<script language="javascript">

	function query(){
		document.queryForm.action = "<%=request.getContextPath() %>/stu!query.action";
	  	document.queryForm.submit();
	}
	function addPage(){
		window.location.href="<%= request.getContextPath()%>/stu!addpage.action";
	}
	function editpage(id){
		window.location.href="<%=request.getContextPath() %>/stu!editpage.action?id="+id;
	}

	function Delete(){
		if(hasChecked(delForm)==false){
			alert("请选择要删除的信息");
			return;
		}
		if(confirm("您确定要删除选中的信息吗？")==true){
		    document.delForm.action = "<%=request.getContextPath()%>/stu!delete.action";
			document.delForm.submit();
		}
	}
//-->
</script>
</html>