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
  if (checkSession()) {
    // Show user name
  } else {
    // Redirect??/
  }
}

function logout() {
  localStorage.removeItem('session');
  //reload page
  window.location.href = '/';
}
