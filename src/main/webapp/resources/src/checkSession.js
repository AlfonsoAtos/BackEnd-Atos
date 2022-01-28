let session;

function checkSession() {
  if (!session) {
    session = JSON.parse(localStorage.getItem('session'));
  }
  return session;
}

function checkSessionUser() {
  if (checkSession()) {
    $('#user-icon').html('<a href="#"><i class="fas fa-user"></i></a>');
  } else {
    $('#user-icon').html('<a href="/user/login/"><button type="button" class="btn btn-primary">Log in</button></a>');
  }
}

function checkSessionAdmin() {
  if (checkSession()) {
    // Show user name
  } else {
    // Redirect??/
  }
}


