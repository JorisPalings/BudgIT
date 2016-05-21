$(document).ready(function() {
    
    $("nav").load("includes/nav.html");
    
    jQuery.i18n.properties({
        name:'messages', 
        path:'i18n/', 
        mode:'both',
        language:Cookies.get("lang"),
        checkAvailableLanguages: true,
        async: true,
        callback: function() {
            $("nav ul li a#navHome").text(title_Home);
            $("nav ul li a#navOverview").text(title_Overview);
        }
    });
    
})