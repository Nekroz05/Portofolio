$(document).ready(function(){
    var CarouselPicture = $('.carouselImage');
    var index = 0;
    var slideshow = startSlideShow()

    CarouselPicture.hide();
    CarouselPicture.eq(index).show();
    
    $('#nextBtn').click(function(){
        CarouselPicture.eq(index).animate({
            left : '-10vw'
        },function(){
            CarouselPicture.eq(index).hide();
            if(index != 0)
                index -= 1
            else 
                index = CarouselPicture.length - 1;
            CarouselPicture.eq(index).show();
            CarouselPicture.eq(index).animate({
                left: '10px'
            });
        });
    });

    $('#prevBtn').click(function(){
        // window.clearInterval(slideShow); //lom jalan...
        CarouselPicture.eq(index).animate({
            left : '10vw',
        },function(){
            CarouselPicture.eq(index).hide();
            if(index != CarouselPicture.length - 1)
                index += 1
            else 
                index = 0;
            CarouselPicture.eq(index).show();
            CarouselPicture.eq(index).animate({
                left: '0px',
            });
        });
        
        // startSlideShow();
    });

    function startSlideShow(){
        window.setInterval(function(){
            CarouselPicture.eq(index).animate({
                left : '-10vw',
            },function(){
                CarouselPicture.eq(index).hide();
                if(index != 0)
                    index -= 1
                else 
                    index = CarouselPicture.length - 1;
                CarouselPicture.eq(index).show();
                CarouselPicture.eq(index).animate({
                    left: '0px',
                });
            });
        }, 7000);
    }
    
})
