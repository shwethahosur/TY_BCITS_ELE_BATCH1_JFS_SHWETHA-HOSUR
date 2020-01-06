var element = document.getElementById('demo')
console.log(element)

console.log(element.textContent) ;

element.textContent ='content changed';
console.log(element)
console.log(element.textContent) ;



var pElement =document.createElement('p')
pElement.textContent ='hii'
document.body.appendChild(pElement)

pElement.style.fontSize = '30px'
pElement.style.color = 'purple'