<%-- 
    Document   : addAvenger
    Created on : 2-Nov-2019, 1:39:58 PM
    Author     : tayad
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="mylib" uri="/WEB-INF/tlds/powersource.tld" %>
<jsp:include page="common/header.jsp"></jsp:include>
    <div class="row m-5">
        
    </div>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="row my-5">
                <div class="col-md-3"></div>
                <div class="col-md-6" style="background-image: url('resources/images/logo.png'); background-repeat: no-repeat; background-position: bottom right;">
                    <h3 class="display-4 text-center text-shadow">Edit Avenger</h3>
                    <form action="editAvenger.do" method="POST" enctype="multipart/form-data">
                        <input type="hidden" name="avengerUpdateId" value="${AvengerDetail.getId()}">
                        <div class="form-group">
                            <label for="avengerName">Avenger Name:</label>
                            <input type="text"  name="avengerName" class="form-control" id="avengerName" value="${AvengerDetail.getName()}" placeholder="Enter Avenger Name">
                        </div>
                        <div class="form-group">
                            <label for="avengerDescription">Description</label>
                            <input type="text" name="avengerDescription" class="form-control" id="avengerDescription" value="${AvengerDetail.getDescription()}" placeholder="Enter Description">
                        </div>
                        <div class="form-group">
                            <label>Power Source:</label>
                            <mylib:powerSource avengerPowerSourceId="${AvengerDetail.getPowerSource().getId()}"></mylib:powerSource>
                        </div>
                        <div class="form-group">
                            <div class="row">
                                <div class="col-md-6">
                                    <label>Profile Image:</label>
                                    <div class="input-group mb-3">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">Upload</span>
                                        </div>
                                        <div class="custom-file">
                                            <input type="file" class="custom-file-input" id="avengerImage" name="avengerImage">
                                            <label class="custom-file-label" for="inputGroupFile01">Choose file</label>
                                        </div>
                                    </div> 
                                </div>
                                <div class="col-md-6">
                                <c:choose>
                                <c:when test="${not empty AvengerDetail.getImgURL()}">
                                    <img src="${AvengerDetail.getImgURL()}" style="height:250px;width:250px;" class="rounded img-fluid box-shadow" id="avengerImagePreview">
                                </c:when>
                                <c:otherwise>    
                                    <img src="resources/images/image-preview.png" style="height:250px;width:250px;" class="rounded img-fluid box-shadow" id="avengerImagePreview">
                                </c:otherwise>
                                </c:choose>
                                </div>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary">Update Avenger</button>
                    </form>
                </div>
                <div class="col-md-3"></div>
                </div>
            </div>
        </div>
    </div>
<jsp:include page="common/footer.jsp"></jsp:include>