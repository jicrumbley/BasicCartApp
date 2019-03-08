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

function getLoggedInUser(){
    let user = "";
    let url = "http://localhost:8090/login/getUser";

    let req = new XMLHttpRequest();
    req.responseType = "text";
    req.onreadystatechange = () => {
        if(req.readyState == 4 && req.status == 200){
            if(req.responseText == "false"){
                window.location.href = "../pages/index.html";
            }
            else
            {
                console.log(req.responseText)
                user = req.responseText;
                document.getElementById("welcome").innerHTML = "Welcome, " + user +"!"               
            }
        }
    }
    req.open("GET", url);
    req.send();
    
}

function logout(){
    console.log("Logout clicked");
    let url = "http://localhost:8090/login/logout";
    let req = new XMLHttpRequest();
    req.responseType = "text";
    req.onreadystatechange = () => {
        if(req.readyState == 4 && req.status == 200){
            if(req.responseText == "true"){
                window.location.href = "../pages/index.html";
            }
        }
    }

    req.open("POST", url);
    req.send();

}