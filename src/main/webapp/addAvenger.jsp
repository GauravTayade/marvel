<%-- 
    Document   : addAvenger
    Created on : 2-Nov-2019, 1:39:58 PM
    Author     : tayad
--%>

<jsp:include page="common/header.jsp"></jsp:include>
    <div class="row m-5">
        
    </div>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12 p-5" style="background-image: url('resources/images/bg_stripe.jpg')">
                
            </div>
            <div class="col-md-12">
                <div class="row my-5">
                <div class="col-md-3"></div>
                <div class="col-md-6" style="background-image: url('resources/images/logo.png'); background-repeat: no-repeat; background-position: bottom right;">
                    <h3 class="display-4 text-center text-shadow">Add Avenger</h3>
                    <form action="addAvenger.do" method="POST" enctype="multipart/form-data">
                        <div class="form-group">
                            <label for="avengerName">Avenger Name:</label>
                            <input type="text"  name="avengerName" class="form-control" id="avengerName"placeholder="Enter Avenger Name">
                        </div>
                        <div class="form-group">
                            <label for="avengerDescription">Description</label>
                            <input type="text" name="avengerDescription" class="form-control" id="avengerDescription" placeholder="Enter Description">
                        </div>
                        <div class="form-group">
                            <label>Power Source:</label>
                            <select class="form-control" name="powerSource">
                                <option value="">Select Powersource</option>
                                <option value="1">Amazing Technology</option>
                                <option value="2">Super Natural</option>
                                <option value="3">Thanos Child</option>
                            </select>
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
                                    <img src="resources/images/image-preview.png" style="height:250px;width:250px;" class="rounded img-fluid box-shadow" id="avengerImagePreview">
                                </div>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary">Add Avenger to Team</button>
                    </form>
                </div>
                <div class="col-md-3"></div>
                </div>
            </div>
        </div>
    </div>
<jsp:include page="common/footer.jsp"></jsp:include>