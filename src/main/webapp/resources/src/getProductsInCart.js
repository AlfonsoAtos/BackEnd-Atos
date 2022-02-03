function getProductsInCart() {
    if (checkSession()) {
        let uID = session.id;
        let settings = {
            url: `productsincart/${uID}`,
            method: 'POST',
            dataType: 'JSON',
            success: (res) => {
                res.forEach(product => {
                    let pID = product.productID;
                    let pQuantity = product.quantity;
                    let pCardID = `#product${pID}Card`;
                    let pModalID = `#modal${pID}`;
                    let cardQuantityInCart = $(pCardID).find('.productQuantityInCart');
                    cardQuantityInCart.text(pQuantity);
                    cardQuantityInCart.parent().removeClass('d-none');
                    let modalQuantityInCart = $(pModalID).find('.productQuantityInCart');
                    modalQuantityInCart.text(pQuantity);
                    modalQuantityInCart.parent().removeClass('d-none');
                });
                $('#product')
            },
            error: (err) => {
                console.log(err);
            }
        };
        $.ajax(settings);
    }
}