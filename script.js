let seats = [];

function createSeats(){

for(let i=1;i<=10;i++){

let seat={
id:i,
occupied:false
};

seats.push(seat);
}

displaySeats();
}

function displaySeats(){

const container=document.getElementById("seats");

if(!container) return;

container.innerHTML="";

seats.forEach(seat=>{

let div=document.createElement("div");

div.className="seat";

if(seat.occupied){
div.classList.add("occupied");
}

div.innerText=seat.id;

div.onclick=function(){

seat.occupied=true;
displaySeats();

}

container.appendChild(div);

});
}

function addBook(){

let title=document.getElementById("title").value;

alert("Book Added: "+title);

}

function searchBook(){

let title=document.getElementById("searchTitle").value;

document.getElementById("result").innerText="Searching for: "+title;

}

createSeats();
