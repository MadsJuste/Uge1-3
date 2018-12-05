
const Button = document.querySelector("#buttons");
const Equals = document.querySelector("#calculate");
const Display = document.querySelector("#display");

var setUpCalculation = ""; 
var calculationResult;

function displayCalculation(string)
{
    Display.innerText = string;
}

function Calculation()
{
     setUpCalculation = eval(setUpCalculation);
    

    console.log(setUpCalculation);
    displayCalculation(setUpCalculation);
}

Button.addEventListener("click",function(event){
    setUpCalculation += event.target.innerText;
    displayCalculation(setUpCalculation);

},false);

Equals.addEventListener("click", function(event) {
    let s = eval(setUpCalculation);
    console.log(setUpCalculation);
    displayCalculation(s);
    event.stopPropagation();
    setUpCalculation = s;
    //setUpCalculation = "";
});



