<!DOCTYPE html> 
<html lang="en"> 
  
<head> 
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <link rel="stylesheet" href="style/home-style.css">
    <title>Home</title>
</head>
<body>
    <nav class="navbar navbar-dark bg-dark" style="margin-left: 20px;">
        <a class="navbar-brand" href="#">
          <img src="${pageContext.request.contextPath}/Images/shares2.jpg" width="30" height="30" class="d-inline-block align-top" alt="">
          Portfolio Application</a>
        <form action="/logout" method="GET"><button type="button float-right" class="btn btn-outline-light">Logout</button></form>
      </nav>
    <br>
    <div class="container">
        <div class="row">
            <div class="col-sm-6">
                <div class="card text-center">
                    <img class="card-img-top img-fluid" src="${pageContext.request.contextPath}/Images/shares1.jpg" style="width:600x;height:300px;" alt="Card image cap">
                    <div class="card-block">
                        <h4 class="card-title">Calculate Networth</h4>
                        <p class="card-text">Click to view your Networth</p>
                        <form action="/viewNetworth" method="GET"><button type="submit" value="submit" class="btn btn-outline-primary">Calculate Networth</button></form>
                        <p></p>
                    </div>
                </div>
            </div>
            <div class="col-sm-6">
                <div class="card text-center">
                    <img class="card-img-top img-fluid" src="${pageContext.request.contextPath}/Images/shares9.jpg" style="width:600x;height:300px;" alt="Card image cap">
                    <div class="card-block">
                        <h4 class="card-title">Sell Assets </h4>
                        <p class="card-text">Click to sell Asset</p>
                        <form action="/sellAssets" method="GET"><button type="submit" name="submit" class="btn btn-outline-success">Sell Asset</button></form>
                        <p></p>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body> 
</html> 

