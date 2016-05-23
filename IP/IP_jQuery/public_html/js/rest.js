$(document).ready(function() {
    
    $(document).on("click", "a.rest", function(event) {
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