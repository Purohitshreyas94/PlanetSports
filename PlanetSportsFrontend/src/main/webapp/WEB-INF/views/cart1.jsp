<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container">
  
          <table id="cart" class="table table-hover table-condensed">
    				<thead>
						<tr>
							<th style="width:50%">Product</th>
							<th style="width:10%">Price</th>
							<th style="width:8%">Quantity</th>
							<th style="width:22%" class="text-center">Subtotal</th>
							<th style="width:10%"></th>
						</tr>
					</thead>
					<tbody>
					     <c:set var="grandTotal" value="0"></c:set>
                        <c:forEach items="${cart.cartItems}" var="cartItem">
						<tr>
							<td data-th="Product">
								<div class="row">
									<div class="col-sm-2 hidden-xs"> <img src="${images}/${cartItem.product.code}.jpg" alt="..."  class="img-responsive border"/></div>
									<div class="col-sm-10">
										<h6><b>${cartItem.product.prodname}</b></h6>
										<p>${cartItem.product.proddesc}</p>
									</div>
								</div>
							</td>
							<td data-th="Price">&#8377; ${cartItem.product.price} /-</td>
							<td data-th="Quantity">${cartItem.quantity}</td>
							<td data-th="Subtotal" class="text-center">${cartItem.totalPrice}</td>
							 <td><a href="${contextRoot}/cart/removecartitem/${cartItem.cartItemId}" class="btn btn-danger pull-left ">
                             <c:set var="grandTotal" value="${cartItem.totalPrice + grandTotal}"></c:set>	
                             <i class="material-icons">remove</i></a></td>
						</tr>
					</c:forEach>
					</tbody>
					
					<tfoot>
						  <tr class="visible-xs">
							<td class="text-center"><strong>Total:- ${grandTotal}</strong></td>
						</tr>
						<tr>
						    <td><a href="${contextRoot}/show/all/products" class="btn btn-warning">Continue Shopping</a></td>
							<td colspan="2" class="hidden-xs"></td>
							<td class="hidden-xs text-center"><h6 style="font-size:20px;"><strong><b>Total:- ${grandTotal}</b></strong></h6></td>
							<td><a href="${contextRoot}/cart/${cart.cartid}/order" class="btn btn-success btn-block">Checkout</a></td>
						</tr>
					</tfoot>
				</table>

    
</div>