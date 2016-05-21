$(document).ready(function() {

    jQuery.i18n.properties({
        name: 'messages',
        path: 'i18n/', 
        mode: 'both',
        language: Cookies.get("lang"),
        checkAvailableLanguages: true,
        async: true,
        callback: function() {
            var lang = Cookies.get("lang");
            $("main section h2#helloWorld").text(info_HelloWorld);
        }
    });
    
})