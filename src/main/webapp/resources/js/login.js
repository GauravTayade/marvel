/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
@author Gaurav Tayade
*/
$(document).ready(function() {
    $("#btnLogin").on("click", function() {
        
        var username = $('#inputUsername').val();
        var password = $('#inputPassword').val();
        
        if(username == null || username == '' && 
                password == null || password == ''){          
            Swal.fire({
                    imageUrl: 'resources/images/incorrect_password.jpg',
                    imageHeight: 100,
                    imageAlt: 'A tall image',
                    title: 'Empty Inputs',
                    text: 'Please! Enter values in input!',
                    type: 'warning'
                })
        }else{
                                
            $.ajax({
            url      : "userLogin.do",
            type     : "POST",
            cache    : false,
            data     : {username:$('#inputUsername').val(),password:$('#inputPassword').val()},
            dataType : "json",
            success  : function(results) {
                       if(results == true){
                           Swal.fire({
                            title: 'Welcome!',
                            imageUrl: 'resources/images/loading.gif',
                            showConfirmButton: false,
                            imageHeight: 200,
                            text: 'Redirecting!',
                            type: 'success',
                            timer: 6000,
                        });
                        window.setTimeout(function(){ location.reload(true) } ,6000);
                       }else{
                           Swal.fire({
                            imageUrl: 'resources/images/incorrect_password.jpg',
                            imageHeight: 100,
                            imageAlt: 'A tall image',
                            title: 'Incorrect Credentials!',
                            text: 'Please! Enter Valid Credentials!',
                            type: 'warning'
                        })
                       }
                   },
           error    : function(results) {
                        console.log("error");
                    }
                });
            }
        });
    });