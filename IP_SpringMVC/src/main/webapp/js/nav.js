$(document).ready(function() {
    
    $("nav ul li a").each(function() {
        if("BudgIt - " + $(this).text() === $("title").text()) {
            $(this).css({background: "#3b629b", color: "#fff"});
        }
    });

});