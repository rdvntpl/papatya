<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Products - Manager - Food Pre-order System</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
 <!-- Bootstrap Core CSS -->
<link href="<c:url value="/resources/manager/css/bootstrap.min.css" />" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="<c:url value="/resources/manager/css/style.css" />" rel='stylesheet' type='text/css' />
<!-- Graph CSS -->
<link href="<c:url value="/resources/manager/css/font-awesome.css" />" rel="stylesheet"> 
<!-- jQuery -->
<!-- lined-icons -->
<link rel="stylesheet" href="<c:url value="/resources/manager/css/icon-font.min.css"/>" type='text/css' />
<!-- //lined-icons -->
<!-- chart -->
<script src="<c:url value="/resources/manager/js/Chart.js"/>" ></script>
<!-- //chart -->
<!--animate-->
<link href="<c:url value="/resources/manager/css/animate.css" />" rel="stylesheet" type="text/css" media="all">
<script src="<c:url value="/resources/manager/js/wow.min.js" />" ></script>
	<script>
		 new WOW().init();
	</script>
<!--//end-animate-->
<!----webfonts--->
<link href='http://fonts.googleapis.com/css?family=Cabin:400,400italic,500,500italic,600,600italic,700,700italic' rel='stylesheet' type='text/css'>
<!---//webfonts---> 
 <!-- Meters graphs -->
<script src="<c:url value="/resources/manager/js/jquery-1.10.2.min.js"/>" ></script>
<!-- Placed js at the end of the document so the pages load faster -->
<script type="text/javascript">
$(document).ready(function(){
    $("#myBtn").click(function(){
    	$("#button").text("Ekle");
    	$("#header").text("Yeni Ürün");
    	

	   	 $("#name").val("");
	   	 $("#price").val("");
	   	 
        $("#myModal").modal();
    });
    
    var item;
    $(".btn-warning").click(function(){
    	 $("#button").text("Güncelle");
    	 $("#header").text("Ürün Güncelleme");
    	 
    	 item = $(this).parent().parent().attr('id');
    	 $("#name").val($("#"+item+" #p_name").text());
    	 $("#price").val($("#"+item+" #p_price").text().split(" ")[0]);
    	 
    	 $("#myModal").modal();
    });

    $("#button").click(function() {
		if($(this).text()=="Güncelle"){
			//alert($("#name").val()+" "+$("#price").val());
			
			$.ajax({ 
			    url: "/fps/manager/products/add/", 
			    type: 'POST', 
			    dataType: 'json', 
			    data: "{\"id\": 1,\"name\":\"hmkcode\",\"price\":2}",
			    contentType: 'application/json',
			    mimeType: 'application/json',
			    success: function(data) { 
			        alert(data.id + " " + data.name);
			    },
			    error:function(data,status,er) { 
			        alert("error: "+data+" status: "+status+" er:"+er);
			    }
			});
		}else if($(this).text()=="Ekle"){
			alert($("#name").val()+" "+$("#price").val());
		}
	});
    
});

</script>
</head> 
   
 <body class="sticky-header left-side-collapsed"  onload="initMap()">
    <section>
    <!-- left side start-->
		<div class="left-side sticky-left-side">

			<!--logo and iconic logo start-->
			<div class="logo">
				<h1><a href="/">Papatya Yönetim</a></h1>
			</div>
			<div class="logo-icon text-center">
				<a href="${pageContext.request.contextPath}/manager/"><i class="lnr lnr-home"></i> </a>
			</div>

			<!--logo and iconic logo end-->
			<div class="left-side-inner">

				<!--sidebar nav start-->
					<ul class="nav nav-pills nav-stacked custom-nav">
						<li class="active"><a href="${pageContext.request.contextPath}/manager/"><i class="lnr lnr-power-switch"></i><span>Anasayfa</span></a></li>
						<li><a href="${context}"><i class="lnr lnr-menu"></i> <span>Ürünler</span></a></li>              
						<li><a href="${pageContext.request.contextPath}/manager/users/"><i class="lnr lnr-menu"></i> <span>Üyeler</span></a></li>  
					</ul>
				<!--sidebar nav end-->
			</div>
		</div>
		<!-- left side end-->
    
		<!-- main content start-->
		<div class="main-content">
			<!-- header-starts -->
			<div class="header-section">
			 
			<!--toggle button start-->
			<a class="toggle-btn  menu-collapsed"><i class="fa fa-bars"></i></a>
			<!--toggle button end-->

			<!--notification menu start -->
			<div class="menu-right">
				<div class="user-panel-top">  	
					<div class="profile_details_left">
						<ul class="nofitications-dropdown">
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-bell"></i><span class="badge blue">3</span></a>
									<ul class="dropdown-menu">
										<li>
											<div class="notification_header">
												<h3>You have 3 new notification</h3>
											</div>
										</li>
										<li><a href="#">
											<div class="user_img"><img src="images/1.png" alt=""></div>
										   <div class="notification_desc">
											<p>Lorem ipsum dolor sit amet</p>
											<p><span>1 hour ago</span></p>
											</div>
										  <div class="clearfix"></div>	
										 </a></li>
										 <li class="odd"><a href="#">
											<div class="user_img"><img src="images/1.png" alt=""></div>
										   <div class="notification_desc">
											<p>Lorem ipsum dolor sit amet </p>
											<p><span>1 hour ago</span></p>
											</div>
										   <div class="clearfix"></div>	
										 </a></li>
										 <li><a href="#">
											<div class="user_img"><img src="images/1.png" alt=""></div>
										   <div class="notification_desc">
											<p>Lorem ipsum dolor sit amet </p>
											<p><span>1 hour ago</span></p>
											</div>
										   <div class="clearfix"></div>	
										 </a></li>
										 <li>
											<div class="notification_bottom">
												<a href="#">Hepsini aç...</a>
											</div> 
										</li>
									</ul>
							</li>	
							<li><button id="myBtn" class="btn-info btn">Yeni Ürün</button></li>
							<div class="clearfix"></div>	
						</ul>
					</div>
					<div class="profile_details">		
						<ul>
							<li class="dropdown profile_details_drop">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
									<div class="profile_img">	
										 <div class="user-name">
											<p>Michael<span>Administrator</span></p>
										 </div>
										 <i class="lnr lnr-chevron-down"></i>
										 <i class="lnr lnr-chevron-up"></i>
										<div class="clearfix"></div>	
									</div>	
								</a>
								<ul class="dropdown-menu drp-mnu">
									<li> <a href="#"><i class="fa fa-cog"></i> Settings</a> </li> 
									<li> <a href="#"><i class="fa fa-user"></i>Profile</a> </li> 
									<li> <a href="sign-up.html"><i class="fa fa-sign-out"></i> Logout</a> </li>
								</ul>
							</li>
							<div class="clearfix"> </div>
						</ul>
					</div>		
					<div class="clearfix"></div>
				</div>
			  </div>
			<!--notification menu end -->
			</div>
			
		<!-- Modal -->
	  <div class="modal fade" id="myModal" role="dialog">
	    <div class="modal-dialog">
	    
	      <!-- Modal content-->
	      <div class="modal-content">
	      	<div class="modal-header">
	      	<h3 id="header" style="text-align: center;" class="modal-title">Yeni Ürün</h3>
	      	</div>
	        <div class="modal-body">
	          <form role="form" action="login" method="post" >
			      <div class="form-group">
			      <label for="username">Ad</label>
			      <input type="text" name="name" id="name" class="form-control" placeholder="Ürün adı giriniz">
			      </div>
			      <div class="form-group">
			      <label for="password">Fiyat</label>
			      <input type="text" name="price" id="price" class="form-control" placeholder="Ürünün fiyatını giriniz">
			      </div>
			      
			    </form>
	        </div>
	        <div class="modal-footer">
	          <button id="button" style="float: left;width: 100px" type="submit" class="btn btn-primary">Ekle</button>
	          <button type="button" style="float: left;width: 100px" class="btn btn-danger" data-dismiss="modal">Close</button>
	        </div>
	      </div>
	      
	    </div>
    
  </div>
			
		<!-- //header-ends -->
		<div id="page-wrapper">
		<div class="graphs">
					<h3 class="blank1">Ürünler</h3>

					 <div class="xs tabls">
						<div class="bs-example4" data-example-id="simple-responsive-table">
						<table class="table table-bordered">
						  <thead>
							<tr>
							  <th>Ad</th>
							  <th>Fiyat</th>
							  <th>Düzenle</th>
							  <th>Kaldır</th>
							</tr>
						  </thead>
						  <tbody>
							<c:forEach var="products" items="${products}" >
			                <tr class="pro" id="${products.id}"  >
			                    <td id="p_name">${products.name}</td>
			                    <td id="p_price">${products.price} TL</td>  
			                    <td><button id="myBtn1" class="btn-warning btn">Düzenle</button></td>
			                	<td><button class="btn-danger btn">Kaldır</button></td>               
			                </tr>
							</c:forEach>
						  </tbody>
						</table>
					   </div>
					   </div>
				</div>
		</div>
			<!--body wrapper end-->
		</div>
        <!--footer section start-->
			<footer>
			   <p>&copy 2015 FPS Manager Panel. All Rights Reserved.</a></p>
			</footer>
        <!--footer section end-->

      <!-- main content end-->
   </section>
  
<script src="<c:url value="/resources/manager/js/jquery.nicescroll.js" />" ></script>
<script src="<c:url value="/resources/manager/js/scripts.js" />" ></script>
<!-- Bootstrap Core JavaScript -->
   <script src="<c:url value="/resources/manager/js/bootstrap.min.js" />" ></script>
</body>
</html>