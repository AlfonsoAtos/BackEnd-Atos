// function signup() {
// 	console.log($('#signup_form'));
//   let form = $('#signup_form');
//   console.log(form[0]);
//   // alert('submit signup');
//   return false;
// }

$('.error-message').hide()

function registerUser(name, email, number, password) {
  console.log('buenas');
  let settings = {
    url: '/api/user/signup',
    method: 'POST',
    dataType: 'JSON',
    data: JSON.stringify({name, email, number, password}),
    async: false,
    cache: false,
    success: (res) => {
      console.log('success', res);
    },
    error: (err) => {
      console.log('error', err);
    }
  };

  $.ajax(settings);
}

$('#signup_form').on('submit', (e) => {
  console.log('submit')
  console.log(e)
  console.log(e.target)
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
