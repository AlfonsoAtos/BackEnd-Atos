function addToCart(product) {
    let pID = $(product).attr("data-pID");

    $.ajax({
        type: "POST",
        contentType: "text/plain",
        url: "addtocart/" + pID,
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

}