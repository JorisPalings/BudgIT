$(document).ready(function() {
    
    $('main section').children('.toggleable').click(function() {

        if($(this).parent().children('dl').first().css("display") == "block") {
            $(this).parent().children('.arrow').css("transform", "none");
            $(this).parent().children('dl').add($(this).parent().children('ul')).first().slideUp(200);
        }

        if($(this).parent().children('dl').first().css("display") == "none") {
            $(this).parent().children('.arrow').css("transform", "rotate(90deg)");
            $(this).parent().children('dl').first().slideDown(200);
        }

        if($(this).parent().children('ul').first().css("display") == "block") {
            $(this).parent().children('.arrow').css("transform", "none");
            $(this).parent().children('ul').first().slideUp(200);
        }

        if($(this).parent().children('ul').first().css("display") == "none") {
            $(this).parent().children('.arrow').css("transform", "rotate(90deg)");
            $(this).parent().children('ul').first().slideDown(200);
        }

    })
    
});