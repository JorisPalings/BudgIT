$(document).ready(function() {
    
    $('li.dateTime').each(function() {
        var ISOdate = $(this).text().split(".")[0].trim();
        var localeDate = new Date(ISOdate);
        var options = { 
            weekday: 'long', 
            year: 'numeric', 
            month: 'numeric', 
            day: 'numeric',
            hour: '2-digit',
            hour12: false,
            minute: '2-digit'
        };
        $(this).text(localeDate.toLocaleString('en-GB', options));
    });
    
})