function login(email, password) {
  let data = { email, password };

  let settings = {
    url: '/user/api/login/',
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
      if (res.role == 10) {
        window.location.href = '/admin-side/'
      } else {
        window.location.href = '/'
      }
    },
    error: (err) => {
      console.log('error', err);
      $('.error-message').removeClass('d-none');
    }
  };

  $.ajax(settings);
}

$('#login_form').on('submit', (e) => {
  e.preventDefault();
  let inputs = e.target.children;
  let email = inputs[0].children[0].value;
  let password = inputs[1].children[0].value;
  if(email && password) {
    login(email, password);
  }
})
