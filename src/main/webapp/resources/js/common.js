/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
@author Gaurav Tayade
*/

function readURL(input) {
  if (input.files && input.files[0]) {
      
    var ext = input.files[0].name.split('.').pop();
  
    var reader = new FileReader();
    console.log(ext);
    if(ext.toString().toLowerCase() == 'mp4'){
        console.log('called');
        reader.onload  = function(e){
            console.log('inside');
            $('#content').children().remove();
            //var video = "<img src=\"resources/images/video_placeholder.png\" style=\"height:250px;width:250px;\" class=\"rounded img-fluid box-shadow\" id=\"avengerImagePreview\">"
            var  video = "<video width=\"250\" height=\"250\" controls><source src="+e.target.result+" class=\"rounded img-fluid box-shadow\" type=\"video/mp4\"></video> "; 
            console.log(video);
            $('#content').append(video);  
        }
        reader.readAsDataURL(input.files[0]); 
    }else{
        reader.onload = function(e) {
            $('#content').children().remove();
            var image = "<img src="+e.target.result+" style=\"height:250px;width:250px;\" class=\"rounded img-fluid box-shadow\" id=\"avengerImagePreview\">"
            $('#content').append(image);
      //$('#avengerImagePreview').attr('src', e.target.result);
    };
    
    reader.readAsDataURL(input.files[0]);   
    }
  }
}

$("#avengerImage").change(function() {
  readURL(this);
});

$(".btnDelete").on("click",function(e){
    e.preventDefault();
    var avengerIdValue = $(this).data("avengerid");
    
    Swal.fire({
        title: 'Are you sure?',
        text: "You won't be able to revert this!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, delete it!'
        }).then((result) => {
            if (result.value) {
                $.ajax({
                    url     :'deleteAvenger.do',
                    type    : "GET",
                    cache   : false,
                    data    : {id:avengerIdValue},
                    dataType: "json",
                    success: function (responseObj){
                        if(responseObj.result ==1){
                            Swal.fire(
                                'You have Removed an Avenger!',
                                'We Lost our Commarade.',
                                'success'
                            )
                        }else{
                            Swal.fire(
                                'Something went Wrong',
                                'Unable to Delete the record',
                                'error'
                            )
                        }
                    },
                    error: function (result){
                        console.log(result)
                    }
                })
            $(this).parent().parent().parent().remove();
            }else{
                Swal.fire(
                    'You Saved a Hero',
                    'Your hero is Still Part of Avenger.',
                    'success'
                )                
            }
        })
});

	window.onload = function() {
        Particles.init({
          selector: '.background',
          speed:0.5,
          color: '#75A5B7',
          maxParticles: 180,
          connectParticles: true,
          responsive: [
            {
              breakpoint: 768,
              options: {
                maxParticles: 80
              }
            }, {
              breakpoint: 375,
              options: {
                maxParticles: 50
              }
            }
          ]
        });
      };