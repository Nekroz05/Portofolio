function goToSpecifiedDramaDetailPage(country){
    
    localStorage["country"] = country;

}

function arriveAtDramaDetail(){
    var value = localStorage["country"];

    document.getElementById("COUNTRYNAME").innerHTML = value;

}