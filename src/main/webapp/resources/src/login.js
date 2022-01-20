function login(email, password) {
  let data = { email, password };

  // console.log(data);
  // console.log('buenas');
  let settings = {
    url: '/api/user/login/',
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

$('#login_form').on('submit', (e) => {
  console.log('submit')
  console.log(e)
  console.log(e.target)
  e.preventDefault();
  let inputs = e.target.children;
  let email = inputs[0].children[0].value;
  let password = inputs[1].children[0].value;
  if(email && password) {
    login(email, password);
  }
})
