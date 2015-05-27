<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>pancake order</title>
    </head>
    <body>
        <form action="cart.do" method="post" class="Cart">

            <h1>パンケーキにトッピングするものを選んでください（250円）</h1>
            <h2>ベースのパンケーキは600円です。</h2>
            <h3>${user}さんのトッピングを選択してください</h3>
            <table class="menu">
                <c:forEach items="${data}" var="rec">
                    <tr>
                        <td><input type="checkbox" value="${rec.id}" name="shohinid" /></td>
                        <td>${rec.id}</td>
                        <td>${rec.name}</td>
                        <td class="price">${rec.price}円</td>
                    </tr>
                </c:forEach>
            </table>
            <input type="submit" name="cart.do" value="カートの内容を確認して注文へ進む" /><br>
        </form>
        <form action="logout.do" method="post">
            <input type="submit" value="ログアウト" />
        </form>
    </body>
</html>
