<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
<div class="row">
<a href="${contextRoot}/cart/clearcart/${cart.cartid}" class="btn btn-danger pull-left ">
<i class="material-icons">remove_circle</i>Clear Cart
</a>
<a href="${contextRoot}/cart/order/${cart.cartid}" class="btn btn-success pull-right ">
<i class="material-icons">check</i>Check Out</a>
<table class="table table-striped">
<thead>
<tr><th>Name</th><th>Quantity</th><th>Total Price</th><th>Remove</th>
</tr>
</thead>
<c:set var="grandTotal" value="0"></c:set>
<c:forEach items="${cart.cartItems}" var="cartItem">
<tr>
<td>${cartItem.product.prodname}</td>
<td>${cartItem.quantity}</td>
<td>${cartItem.totalPrice}</td>
<td><a href="${contextRoot}/cart/removecartitem/${cartItem.cartItemId}" class="btn btn-danger btn-xs pull-left ">
<c:set var="grandTotal" value="${cartItem.totalPrice + grandTotal}"></c:set>	
<i class="material-icons">remove</i>Remove
</a></td>
<td></td>
</tr>
</c:forEach> 
</table>
Total Price:${grandTotal}

</div>
</div>