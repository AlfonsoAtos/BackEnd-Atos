function addToCart(product) {
    let pID = $(product).attr('data-pID');

    $.ajax({
        type: 'POST',
        contentType: 'text/plain',
        url: 'addtocart/' + pID,
        dataType: 'text',
        cache: false,
        timeout: 600000,
        success: (data) => {
            $('#addToCartNotification').toast('show');
            setTimeout(() => { 
                $('#addToCartNotification').toast('hide');
            }, 5000);
            let cartCounter =  $('#cartCounter');
            let numProductsInCart = $('#cartCounter').text();
            cartCounter.text(+numProductsInCart + 1);
        },
        error: (e) => {
            console.log(e);
        }
    });

}