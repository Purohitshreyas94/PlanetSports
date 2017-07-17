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
  <h5 class="text-center">Manage Categories</h5>
  <p><em>Please Add the Category Details Here!</em></p>
  <br>
	
  <div class="row text-center ">
	    <div class="col-md-2 col-sm-0">
		</div>
		<div class="col-md-8 col-sm-12 z-depth-4 pt-30 pb-20">
			<form:form class="col s12" method="post" action="${contextRoot}/manage/category" modelAttribute="category">
				<div class="row">
					<div class="input-field col col-md-12">
					  <form:input path="catid" id="catid" type="hidden"/>
					</div>
					
				</div>
				<div class="row">
					<div class="input-field col col-md-12">
					 <form:input path="catname" id="catname" type="text" class="validate"/>
					  <label for="catname"  class="active">Category Name</label>
					 <form:errors path="catname" cssClass="help-block" element="em"/>
					</div>
				</div>
			  <div class="row">
				<div class="input-field col s12">
				   <form:textarea path="catdesc" id="catdesc" placeholder="Describe Category" class="materialize-textarea"></form:textarea>
				   <form:errors path="catdesc" cssClass="help-block" element="em"/>
				 </div>
			  </div>
			  <div class="row text-center">
				<div class="col-md-3 ">
				</div>
				<div class="input-field col-md-6  text-center">
					<input type="submit" class="btn1" value="Submit">
				
				</div>
				<div class="col-md-3 ">
				</div>
				
			  </div>
			</form:form>	
			
        </div>	
        <div class="col-md-2 col-sm-0">
		</div>		
  </div>
  
            <!-- Table for Category -->
            <div class = "row">
              
              <div class="col-xs-12">
                      <h3>Available Category</h3>
              </div>

                <div class="col-xs-12">
                      <div style ="overflow:auto">
                              
                              <!--  Table for Category Admin  -->  
               	       <table id="adminCategroyTable" class="table table-striped table-bordered">
                          
                      <thead>
			             
			                  <tr>
			                      <th>Category ID</th>
			                      <th>Category Name</th>
			                      <th></th>
			                       
			                  </tr>
			             
			           </thead>
			             
			                   
			              <tfoot>
			             
			                  <tr>
			                       <th>Category ID</th>
			                      <th>Category Name</th>
			                       <th></th>
			                       
			                    
			                  </tr>
			             </tfoot>   
			         
                      </table>
                      
                    </div>
                           
              
              </div>
   
</div>
