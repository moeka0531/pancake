<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>pancake Cart</title>
    </head>
    <body>
        <h1>カート内の商品は以下の通りです。</h1>
        <h2>品名　　　金額</h2>
        <hr size="10">
        <h4>パンケーキ　600</h4>
        <c:forEach items="${data}" var ="rec">
            <h3> ${rec.name}　${rec.price}</h3>
        </c:forEach>
        <hr size="10">
        <h4>合計金額　 ${total}        円</h4>
        
        <form action="thankyou.jsp" method="post" class="Cart">
            <input type="submit" value="この内容で注文する" />
        </form>

        <form action="logout.do" method="post">
            <input type="submit" value="ログアウト" />
        </form>
    </body>
</html>
