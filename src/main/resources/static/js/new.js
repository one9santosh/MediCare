const search=()=>{
    //console.log("searching.....")
    let query=$("#search-input").val()
    console.log(query);

    if(query==''){
        $(".search-result").hide(); 
    }else{
        //search
        console.log(query); 
        //sending request to server
     let url='http://localhost:8080/search/${query}'

     fetch(url)
     .then((response) =>{
return response.json();

     })
     .then((data) =>{
     // data.........
 console.log(data)
 let text='<div class="list-group">'

 data.forEach(medicine => {
    text+='<a href="#" class= "list-group-item list-group-action">${medicine.name}</a>'
    
 });

 text+='</div>'

 $(".search-result").html(text)
 $(".search-result").show(); 
     });

        
    }
}