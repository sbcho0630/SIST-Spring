<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- ★★이번에는 delete_ok.jsp로 값을 보내서 처리하지 않고 RestController에서 처리했음! ★★ -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.row {
   margin: 0px auto;
   width:300px;
}
h1 {
  text-align: center;
}
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	
	/* [Arrow 함수]
	 - 아래의 두 개는 같다. 
	 - 즉, => 는 functino()과 return을 삭제한 것이다. 
	('#delBtn').click(function(){...});
	('#delBtn').click(=>{...});
	*/
	$('#delBtn').click(function(){
		var pwd=$('#pwd').val();
		var no=$('#no').val();
		$.ajax({
			type:'POST',
			url:'delete_ok.do',
			data:{"no":no,"pwd":pwd},
			success:function(res)
			{
				if(res=="NOPWD")
				{
					alert("비밀번호가 틀렸어용!");
					$('#pwd').val("");
					$('#pwd').focus("");
				}
				else
				{
					location.href="list.do";
				}
			}
		})
	});
});
</script>
</head>
<body>
	<div class="container">
		<h1>삭제하기</h1>
		<div class="row">
			<!-- <form method="post" action="delete_ok.do"> -->
				<table class="table">
					<tr>
						<td width="30%" class="text-right">비밀번호</td>
						<td width="70%">
							<input type="password" name="pwd" size="15" id="pwd">
							<input type="hidden" name="no" value="${no }" id="no">
						</td>
					</tr>
					<tr>
						<td colspan="2" class="text-center">
							<input type="button" value="삭제" class="btn btn-sm btn-danger" id="delBtn">
							<input type="button" value="취소" onclick="javascript:history.back();">
						</td>
					</tr>
				</table>
			<!-- </form> -->
		</div>
	</div>
</body>
</html>




