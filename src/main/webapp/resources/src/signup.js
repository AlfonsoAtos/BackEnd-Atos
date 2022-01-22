$('.error-message').hide()

function registerUser(name, email, number, password) {
  let data = {
    name, email, number, password
  }

  let settings = {
    url: '/api/user/signup/',
    method: 'POST',
    dataType: 'JSON',
    data: data,
    async: false,
    cache: false,
    success: (res) => {
      localStorage.setItem('session', JSON.stringify({
        username: res.username,
        password: res.password
      }));
      // console.log(JSON.parse(localStorage.getItem('session')));
      window.location.href = '/'
    },
    error: (err) => {
      console.log('error', err);
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
    $('.error-message').hide()
    if(name && email && number) {
      registerUser(name, email, number, password);
    }
  } else {
    $('.error-message').show()
  }
  return false;
})
