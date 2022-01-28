function addToCart(product) {
    if (checkSession()) {
        let pID = $(product).attr("data-pID");
        let uID = session.id;
    
        $.ajax({
            type: "POST",
            contentType: "text/plain",
            url: `addtocart/${pID}/${uID}`,
            dataType: 'text',
            cache: false,
            timeout: 600000,
            success: function (data) {
                $('#addToCartNotification').toast('show');
                setTimeout(function() { 
                    $('#addToCartNotification').toast('hide');
                }, 5000);
            },
            error: function (e) {
                console.log(e);
            }
        });
    } else {
        // marcar error
    }

}