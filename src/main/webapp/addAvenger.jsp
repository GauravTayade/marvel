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
                    <form action="#" method="POST">
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
                                <option value=""></option>
                                <option value="amazingtechnology">Amazing Technology</option>
                                <option value="supernatural">Super Natural</option>
                                <option value="thanoschild">Thanos Child</option>
                            </select>
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