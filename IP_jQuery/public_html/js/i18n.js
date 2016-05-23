// Using the Cookies and jQuery i18n properties plugins

// Don't start translating until the page is loaded
$(document).ready(function() {
    
    if(Cookies.get("lang") === undefined) {
        Cookies.set("lang", "en");
    }
    
    // Set all Strings to the language in the "lang" cookie
    jQuery.i18n.properties({
        // Properties file name
        name: 'messages',
        // Path to properties file
        path: 'i18n/', 
        mode: 'both',
        language: Cookies.get("lang"),
        checkAvailableLanguages: true,
        async: true,
        callback: function() {
            // Get the current language
            var lang = Cookies.get("lang");
            // Set the select to the current language
            $("select#lang").val(Cookies.get("lang"));
            // Global i18n
            $("nav ul li a#navHome").text(title_Home);
            $("nav ul li a#navOverview").text(title_Overview);
        }
    });
    
    // Set the "lang" cookie's value to the selected value
    $(document).on("change", "select#lang", function() {
        var lang = "en";
        if($(this).val() === "nl_BE") {
            lang = "nl_BE";
        }
        Cookies.set("lang", lang);
        location.reload();
    })
    
})