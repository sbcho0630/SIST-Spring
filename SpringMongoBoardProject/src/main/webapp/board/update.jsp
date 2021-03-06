<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 수정하기에 파일수정 기능은 안 만들거임 -->
<!-- ★★이번에는 update_ok.jsp로 값을 보내서 처리하는게 아니라 RestController에서 처리했음!! ★★ -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.row {
   margin: 0px auto;
   width:600px;
}
h1 {
  text-align: center;
}
</style>
</head>
<body>
   <div class="container">
     <h1>글 수정하기</h1>
     <div class="row">
      <form method=post action="update_ok.do"> 
      <table class="table table-hover">
        <tr>
          <th width=20% class="text-right success">이름</th>
          <td width=80%>
           <input type=text name=name size=15 required value="${vo.name }" id="name">
           <input type="hidden" name="no" value="${vo.no }" id="no">
          </td>
        </tr>
        <tr>
          <th width=20% class="text-right success">제목</th>
          <td width=80%>
           <input type=text name=subject size=50 required value="${vo.subject }" id="subject">
          </td>
        </tr>
        <tr>
          <th width=20% class="text-right success">내용</th>
          <td width=80%>
           <textarea rows="8" cols="55" name=content required id="content">${vo.content }</textarea>
          </td>
        </tr>
        
        <tr>
          <th width=20% class="text-right success">비밀번호</th>
          <td width=80%>
           <input type="password" name=pwd size=10 required id="pwd">
          </td>
        </tr>
        <tr>
          <td class="text-center" colspan="2">
           <input type="submit" value="수정완료" class="btn btn-sm btn-primary" id="updateBtn">
           <input type="button" value="취소" class="btn btn-sm btn-danger"
            onclick="javascript:history.back()"
           >
          </td>
        </tr>
      </table>
      </form>
     </div>
   </div>
</body>
</html>