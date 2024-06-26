<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<fmt:setBundle basename="messages.commons" />
<fmt:message var="pageTitle" key='회원_정보_조회' />

<layout:main title="${pageTitle}">
    <section class="content-box">
        <h1>${pageTitle}</h1>
        <table>
            <thead>
            <tr>
                <th>이메일</th>
                <th>이름</th>
                <th>가입날짜</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>hong@example.com</td>
                <td>홍길동</td>
                <td>2024.04.11</td>
            </tr>
            <tr>
                <td>kim@example.com</td>
                <td>김길동</td>
                <td>2024.05.11</td>
            </tr>
            <tr>
                <td>park@example.com</td>
                <td>박길동</td>
                <td>2024.07.11</td>
            </tr>
            </tbody>
        </table>
    </section>
</layout:main>