/*
const API_URL = "/shoppingcart/getProductsInCart/";

const xhr = new XMLHttpRequest();

function onRequestHandler(){
    if(this.readyState ===4&&this.status===200){
        //0 = UNSET
        //1 = OPENED
        //2 = HEADERS_RECEIVED
        //3 = LOADING
        //4 = DONE
        console.log(this.response);
    }
}

xhr.addEventListener("load",onRequestHandler);
xhr.open("GET",`${API_URL}123`);
xhr.send();
*/


const url = "/shoppingcart/getProductsInCart/123";
fetch(url)
.then(res=>res.json())
.then(data=>console.log(data))
.catch(err=>console.log(err))


