function getNumProductsInCart() {
    if (checkSession()) {
        let uID = session.id;
        $.ajax({
            type: 'POST',
            contentType: 'text/plain',
            url: `numproductsincart/${uID}`,
            dataType: 'text',
            cache: false,
            timeout: 600000,
            success: (data) => {
                let cartCounter =  $('#cartCounter');
                cartCounter.text(data);
            },
            error: (e) => {
                console.log(e);
            }
        });
    }
}
