function productN(id, img, name, description, price, amount, sum, pcat) {
    return `
        <tr>
            <td width="80px">
                    <img src="../../resources/img/${img}" alt="${img}" height="120px">
            </td>
            <td style="padding-left:20px;">
                <b>${name}</b>
                <p>${description.slice(0,80)}<span style="display:inline;" id="points-${id}"> ...</span><span style="display:none;" id="moreText-${id}">${description.slice(81,description.length-1)}</span>
                <button style="display:inline; background:none; color:blue; border:none; padding:0; font:inherit; outline:inherit;" onclick="toggleText(${id})" id="textButton-${id}">Show More</button>
                </p>
                <span>
                    <svg id="btn-min-${id}" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-dash-circle" viewBox="0 0 16 16">
                        <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
                        <path d="M4 8a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7A.5.5 0 0 1 4 8z"/>
                    </svg>       
                </span>
                ${amount}
                <span>
                    <svg id="btn-plus-${id}" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus-circle" viewBox="0 0 16 16">
                        <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
                        <path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z"/>
                    </svg>
                </span>
                x ${price} = ${sum}
                <p><a id="coupon-${id}-${pcat}" href="javascript:void(0)">Apply coupon</a></p>
            </td>
        </tr>
            `
}
function toggleText(id){
    var points = document.getElementById(`points-${id}`);
    var moreText = document.getElementById(`moreText-${id}`);
    var buttonText = document.getElementById(`textButton-${id}`);
    if(points.style.display=="none"){
        moreText.style.display= "none";
        points.style.display="inline";
        buttonText.innerHTML="Show More";
    }else{
        moreText.style.display= "inline";
        points.style.display="none";
        buttonText.innerHTML="Show Less";
    }
    
}
function product0(id, img, name, description, price, amount, sum, pcat) {
    return `
        <tr>
            <td width="80px">
                    <img src="../../resources/img/${img}" alt="${img}" height="120px">
            </td>
            <td style="padding-left:20px;">
                <b>${name}</b>
                <p>${description.slice(0,80)}<span style="display:inline;" id="points-${id}"> ...</span><span style="display:none;" id="moreText-${id}">${description.slice(81,description.length-1)}</span>
                <button style="display:inline; background:none; color:blue; border:none; padding:0; font:inherit; outline:inherit;" onclick="toggleText(${id})" id="textButton-${id}">Show More</button>
                </p>
                <span>
                    <svg id="btn-min${id}" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x-circle" viewBox="0 0 16 16">
                        <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
                        <path d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z"/>
                    </svg>
                </span>
                ${amount}
                <span>
                    <svg id="btn-plus-${id}" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus-circle" viewBox="0 0 16 16">
                        <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
                        <path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z"/>
                    </svg>
                </span> 
                x ${price} = ${sum}
                <p><a id="coupon-${id}-${pcat}" href="javascript:void(0)">Apply coupon</a></p>
            </td>
        </tr>
            `
}
function cartTotal(tot) {
    return `ORDER TOTAL: $ ${tot.toFixed(2)}`
}

function fillProductsList(products) {
    let list = $('#products-list');
    let payment = $('#price');
    let tot=0;
    products.forEach(p => {
        let validPrice = p.product.pformattedPrice;
        if(p.spd.costAfterApplyingCoupon>0)
        {
            validPrice = p.spd.costAfterApplyingCoupon;
        }
        let sum=validPrice* p.spd.quantity;
        tot=tot+sum;
        if(p.spd.quantity!=1) {
            list.append(productN(p.spd.shoppingProductDetailsID, p.product.pimagePath , p.product.pname, p.product.pdescription, validPrice, p.spd.quantity, sum, p.product.pcategoryID));
        }else {
            list.append(product0(p.spd.shoppingProductDetailsID, p.product.pimagePath , p.product.pname, p.product.pdescription, validPrice, p.spd.quantity, sum, p.product.pcategoryID));
        }
    })
    payment.append(cartTotal(tot));    
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
function validateCoupon(coupon,id,catp){
    //YZX12345
    let desc = coupon.couponDiscount;
    
    let catc = coupon.productCategoryName;
    let pathArray = window.location.pathname.split('/')
    let cid = Number(pathArray[3]);
    if(catc==catp){
        console.log();
        let settingsc = {
            url: `/shoppingcart/savePriceAfterCoupon/${cid}/${id}/${desc}`,
            method: 'post',
            dataType: 'JSON',
            contentType: 'application/JSON',
            success: (res) => {
                console.log(res);
            },
            error: (err) => {
              console.log('error', err);
            }
        };
        
        $.ajax(settingsc);
        location.reload();
        //jsgs-- al ser de la misma categoria mandar llamar el api y calcular el precio
        ///shoppingcart/savePriceAfterCoupon?shoppingCartID=1&productID=7&price=5
    }else {
        console.log(catc,catp);
        document.getElementById("tcoupon").value="";
    }
}

function applyCoupon(id,coupon,catp){
    let settings = {
        url: `/admin-side/validateCoupon/${coupon}`,
        method: 'GET',
        dataType: 'JSON',
        contentType: 'application/JSON',
        success: (res) => {
            console.log(res);
            validateCoupon(res,id,catp);
        },
        error: (err) => {
          console.log('error', err);
        }
    };
    
    $.ajax(settings);
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
    if(e.target.matches('a')){
        let tcoupon = document.getElementById('tcoupon').value;
        let funArray = e.target.id.split('-')    
        if(tcoupon!=''){
            applyCoupon(funArray[1],tcoupon,funArray[2])
        } else {
            alert("empty coupon");
            console.log("empty coupon");
        }
    }
    if(e.target.matches('#checkAGift')){
        var mail = document.getElementById('emailGift');
        if(mail.style.display=="none"){
            mail.style.display="inline";
        }else{
            mail.style.display="none";
        }
    }
    if(e.target.matches('#btn-payment')){
        let cnumber = document.getElementById('cnumber').value;
        let ccvv = document.getElementById('ccvv').value;
        let cdate = document.getElementById('cdate').value;
        console.log(cnumber,ccvv,cdate);
        if(cnumber==''||ccvv==''||cdate==''){
            console.log("algun dato falta");
        } else{            
            let pathArray = window.location.pathname.split('/')
            let cID = pathArray[3]    
            let settings = {
                url: `/shoppingcart/completeCart/${cID}`,
                method: 'post',
                dataType: 'JSON',
                contentType: 'application/JSON',
                success: (res) => {
                    console.log(res);
                    window.location.href="/";
                },
                error: (err) => {
                console.log('error', err);
                }
            };
            $.ajax(settings);
        }
    }
    if(e.target.matches('#btn-payment')){

    }
})

