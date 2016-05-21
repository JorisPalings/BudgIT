$(document).ready(function() {
    
    $("a.rest").click(function(event) {
        alert();
        event.preventDefault();
        var url = $(this).attr("href");
        $.ajax({
            url: url,
            type: 'DELETE',
            success: function() {
                alert("Category deleted.");
            }
        });
    })
    
})