function validateForm() {
    var loginForm = document.form['loginForm'];
    var meterNo = loginForm['meterNo'].value;
    var userMail = loginForm['Email'].value;
    var pwd = loginForm['userPassword'].value;
    var mblNo = loginForm['mobileNo'].value;

    if (meterNo.trim().length > 5) {
        document.getElementById('meterErr').style.display = 'none'
        console.log('meter  number is valid');
        document.getElementById('meternumber').style.border = '1px solid gray'
    } else {
        document.getElementById('meterErr').style.display = 'block'
        console.log('meter number is invalid');
        document.getElementById('meternumber').style.border = '1px solid red'
    }
    if (userMail.trim().length > 6) {
        document.getElementById('emailErr').style.display = 'none'
        console.log('user mail is valid');
        document.getElementById('usermail').style.border = '1px solid gray'
    } else {
        document.getElementById('emailErr').style.display = 'block'
        console.log('user mail is invalid');
        document.getElementById('usermail').style.border = '1px solid red'
    }
    if (mblNo.trim().length > 10) {
        document.getElementById('mobileNoErr').style.display = 'none'
        console.log('Mobile number is valid');
        document.getElementById('mobilenumber').style.border = '1px solid gray'
    } else {
        document.getElementById('mobileNoErr').style.display = 'block'
        console.log('Mobile number is invalid');
        document.getElementById('mobilenumber').style.border = '1px solid red'
    }
    if (pwd.trim().length > 5) {
        document.getElementById('pwdErr').style.display = 'none'
        console.log('Password is valid');
        document.getElementById('userpassword').style.border = '1px solid gray'
    } else {
        document.getElementById('pwdErr').style.display = 'block'
        console.log('Password is invalid');
        document.getElementById('userpassword').style.border = '1px solid red'
    }
    
    
}