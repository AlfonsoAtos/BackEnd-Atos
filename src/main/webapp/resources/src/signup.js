function registerUser(fullname, email, number, password) {
  let data = {
    fullname, email, number, password
  }

  let settings = {
    url: '/user/api/signup/',
    method: 'POST',
    dataType: 'JSON',
    contentType: 'application/JSON',
    data: JSON.stringify(data),
    success: (res) => {
      localStorage.setItem('session', JSON.stringify({
        id: res.id,
        name: res.fullname,
        email: res.email,
        password: res.password,
        role: res.role
      }));
      // console.log(JSON.parse(localStorage.getItem('session')));
      window.location.href = '/'
    },
    error: (err) => {
      console.log('error', err);
      $('#signup-error').removeClass('d-none')
    }
  };

  $.ajax(settings);
}

$('#signup_form').on('submit', (e) => {
  let inputs = e.target.children;
  let name = inputs[0].children[0].value;
  let email = inputs[1].children[0].value;
  let number = inputs[2].children[0].value;
  let password = inputs[3].children[0].value;
  let confirmPassword = inputs[4].children[0].value;
  if(password && confirmPassword && password == confirmPassword) {
    $('#password-error').addClass('d-none')
    if(name && email && number) {
      registerUser(name, email, number, password);
    }
  } else {
    $('#password-error').removeClass('d-none')
  }
  return false;
})
