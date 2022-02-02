let session;

function checkSession() {
  if (!session) {
    session = JSON.parse(localStorage.getItem('session'));
  }
  return session;
}

function checkSessionUser() {
  if (checkSession()) {
    $('#user-icons').removeClass('d-none');
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
