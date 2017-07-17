<div class="container">

	<div class="row">



		<!-- to display the Actual Products -->
		<div class="col-md-12">
			<div class="row">


				<!-- Added Breadcrumb Component -->
				<div-class="col-lg-12"> 
				
				<c:if test="${userClickProducts == true}">
				    
				    <script>
				       window.catid = '';
				    </script>

					<ol class="breadcrumb">

						<li><a href="${contextRoot}/home">Home</a></li>
						<li class="active">All Products</a></li>


					</ol>
				</c:if>
				
					
				<c:if test="${userClickCategoryProducts == true}">
				    
				     <script>
				              window.catid = '${category.catid}';
				    </script>

					<ol class="breadcrumb">

						<li><a href="${contextRoot}/home">Home</a></li>
						<li class="active">Category</a></li>
						<li class="active">${category.catname}</a></li>


					</ol>
				</c:if>
			</div>
			
			<div class="row">
			
			  <div class="row">
			      
			      <div class="col-xs-12">
			         
			         <table id="productTable" class="table table-striped table-borders">
			             <thead>
			             
			                  <tr>
			                      <th></th>
			                      <th>Product Name</th>
			                     <th>Product Quantity</th>
			                     <th>Product Price</th>
			                     <th></th>
			                  </tr>
			                  
			                  
			              
			             </thead>
			               
			              <tfoot>
			             
			                  <tr>
			                       <th></th>
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

	</div>


</div>