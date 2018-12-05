const addBoy = document.querySelector("#addboy");
const addGirl = document.querySelector("#addgirl");
const removeBoy = document.querySelector("#removeboy");
const removeGirl = document.querySelector("#removegirl");
const reverse = document.querySelector("#reverse");
const sortL = document.querySelector("#sort");



var boys = ["Peter", "lars", "Ole"];
var girls = ["Janne","hanne","Sanne"];
var reversed = false;
var sortB = false;
var sorted = false;
update(false,false);
// Update arrays
function update(boo, sortB) {
    function name(array, string) {
        
        let node;
        let textNode;
        array.forEach(element =>{
            node = document.createElement("p");
            textNode = document.createTextNode(element);
            node.appendChild(textNode);
            document.querySelector(string).appendChild(node);
        });
        
    }
    
    function remove(string){
        let node = document.querySelector(string);
            while (node.firstChild) {
                node.removeChild(node.firstChild);
            }
    
    }


    let id = "#boys";
    remove(id);
    name(boys, id);
    id = "#girls";
    remove(id);
    name(girls, id);
    id = "#all";
    remove(id);

    if (boo === true && reversed === false) {
        name(boys.concat(girls).reverse() , id); 
        reversed = true;
    } else if (boo === true && reversed === true) {
        boys.reverse();
        girls.reverse();
        name(girls.concat(boys).reverse(), id);
        boys.reverse();
        girls.reverse();
        reversed = false;
    }else if (sortB === true && sorted === false){
        name(boys.concat(girls).sort(function(x,y){
            let a = x.toLowerCase();
            let b = y.toLowerCase();

            if (a<b) { return -1;}
            if (b<a) { return  1;}
            return 0;
        }), id);
        sorted = true;    
    }else if (sortB === true && sorted === true){
        name(boys.concat(girls).sort(function(x,y){
            let a = x.toLowerCase();
            let b = y.toLowerCase();

            if (a<b) { return -1;}
            if (b<a) { return  1;}
            return 0;
        }).reverse(), id);
        sorted = false;
    }else{
        name(boys.concat(girls), id);  
    }
          
}


//Tilføj til array
function addBoyF(){
    let name = document.querySelector("#newboy"); 
    boys.push(name.value);
    update(false,false);
}

function addGirlF(){
    let name = document.querySelector("#newgirl"); 
    girls.push(name.value);
    update(false,false);
}
//slet fra array
function removeBoyF(){
    if( document.querySelector("#last").checked ){
       boys.pop();
    }else{
        boys.shift();
    }
    update(false,false);
}

function removeGirlF(){
    if( document.querySelector("#last").checked ){
        girls.pop();
     }else{
         girls.shift();
     }
     update(false,false);
}
//reverse array
function reverseF(){
    update(true,false);
}


//sort all
function sortF(){
    update(false, true);
}


//listeners
addBoy.addEventListener("click", addBoyF, false);
addGirl.addEventListener("click", addGirlF, false);
removeBoy.addEventListener("click", removeBoyF,false);
removeGirl.addEventListener("click", removeGirlF,false);
reverse.addEventListener("click",reverseF,false);
sortL.addEventListener("click", sortF,false);