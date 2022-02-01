function productN(id, img, name,price,amount,sum) {
    return `
        <div class="product row" id=${id}>
            <div width="60px">
                <img src="../../resources/img/${img}" alt="${img}" height="100px">
            </div>
            <b>${name}</b>
            <p>
            <span id=${id} class="btn-min">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-dash-circle" viewBox="0 0 16 16">
                    <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
                    <path d="M4 8a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7A.5.5 0 0 1 4 8z"/>
                </svg>
            </span>
${amount} x ${price} = ${sum}</p>
<button type="button" class="btn btn-secondary">Apply coupon</button>
            </div>
            `
}

function product0(id, img, name,price,amount,sum) {
    return `
        <div class="product row" id=${id}>
            <div width="60px">
                <img src="../../resources/img/${img}" alt="${img}" height="100px">
            </div>
            <p>${name}</p>
            <p>
            <span id=${id} class="btn-min">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x-circle" viewBox="0 0 16 16">
                    <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
                    <path d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z"/>
                </svg>
            </span>
${amount} x ${price} = ${sum}</p>
<button type="button" class="btn btn-secondary">edit</button>
            </div>
            `
}
function cartTotal(tot) {
    return `
    <h6>All prices include VAT if applicable</h6> <b>ORDER TOTAL: ${tot}</b>
            `
}

function fillProductsList(products) {
    let list = $('#products-list');
    let list2 = $('#last-element');
    let tot=0;
    products.forEach(p => {
        let validPrice = p.product.pformattedPrice;
        if(p.product.costAfterApplyingCoupon!=null)
        {
            validPrice = p.product.costAfterApplyingCoupon;
        }
        let sum=validPrice* p.spd.quantity;
        tot=tot+sum;
        if(p.spd.quantity!=1) {
            console.log("mas de uno" + p.spd.quantity);
            list.append(productN(p.spd.shoppingProductDetailsID, p.product.pimagePath , p.product.pname, validPrice, p.spd.quantity, sum));
        }else {
            console.log("es uno" + p.spd.quantity);
            list.append(product0(p.spd.shoppingProductDetailsID, p.product.pimagePath , p.product.pname, validPrice, p.spd.quantity, sum));
        }
    })
    list2.append(cartTotal(tot));
//  array
    const cButList = document.querySelector('.btn-min');
    const arr = Array.from(cButList);
    console.log(arr);
}
    // cButList.addEventListener('click', (event)=>{
    //     console.log(event);
    // })

function getCart() {
    let pathArray = window.location.pathname.split('/')
    let cID = pathArray[3]
    // let cID = pathArray[pathArray.length-1]
    
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

function ApplyCoupon() {
    let pathArray = window.location.pathname.split('/')
    let cID = pathArray[3]
    // let cID = pathArray[pathArray.length-1]
    
    let settings = {
        url: `/shoppingcart/getProductsInCart/${cID}`,
        method: 'POST',
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

