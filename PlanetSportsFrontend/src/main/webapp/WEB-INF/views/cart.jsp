<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container">


<table class="table table-striped">
<thead>
<tr><th>Name</th><th>Quantity</th><th>Subtotal</th><th>Remove</th>
</tr>
</thead>
<c:set var="grandTotal" value="0"></c:set>
<c:forEach items="${cart.cartItems}" var="cartItem">
<tr>
<td>${cartItem.product.prodname}</td>
<td>${cartItem.quantity}</td>
<td>${cartItem.totalPrice}</td>
<td><a href="${contextRoot}/cart/removecartitem/${cartItem.cartItemId}" class="btn btn-danger pull-left ">
<c:set var="grandTotal" value="${cartItem.totalPrice + grandTotal}"></c:set>	
<i class="material-icons">remove</i>
</a></td>
<td></td>
</tr>
</c:forEach> 
</table>
<br>
<div class="row">
<div class="col-sm-6">
<a href="${contextRoot}/cart/clearcart/${cart.cartid}" class="btn btn-danger pull-left ">
<i class="material-icons">remove_circle</i></a>
</div>
<div class="col-sm-3">
 <h6><b>Total Price:- ${grandTotal}</b></h6>
</div>

<div class="col-sm-3">
<a href="${contextRoot}/cart/${cart.cartid}/order" class="btn btn-success pull-right ">
Check Out</a>
<input type="hidden" name="cartid"/>
</div>
</div>


</div>