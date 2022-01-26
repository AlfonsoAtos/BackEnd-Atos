$(document).ready(function () {
	loadCoupons();
});

async function loadCoupons() {
	const request = await fetch('http://localhost:8081/coupons/list', {
		method: 'GET',
		headers: {
			Accept: 'application/json',
			'Content-Type': 'application/json',
		},
	});

	const coupons = await request.json();

	let listHtml = '';
	let actionButtons =
		'</td><td><svg fill="blue" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path d="M17.414 2.586a2 2 0 00-2.828 0L7 10.172V13h2.828l7.586-7.586a2 2 0 000-2.828z"></path><path fill-rule="evenodd" d="M2 6a2 2 0 012-2h4a1 1 0 010 2H4v10h10v-4a1 1 0 112 0v4a2 2 0 01-2 2H4a2 2 0 01-2-2V6z" clip-rule="evenodd"></path></svg><svg fill="red" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M9 2a1 1 0 00-.894.553L7.382 4H4a1 1 0 000 2v10a2 2 0 002 2h8a2 2 0 002-2V6a1 1 0 100-2h-3.382l-.724-1.447A1 1 0 0011 2H9zM7 8a1 1 0 012 0v6a1 1 0 11-2 0V8zm5-1a1 1 0 00-1 1v6a1 1 0 102 0V8a1 1 0 00-1-1z" clip-rule="evenodd"></path></svg></td></tr>';

	for (let coupon of coupons) {
		let couponHtml =
			'<tr><td id="cID">' +
			coupon.cID +
			'</td><td>' +
			coupon.cName +
			'</td><td>' +
			coupon.cCode +
			'</td><td>' +
			coupon.cType +
			'</td><td>' +
			coupon.cDiscount +
			'</td><td>' +
			coupon.pEventID +
			'</td><td>' +
			coupon.pCategoryID +
			actionButtons;
		listHtml += couponHtml;
	}

	console.log(coupons);

	document.querySelector('#couponsTable tbody').outerHTML = listHtml;
}