function add(a,b){
var c=a+b;
return c;
}

var sum = add(10,20);
console.log('sum is ',sum);

console.log("===========================================")
var n1 = 10;
var str ='10';
if(n1===str){
    console.log('equal')
}else{
    console.log('not equal ')
}

console.log("===========================================")

var a=10;
var b='hello';
console.log('typeof a',typeof a) 
console.log('typeof hello',typeof b)
console.log("========================================")

var nums=[10,20,30];
console.log('typeof num',typeof nums)

var isAry= Array.isArray(nums)
if(isAry === true){
    console.log('num is an array');
}else{
    console.log('num is not an array');
}
console.log("===========================")

var sqr=a=> a*a;
console.log(sqr(10) );

var add=function(a,b){
    return a+b;
}
console.log(add(10,20));


var add=(a,b)=> a+b;
var s= add(10,20);
console.log('sum',s)

console.log(`square of 10 is ${10*10}`)
