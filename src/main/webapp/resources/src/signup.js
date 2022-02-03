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

let myInput = document.getElementById("floatingPassword");
let letter = document.getElementById("letter");
let capital = document.getElementById("capital");
let number = document.getElementById("number");
let length = document.getElementById("length");
let valid = 0;

function validatePassword() {
  $('#floatingPassword').on("input", (e) => {
    console.log('a')
    // let myInput = e.target;
    // Validate lowercase letters
    let lowerCaseLetters = /[a-z]/g;
    if(myInput.value.match(lowerCaseLetters)) {
      letter.classList.remove("invalid");
      letter.classList.add("valid");
      valid++;
    } else {
      letter.classList.remove("valid");
      letter.classList.add("invalid");
      valid--;
    }

    // Validate capital letters
    let upperCaseLetters = /[A-Z]/g;
    if(myInput.value.match(upperCaseLetters)) {
      capital.classList.remove("invalid");
      capital.classList.add("valid");
      valid++;
    } else {
      capital.classList.remove("valid");
      capital.classList.add("invalid");
      valid--;
    } 

    // Validate numbers
    let numbers = /[0-9]/g;
    if(myInput.value.match(numbers)) {
      number.classList.remove("invalid");
      number.classList.add("valid");
      valid++;
    } else {
      number.classList.remove("valid");
      number.classList.add("invalid");
      valid--;
    }

    // Validate length
    if(myInput.value.length >= 8) {
      length.classList.remove("invalid");
      length.classList.add("valid");
      valid++;
    } else {
      length.classList.remove("valid");
      length.classList.add("invalid");
      valid--;
    }
  })

  $('#floatingPassword').on('focus', () => {
    $('#message').removeClass('d-none');
  })

  $('#floatingPassword').on('focusout', () => {
    $('#message').addClass('d-none');
  })
  
}

$('#signup_form').on('submit', (e) => {
  let inputs = e.target.children;
  let name = inputs[0].children[0].value;
  let email = inputs[1].children[0].value;
  let number = inputs[2].children[0].value;
  let password = inputs[3].children[0].value;
  let confirmPassword = inputs[5].children[0].value;
  if(password && confirmPassword && password == confirmPassword) {
    console.log()
    $('#password-error').addClass('d-none')
    if(name && email && number) {
      registerUser(name, email, number, password);
    }
  } else {
    $('#password-error').removeClass('d-none')
  }
  return false;
})

validatePassword();
