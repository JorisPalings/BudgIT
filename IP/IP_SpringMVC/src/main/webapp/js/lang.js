$(document).ready(function() {
   
    $("select#lang").change(function() {
        window.location.href = $(this).val();
    })
    
});