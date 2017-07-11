<div class="container">

   <div class="row">
   
     <div class="col-xs-12">
       
       <ol class="breadcrumb">
          <li><a href="${contextRoot}/home">Home</a></li>
           <li><a href="${contextRoot}/show/all/products">Products</a></li>
           <li class="active">${product.prodname}</li>
       
       </ol>
     
     </div>
   
   
   </div>


   <div class="row">
       
       <!-- Display the Product Image -->
       <div class="col-md-6">
          <div class="thumbnail">
              <img src=".jpg" class="img-responsive border">
          
          </div>
          
       
       </div>
       
       <!-- Product Description -->
       
       <div class="col-md-6">
          
          <h2 style="font-size:20px;">${product.prodname}</h2>
          <hr/>
          <p>${product.proddesc}</p>
          <hr/>
          
          <h4 style="font-size:20px;">Price: <strong> &#8377; ${product.price} /-</strong></h4>
          <hr/>
          
          <h6 style="font-size:20px;">Quantity Available: ${product.quantity}</h6>
 
           
           <a class="btn" href="${contextRoot}/cart/add/${product.prodid}/product">
           <span class="glyphicon glyphicon-shopping-cart"></span>Add To Cart</a>
           
           
           <a class="btn" href="${contextRoot}/show/all/products">
           Back</a>
 
       </div>
   
   
   
   </div>

</div>