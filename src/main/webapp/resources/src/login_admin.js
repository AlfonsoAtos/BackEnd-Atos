function login_admin(email, password) {
  let data = { email, password };

  let settings = {
    url: '/api/admin/login/',
    method: 'POST',
    dataType: 'JSON',
    data: data,
    async: false,
    cache: false,
    success: (res) => {
      localStorage.setItem('admin_session', JSON.stringify({
        email: res.email,
        password: res.password
      }));
      // console.log(JSON.parse(localStorage.getItem('session')));
      window.location.href = '/index.html'
    },
    error: (err) => {
      console.log('error', err);
    }
  };

  $.ajax(settings);
}

$('#login_admin_form').on('submit', (e) => {
  e.preventDefault();
  let inputs = e.target.children;
  let email = inputs[0].children[0].value;
  let password = inputs[1].children[0].value;
  if(email && password) {
    login_admin(email, password);
  }
})
