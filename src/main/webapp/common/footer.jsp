<%-- 
    Document   : footer
    Created on : 2-Nov-2019, 1:27:30 PM
    Author     : Gaurav
--%>
<footer class="bg-dark text-white">
        <div class="row  mr-0">
            <div class="col-md-12 text-center pt-5 pb-5">
                Created with <span style="color: #e25555;">&hearts;</span>  By Gaurav Tayade
            </div>
            <div class="col-md-12 text-center">
                <a href="https://www.facebook.com/gaurav.tayade.33" target="_blank">
                    <i class="fab fa-facebook fa-4x mx-5 mb-4"></i>
                </a>
                <a href="https://www.instagram.com/the_byr0n/" target="_blank">
                    <i class="fab fa-instagram fa-4x mx-5 mb-4"></i>
                </a>
                <a href="https://github.com/GauravTayade" target="_blank">
                    <i class="fab fa-github fa-4x mx-5 mb-4"></i>
                </a>
                <a href="https://www.linkedin.com/in/gaurav-tayade/" target="_blank">
                    <i class="fab fa-linkedin fa-4x mx-5 mb-4"></i>
                </a>
            </div>
        </div>
    </footer>
    </div>
    
    <!--Login modal Start-->
    <div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
    <div class="modal-dialog modal-dailog-login" role="document">
        <div class="modal-content">
            <div class="p-4">
                <h5 class="modal-title text-center" id="exampleModalLongTitle">
                    <img src="resources/images/logo.png" class="img-fluid login-model-img-round">
                </h5>
                <button type="button" class="close login-model-close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                </div>
                <div class="modal-body">
                    <form action="user/login" method="POST">
                        <div class="form-group">
                            <div class="row">
                                <div class="input-prepand col-md-2 text-center">
                                    <i class="fa fa-user"></i>
                                </div>
                                <div class="from-input col-md-10">
                                    <input type="text" name="username" placeholder="Username" class="form-control" id="inputUsername">
                                </div>
                            </div>                        
                        </div>
                        <div class="form-group">
                            <div class="row">
                                <div class="form-prepand col-md-2 text-center">
                                    <i class="fa fa-key"></i>
                                </div>
                                <div class="form-input col-md-10">
                                    <input type="password" name="password" placeholder="*******" class="form-control" id="inputPassword">
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" id="btnLogin">Login</button>
                </div>
            </div>
        </div>
    </div>
    <!--Login modal End-->
    </body>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="resources/js/jQuery.js" type="text/javascript"></script>
    <script src="resources/js/login.js" type="text/javascript"></script>
    <script src="resources/plugins/fontawesome/all.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@8"></script>
    <script src="resources/js/common.js" type="text/javascript"></script>
</html>
