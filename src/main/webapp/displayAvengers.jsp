<%-- 
    Document   : displayAvengers
    Created on : 2-Nov-2019, 1:40:11 PM
    Author     : tayad
--%>

<jsp:include page="common/header.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
    <div class="row m-5">
        
    </div>
    <div class="container-fluid">
        <div class="row text-center">
            <c:forEach var="avenger" items="${avengersList}">
                <div class="card mx-5 my-5 box-shadow hero-card" style="width: 17.5rem;">
                    <img src="${avenger.getImgURL()}" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title text-center">${avenger.getName()}</h5>
                        <p class="card-text">${avenger.getDescription()}</p>
                        <h5 class="card-title text-center">Power Source:</h5>
                        <p class="card-text">${avenger.getPowerSource().getDescription()}</p>
                        <a href="deleteAvenger.do?id=${avenger.getId()}" class="btnDelete" id="btnDelete">Info</a>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
<jsp:include page="common/footer.jsp"></jsp:include>
