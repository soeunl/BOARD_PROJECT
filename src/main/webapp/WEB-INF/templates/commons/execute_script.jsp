<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:if test="${! empty script}">
<%-- 자바스크립트 실행하는 곳, 스크립트를 실행할 수 있는 전용 템플릿 --%>
    <script>
        ${script}
    </script>
</c:if>