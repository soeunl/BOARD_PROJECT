<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:if test="${! empty script}">
<%-- 자바스크립트 실행하는 곳 --%>
    <script>
        ${script}
    </script>
</c:if>