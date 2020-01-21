function myfun(){
var a = document.getElementById("fname").value;
var b = /^[A-Za-z]+$/;


if(a==""){
    document.getElementById("message").innerHTML="** please fill fname";
    return false;
}
if(a.match(b))
    true;
 else{
        document.getElementById("message").innerHTML="** only alphabets are allowed";
        return false;
    }

    var c = document.myfun.Email.value;
    if(c.indexOf('@')<=0){
        document.getElementById("message").innerHTML="** invalid @ position";
        return false;
    }
     var d=document.getElementById("mobile").value;;
if(d==""){
    document.getElementById("message").innerHTML="** please fill mobile number";
    return false;
}
  if(isNaN(d))  {
      document.getElementById("message").innerHTML="** mobile number must be number";
      return false;
  }
  if(d.length>10 && d.length<10){
      document.getElementById("message").innerHTML="** mobile number must be 10 digit "

  }
}
function signup(){
    document.getElementById("signup").innerHTML = "sign up successfull now please login ";
        
          
      }
      

