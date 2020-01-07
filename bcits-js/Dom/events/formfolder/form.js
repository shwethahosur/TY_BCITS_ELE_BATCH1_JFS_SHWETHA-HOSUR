function validateform(){
    var loginform=document.forms['loginform']
    var usermail=loginform['user mail'].value;
    var pwd=loginform['user pwd'].value;
    // console.log(loginform)
    // console.log('user mail',usermail)
    // console.log('user pwd',pwd)

    if(usermail.trim().length>5){
        console.log("user mail is valid")
    }else{
      document.getElementById('emailerr').style.display='block'
        console.log("user mail is invalid")
    }

    if(pwd.trim().length>5){
        console.log("pwd is valid")
    }else{
        console.log("pwd is invalid")
    }
}