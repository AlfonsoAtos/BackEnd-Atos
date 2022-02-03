let session;
let cid = 0;

function getCID() {
  let settings = {
    url: `/shoppingcart/getInsessionCart/${session.id}/`,
    method: 'GET',
    dataType: 'JSON',
    contentType: 'application/JSON'
  };

  $.ajax(settings)
  .then(res => {
    cid = res.shoppingCartID;
    $('#cartBtn').attr('href', `/user/check/${cid}`);
  })
  .catch(err => {
    console.log(err);
  });
}

function checkSession() {
  if (!session) {
    session = JSON.parse(localStorage.getItem('session'));
    if (session) {
      getCID();
    }
  }
  return session;
}

function checkSessionUser() {
  if (checkSession()) {
    $('#user-icons').removeClass('d-none');
    $('#user-name').text(session.name);
  } else {
    $('#login-button').removeClass('d-none');
  }
}

function checkSessionAdmin() {
  if (checkSession() && session.role == 10) {
    // Show user name
    $('#admin-name').text(session.name);
  } else {
    window.location.href = '/user/login'
  }
}

function logout() {
  let path = '/';
  if (session.role == 10) {
    path = '/user/login/';
  }
  localStorage.removeItem('session');
  window.location.href = path;
}
