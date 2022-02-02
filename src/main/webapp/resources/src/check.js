function productN(id, img, name,price,amount,sum) {
    return `
        <div class="product row" id=${id}>
            <span width="60px">
                <img src="../../resources/img/${img}" alt="${img}" height="100px">
            </span>
            <b>${name}</b>
            <p>
            <span>
                <svg id="btn-min-${id}" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-dash-circle" viewBox="0 0 16 16">
                    <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
                    <path d="M4 8a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7A.5.5 0 0 1 4 8z"/>
                </svg>
                
                </span>
                ${amount} x ${price} = ${sum}
                <span>
                    <svg id="btn-plus-${id}" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus-circle" viewBox="0 0 16 16">
                        <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
                        <path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z"/>
                    </svg>
                </span>
            </p>

            <p><a id="${id}" onclick="coupon" href="#">Apply coupon</a></p>

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
                <span>
                    <svg id="btn-min${id}" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x-circle" viewBox="0 0 16 16">
                        <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
                        <path d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z"/>
                    </svg>
                </span>
                ${amount} x ${price} = ${sum}
                <span>
                    <svg id="btn-plus-${id}" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus-circle" viewBox="0 0 16 16">
                        <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
                        <path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z"/>
                    </svg>
                </span>
            </p>

            <p><a id="${id}" href="#">Apply coupon</a></p>
            
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
}

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


getCart();

function qminus(id){
    let pathArray = window.location.pathname.split('/')
    let cID = pathArray[3]
    let url = `/shoppingcart/removeProductFromCart2/${cID}/${id}`;
    fetch(url,{
        method:'POST',
    }).then(res=>res.json())
    .catch(error=>console.error('Error:', error))
    .then(response=>console.log('Success:', response));
    location.reload();
}
function qplus(id){
    let pathArray = window.location.pathname.split('/')
    let cID = pathArray[3]
    let url = `/shoppingcart/addProductToCart/${cID}/${id}`;
    fetch(url,{
        method:'POST',
    }).then(res=>res.json())
    .catch(error=>console.error('Error:', error))
    .then(response=>console.log('Success:', response));
    location.reload();    
}
function btnCoupon(id){
    if(ibtn){
        ibtn=!ibtn;
        
    }
}

document.addEventListener("click",(e)=>{
    if(e.target.matches('svg')){
    let funArray = e.target.id.split('-')
    console.log(funArray)
        if(funArray[1]=="plus"){
            console.log("Click en span plus ", funArray[2]);
            qplus(funArray[2])

        }else if(funArray[1]=="min"){
            console.log("Click en span min ", funArray[2]);
            qminus(funArray[2])
        }
    }
})



