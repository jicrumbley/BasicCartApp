let Username = "";


function checkLogin(){
    document.getElementById("error").innerHTML = "";
    let un = document.getElementById("un").value;
    let pw = document.getElementById("pw").value;

    let url = "http://localhost:8090/login/" + un + "/" + pw;

    let req = new XMLHttpRequest();
    req.responseType = "text";
    req.onreadystatechange = () => {
        if(req.readyState == 4 && req.status == 200){
            if(req.responseText == "true"){
                console.log(un);
                Username = un;
                window.location.href = "../pages/welcome.html";
            }
            else {
                document.getElementById("error").innerHTML = "Error. Username or Password is incorrect. Please try again.";
            }
        }
    }
    req.open("GET", url);
    req.send();

    
}

function getUsername(){
    console.log(Username)
    return Username
}
