$(document).ready(function() {
    
    jQuery.i18n.properties({
        name:'messages', 
        path:'i18n/', 
        mode:'both',
        language:Cookies.get("lang"),
        checkAvailableLanguages: true,
        async: true,
        callback: function() {
            var propertyName = "title_" + $("header h1").text();
            propertyName = eval(propertyName);
            $("header h1").text(propertyName);
        }
    });
    
})