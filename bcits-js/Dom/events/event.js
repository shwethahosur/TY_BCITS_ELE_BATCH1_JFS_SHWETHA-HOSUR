


var ele=   document.createElement('p')

function showAlert(){
    alert("hi welcome to cinemahall!!!")
}

function myElement(){
  ele.textContent= " created element"  
document.body.appendChild(ele)
    
}
function displayelement(){
    
  var dispelement = document.getElementById('disp')
  var mybtn=document.getElementById('mybtn');
  if(dispelement.style.display===''||dispelement.style.display==='none'){
dispelement.style.display = 'block'
mybtn.textContent='click here to hide element'
  }else{
    dispelement.style.display='none'
mybtn.textContent="click here to show element"
  }
  
}

function changecolourblue(){
var click=documen.getElementById('disp')
click=style.background='blue';
click=style.fontsize='10px';
}
function changecolourwhite(){
    var click=documen.getElementById('disp1')
    click=style.background='white';
    click=style.fontsize='20px';
    }

    function showData(){
        console.log("working")
    }
    function showDetail(){
        console.log("working fine")
    }
    
    function getinputvalue(){
        var input=document.getElementById('inp')
        console.log(input.value)

        var showElement =document.getElementById('show')
        showElement.textContent=input.value;

    }


