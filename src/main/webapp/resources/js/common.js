/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
@author Gaurav Tayade
*/

function readURL(input) {
  if (input.files && input.files[0]) {
    var reader = new FileReader();
    
    reader.onload = function(e) {
      $('#avengerImagePreview').attr('src', e.target.result);
    }
    
    reader.readAsDataURL(input.files[0]);
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
                    success: function (result){
                        Swal.fire(
                            'You have Removed an Avenger!',
                            'We Lost our Commarade.',
                            'success'
                        )
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