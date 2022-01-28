function productHTML(name) {
    return `
        <div class="product row">
            <p>${name}</p>
        </div>
    `
}

function fillProductsList(products) {
    let list = $('#products-list');
    products.forEach(p => {
        list.append(productHTML(p.product.pname));
    })
}

function getCart() {
    let cID = '1'

    let settings = {
        url: `/shoppingcart/getProductsInCart/${cID}`,
        method: 'GET',
        dataType: 'JSON',
        contentType: 'application/JSON',
        success: (res) => {
            console.log(res);
            fillProductsList(res);
        },
        error: (err) => {
          console.log('error', err);
        }
    };

    $.ajax(settings);
}

getCart();

