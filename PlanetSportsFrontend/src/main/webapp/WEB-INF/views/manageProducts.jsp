<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div id="band" class="container text-center mt-50">
      
   <c:if test="${not empty message}">
     <div class="col-xs-12">
           
            <div class="alert alert-success alert-dismissible">
                   <button type="button" class="close" data-dismiss="alert">&times;</button>  
                   ${message}    
           </div>
      
      </div>
   </c:if>         
  <h5 class="text-center">Manage Products</h5>
  <p><em>Please Add the Product Details Here!</em></p>
  <br>
	
  <div class="row text-center z-depth-4">
	    <div class="col-md-12 pt-30 pb-20">
			<form:form method="POST" class="col s112" action="${contextRoot}/manage/products" modelAttribute="product" enctype="multipart/form-data">
				<div class="row">
					<div class="input-field col col-md-12">
					  <form:input path="prodid" id="prodid" type="hidden"/>
					</div>
					
				</div>
					
				<div class="row">
					<div class="input-field col col-md-12">
					  <form:input path="prodname" id="prodname" type="text" class="validate"/>
					  <label for="prodname"  class="active">Product Name</label>
					  <form:errors path="prodname" cssClass="help-block" element="em"/>
					</div>
				</div>
				
				<div class="row">
					<div class="input-field col col-md-6">
					  <form:input path="price" id="price" type="number" class="validate"/> 
					  <label for="price"  class="active">Price</label>
					   <form:errors path="price" cssClass="help-block" element="em"/>
					</div>
					<div class="input-field col col-md-6">
					  <form:input id="quantity" path="quantity" type="number" class="validate"/>
					  <label for="quantity" class="active">Quantity</label>
					</div>
				</div>
				
				
				<div class="row">
					<div class="input-field col s6 ">
							
						       <label for="catid" class="active">--Select Category:--</label>
							<form:select id="catid" path="catid" class="input-field inline mt-0" 
	                           
							             items="${category}"
							             itemLabel="catname"
							             itemValue="catid"
														
						        />
					</div>
				</div>
				
				
			  <div class="row">
				<div class="input-field col s12">
				 <form:textarea path="proddesc" id="proddesc" placeholder="Product Description"  class="materialize-textarea"></form:textarea>
				 <form:errors path="proddesc" cssClass="help-block" element="em"/>          
				</div>
			  </div>
			  
			  
	        		  
			  <div class="row">
					<div class="input-field col col-md-6 inline">
					<label for="file" class="active">Select an Image..</label>
					  <form:input name="file" path="file" id="file" type="file" />
					   <form:errors path="file" cssClass="help-block" element="em"/>
					 
					</div>
				</div>
			  
			
			  
			  <div class="row text-center">
				<div class="col-md-3 ">
				</div>
				<div class="input-field col-md-6  text-center">
					<input type="submit" class="btn1" value="Submit">
					<!-- Hidden Fields -->
					 <form:hidden path="suppid"/>
					 <form:hidden path="code"/>
				</div>
				<div class="col-md-3 ">
				</div>
				
			  </div>
			</form:form>
			
        </div>	
       		
  </div>
  
                    
               <!-- Datatable for Admin -->
               <div class = "row">
              
              <div class="col-xs-12">
                      <h3>Available Products</h3>
              </div>

                <div class="col-xs-12">
                      <div style ="overflow:auto">
                              
                              <!--  Table for Admin  -->  
               	       <table id="adminProductsTable" class="table table-striped table-bordered">
                          
                      <thead>
			             
			                  <tr>
			                      <th>Product ID</th>
			                      <th>&#160;</th>
			                      <th>Product Name</th>
			                     <th>Product Quantity</th>
			                     <th>Product Price</th>
			                      <th></th>
			                       
			                  </tr>
			             
			           </thead>
			             
			                   
			              <tfoot>
			             
			                  <tr>
			                      <th>Product ID </th>
			                      <th>&#160;</th>
			                      <th>Product Name</th>
			                      <th>Product Quantity</th>
			                      <th>Product Price</th>
			                       <th></th>
			                       
			                    
			                  </tr>
			             </tfoot>   
			         
                      </table>
                      
                    </div>
                           
              
              </div>
                          
     </div>
 
</div>
