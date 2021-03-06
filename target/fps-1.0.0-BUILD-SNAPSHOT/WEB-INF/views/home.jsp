<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="utf-8" language="java"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html lang="tr" >
<head>
<title>Papatya Pide</title>
<meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<style>
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 2;
      border-radius: 2;
    }
    
    /* Add a gray background color and some padding to the footer */
    footer {
	  background-color: #f2f2f2;
      padding: 20px;
    }
    
    .tab {
    float:left;
  -webkit-box-sizing: content-box;
  -moz-box-sizing: content-box;
  box-sizing: content-box;
  margin: 5px;
  padding: 25px;
  border: 1px solid;
  -webkit-border-radius: 5px;
  border-radius: 5px;
  font: normal 16px/2 "Trebuchet MS", Helvetica, sans-serif;
  color: black;
  -o-text-overflow: ellipsis;
  text-overflow: ellipsis;
}
  </style>
<script type="text/javascript">
	$(document).ready(function(){
	    $("#myBtn").click(function(){
	        $("#myModal").modal();
	    });
	    
	    var item;
	    $(".tab").click(function(){
	        item = $(this).attr('id');
	        
	    });
	    
	    $("#item_box").text(item);
	    
	});
	
	
	</script>
</head>

<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="/fps/">Portfolio</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="/fps/">Home</a></li>
        <li><a href="Account">Hesabım</a></li>
        <li><a href="#">İletişim</a></li>
        <sec:authorize access="hasRole('Manager')">
            <li><a href="/fps/manager/">Yönetim</a></li>
        </sec:authorize>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a id="myBtn"><span class="glyphicon glyphicon-log-in"></span> Giriş</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li>
			<a href="#">
			<span class="simpleCart_total"></span> (<span id="simpleCart_quantity" class="simpleCart_quantity"></span> items)
			<i class="glyphicon glyphicon-shopping-cart"></i></a>		
		</li>				 
      </ul>
      
    </div>
  </div>
  
  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-body">
          <form role="form" action="login" method="post" >
		      <div class="form-group">
		      <label for="username">Kullanıcı Adı</label>
		      <input type="text" name="username" id="username" class="form-control" placeholder="Kullanıcı adı girin">
		      </div>
		      <div class="form-group">
		      <label for="password">Şifre</label>
		      <input type="password" name="password" id="password" class="form-control" placeholder="Şifre girin">
		      </div>
		      <button style="width:80px" type="submit" class="btn btn-primary">Giriş</button>
		    </form>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-warning" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
    
  </div>
	
</nav>
  
<div class="container-fluid bg-3">   
<div id="item_box" class="well"></div>
</div>
  
<div style="margin-bottom: 25px" class="container-fluid text-center">    
  <div>
  	<c:forEach var="products" items="${products}" >
	                
	                <div id="${products.id}" class="tab">
	                    <p>${products.name}</p>
	                    <p>${products.price} TL</p>                 
	                </div>
	</c:forEach>
    
       
</div><br>

</div>
</body>

<footer class="container-fluid text-center">
  <p>2015 - Papatya Pide</p>
</footer>


</html>
