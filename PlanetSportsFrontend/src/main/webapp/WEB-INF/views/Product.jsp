<%@ page language="java" contentType="text/html"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" 
  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<%@include file="Header.jsp"%>

<h2>
	<center>Manage Product</center>
</h2>

   <c:if test="${flag}">
		<form action="${pageContext.request.contextPath}/UpdateProduct"
			method="post">${pageContext.request.contextPath}</form>
	</c:if>
	<form:form action="AddProduct" modelAttribute="product" method="post"
		enctype="multipart/form-data">

		<table align="center">
			<tr>
				<td colspan="2">
				Product Id</td>
				<td><c:if test="${!flag}">
					<form:input path="proid" /></td>
				</c:if>
				<c:if test="${flag}">
					<td><form:hidden path="proid" value="${product.proid}" />
				</c:if>
				</td>
			</tr> 
			<tr>
				<td>Product Name</td>
				<c:if test="${flag}">
					<td><form:input path="proname" value="${product.proname }" /></td>
				</c:if>
				<c:if test="${!flag}">
					<td><form:input path="proname" /></td>
				</c:if>
			</tr>

			<tr>
				<td>Category</td>
				<td><c:if test="${!flag}">
						<form:select path="catid">
							<form:option value="0" label="------Select Categories----" />
							<form:options items="${catlist}" />
						</form:select>
					</c:if> <c:if test="${flag}">
						<form:select path="catid" value="${product.catid}" />
					</c:if></td>
				</td>
			</tr>
			<tr>

				<td>Supplier</td>
				<td><c:if test="${!flag}">
			<form:select path="supid">
						<form:option value="0" label="------Select Suppliers----" />
						<form:options items="${suplist}" />
					</form:select> </c:if> <c:if test="${flag }">
						<form:select path="supid" value="${product.supid }" />
					</c:if></td>
					</tr>
			<tr>
				<td>Price</td>
				<td><c:if test="${!flag}">
						<form:input path="price" value="${product.price}" />
					</c:if> <c:if test="${flag}">
						<form:input path="price" value="${product.price}" />
					</c:if></td>
			</tr>
			<tr>
				<td>Stock</td>
				<td><c:if test="${!flag}">
						<form:input path="quantity" value="${product.quantity}" />
					</c:if> <c:if test="${flag}">
						<form:input path="quantity" value="${product.quantity}" />
					</c:if></td>
			</tr>
			<tr>
				<td>Product Desc</td>
				<td><c:if test="${!flag}">
						<form:textarea path="prodesc" value="${product.prodesc}" />
					</c:if> <c:if test="${flag}">
						<form:input path="proddesc" value="${product.proddesc}" />
					</c:if></td>
			</tr>

			<tr>
				<td>Product Image</td>
				<td><c:if test="${!flag}">
						<form:input type="file" path="pimg" />
					</c:if><c:if test="${flag}">
						<form:input type="file" path="pimg" value="${product.pimg}" />
			</c:if>
			</td>
				
		
			</tr>

		<tr>
			<td colspan="2"><input type="submit" /></td>
		</tr>
	</table>
	</form:form>

	<!-- Displaying the Product data using Table -->

<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="table-responsive">
			     <h3>Available Products</h3>
			     </div>
			     
			     <div class="col-md-12">
			         <div style="overflow:auto">
                  </div>
                  
                  
				<table id="productTable" class="table table-bordered">

					<thead>
						<tr>
							<th>Product ID</th>
							<th>&#160;</th>
							<th>Product Name</th>
							<th>Quantity</th>
							<th>Price</th>
							<th>Edit</th>
							<th>Delete</th>
 	                     </tr>
	
                     </thead>
                              
                        <tbody>
                             <tr>
                                  <td></td>
                                  <td></td>
                                  <td></td>
                                  <td></td>
                                  <td></td>
                                  <td></td>
                                  <td></td>       
                            </tr>
                        </tbody>
                             
                     <tfoot>
						<tr>
							<th>Product ID</th>
							<th>&#160;</th>
							<th>Product Name</th>
							<th>Quantity</th>
							<th>Price</th>
							<th>Edit</th>
							<th>Delete</th>
 	                     </tr>
	
                     </tfoot>
                     
                 
                 </table>
<!-- Completed Displaying Table -->

</body>
</html>
