$(document).ready(function() {
    
    // Call to REST API
    $.get("http://193.191.187.14:10648/IP_REST/categories", function(data) {
        var total = 0.00;
        $.each(data, function() {
            $("main").append("<section>");
            var newestSection = $("main section:last-of-type");
            newestSection.append("<a class='rest' href='/IP_REST/categories/" + this.id + "'><img class='options' src='images/delete.png' alt='Delete'></a>");
            newestSection.append("<h2 class='toggleable'>" + this.name + "</h2>");
            newestSection.append("<dl></dl>");
            var newestSectionExpenses = $("main section:last-of-type dl")
            var subtotal = 0.00;
            for(var i = 0; i < this.expenses.length; i ++) {
                newestSectionExpenses.append("<dt>" + this.expenses[i].name + "</dt>");
                newestSectionExpenses.append("<dd>" + this.expenses[i].amount + "</dd>");
                subtotal += this.expenses[i].amount;
            }
            if(subtotal > 0) {
                newestSectionExpenses.append("<dt>Subtotal</dt>");
                newestSectionExpenses.append("<dd>" + subtotal + "</dd>");
            }
            total += subtotal;
            $("main").append("</section>");
        });
        $("main").append("<section><dl><dt>Total</dt><dd>" + total + "</dd></dl></section>");
    });
    
    jQuery.i18n.properties({
        name: 'messages',
        path: 'i18n/', 
        mode: 'both',
        language: Cookies.get("lang"),
        checkAvailableLanguages: true,
        async: true,
        callback: function() {
            var lang = Cookies.get("lang");
            $("dt:last-of-type").text(info_CategoryTotal);
            $("section:last-of-type dt").text(info_Total);
        }
    });
    
});