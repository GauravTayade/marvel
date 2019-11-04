<%-- 
    Document   : index
    Created on : 2-Nov-2019, 1:39:42 PM
    Author     : tayad
--%>

<jsp:include page="common/header.jsp"></jsp:include>

<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
        <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="3"></li>        
    </ol>
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="resources/images/poster.jpg" class="d-block w-100" alt="...">
        </div>
        <div class="carousel-item">
            <img src="resources/images/slide-1.jpg" class="d-block w-100" alt="...">
        </div>
        <div class="carousel-item">
            <img src="resources/images/slide-2.png" class="d-block w-100" alt="...">
        </div>
        <div class="carousel-item text-center">
            <video autoplay="autoplay" muted>
                <source src="resources/videos/intro-720.mp4" type="video/mp4">
                Your browser does not support the video tag.
            </video>
        </div>
    </div>
    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>

<div class="row m-5">
    <div class="col-md-5 text-center">
        <div class="col-md-12">
            <div class="col-md-12">
                <img src="resources/images/heros/nick_fury.jpg" class="rounded img-fluid heros-intro-img box-shadow" alt="...">
            </div>
            <div class="col-md-12 p-2">
                <h3 class="display-4 text-shadow">Nick Fury</h3>
            </div>
        </div>
    </div>
    <div class="col-md-7 p-4 text-center">
        <p class="text-justify">
            <blockquote cite="https://marvel.fandom.com/wiki/Nicholas_Fury_(Earth-616)">
                <p class="text-justify">I've killed... More times than I can count. I've burned 
                worlds. Destabilised galaxies. Dethroned gods. And I did it 
                without any of them even knowing my name. That's what it means 
                to be the man on the wall. To be the invisible monster who keeps
                the other monsters at bay.</p>
                <footer>-<cite title="Source Title">Nick Fury</cite></footer>
            </blockquote>
        </p>
    </div>
</div>
<hr/>
<div class="row m-5">
    <div class="col-md-7 p-4 text-center">
        <p class="text-justify">Set in the 1990s, Marvel Studios? Captain Marvel is an all-new 
            adventure from a previously unseen period in the history of the 
            Marvel Cinematic Universe that follows the journey of Carol Danvers 
            as she becomes one of the universe?s most powerful heroes. While a 
            galactic war between two alien races reaches Earth, Danvers finds 
            herself and a small cadre of allies at the center of the maelstrom.
        </p>
    </div>
    <div class="col-md-5 text-center">
        <div class="col-md-12">
            <div class="col-md-12">
                <img src="resources/images/heros/captain_marvel.jpg" class="rounded img-fluid heros-intro-img box-shadow" alt="...">
            </div>
            <div class="col-md-12 p-2">
                <h3 class="display-4 text-shadow">Captain Marvel</h3>
            </div>
        </div>
    </div>
</div>
<hr/>
<div class="row m-5">
    <div class="col-md-5 text-center">
         <div class="col-md-12">
            <div class="col-md-12">
                <img src="resources/images/heros/captain_america.jpg" class="rounded img-fluid heros-intro-img box-shadow" alt="...">
                </div>
            <div class="col-md-12 p-2">
                <h3 class="display-4 text-shadow">Captain America</h3>
            </div>
        </div>
    </div>
    <div class="col-md-7 p-4 text-center">
        <p class="text-justify">Captain Steven Grant "Steve" Rogers is a World War II veteran, a 
            founding member of the Avengers, and Earth's first superhero. Rogers
            had suffered from numerous health problems, and upon America's entry
            into World War II, was rejected from the service within United 
            States Army despite several attempts to enlist. Rogers was the only 
            recipient of the Super Soldier Serum developed by Abraham Erskine 
            under the Strategic Scientific Reserve. Determined to serve, Rogers 
            ultimately volunteered for the Project Rebirth, which enhanced the 
            frail Rogers' body to the peak of human physicality. Mistrusted by 
            Chester Phillips, the head of the SSR, Rogers was relegated to 
            propaganda campaigns, and was given the new moniker of Captain 
            America. Rogers later joined the war with a combat role after he 
            single-handedly liberated captured Allied prisoners of war.</p>
    </div>
</div>
    
<jsp:include page="common/footer.jsp"></jsp:include>
