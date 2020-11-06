<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title></title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
	
	<style>
		div#carouselExampleCaptions {width:1200px; height:1080px; margin:auto;}
		form.form-inline{text-align:left;}
    button#login {margin-left : 5px;}
    table#list{width:600px; margin:auto;}
    div#item-list { width:700px; margin:auto;}
    div.card {display:inline-block; width:200px; margin:15px;}
	</style>
</head>
<body>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="test.html">로고 이미지</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      
      <li class="nav-item active">
        <a class="nav-link" href="test2.html">community <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="test5.html"><strong>rent </strong><span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="#">my page(구현할경우) <span class="sr-only">(current)</span></a>

      </li>
      
      
    </ul>

    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">검색</button>
      <a class="login" href="test3.html">
      <button id="login" class="btn btn-outline-success my-2 my-sm-0" type="button">로그인</button>
      </a>
    </form>
  </div> 
</nav>

<br><br><br>

<div id="item-list">
  <h3>렌트</h3>
  <hr>
<div class="card" style="">
  <img src="img/camp-3.png" class="card-img-top" alt="..." width="200px" height="150px">
  <div class="card-body">
    <h5 class="card-title">Card title</h5>
  </div>
  <ul class="list-group list-group-flush">
    <li class="list-group-item">가격</li>
    <li class="list-group-item">닉네임</li>
  </ul>
  
</div>

<div class="card" style="">
  <img src="img/camp-1.png" class="card-img-top" alt="..." width="200px" height="150px">
  <div class="card-body">
    <h5 class="card-title">Card title</h5>
  </div>
  <ul class="list-group list-group-flush">
    <li class="list-group-item">가격</li>
    <li class="list-group-item">닉네임</li>
  </ul>
  
</div>

<div class="card" style="">
  <img src="img/camp-2.png" class="card-img-top" alt="..." width="200px" height="150px">
  <div class="card-body">
    <h5 class="card-title">Card title</h5>
  </div>
  <ul class="list-group list-group-flush">
    <li class="list-group-item">가격</li>
    <li class="list-group-item">닉네임</li>
  </ul>
  
</div>

<div class="card" style="">
  <img src="img/camp-1.png" class="card-img-top" alt="..." width="200px" height="150px">
  <div class="card-body">
    <h5 class="card-title">Card title</h5>
  </div>
  <ul class="list-group list-group-flush">
    <li class="list-group-item">가격</li>
    <li class="list-group-item">닉네임</li>
  </ul>
  
</div>

<div class="card" style="">
  <img src="img/camp-2.png" class="card-img-top" alt="..." width="200px" height="150px">
  <div class="card-body">
    <h5 class="card-title">Card title</h5>
  </div>
  <ul class="list-group list-group-flush">
    <li class="list-group-item">가격</li>
    <li class="list-group-item">닉네임</li>
  </ul>
  
</div>


</div>


</body>
</html>