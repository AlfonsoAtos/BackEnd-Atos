function addToCart(product) {
    if (checkSession()) {
        let pID = $(product).attr('data-pID');
        let uID = session.id;
    
        $.ajax({
            type: 'POST',
            contentType: 'text/plain',
            url: `addtocart/${pID}/${uID}`,
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
    } else {
        // Show that user has to login
        console.log('user is not logged in');
    }
}