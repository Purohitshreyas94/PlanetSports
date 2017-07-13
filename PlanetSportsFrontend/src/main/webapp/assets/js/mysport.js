$(function()
{
	//active menu problem
	switch(menu)
	{
	case 'About Us':
		$('#about').addClass('active');
		break;
	
	case 'Sign Up':
		$('#signup').addClass('active');
		break;
		
	case 'Login':
		$('#login').addClass('active');
		break;
	
	case 'Manage Products':
		$('#manageProducts').addClass('active');
		break;
	
	default:
		if(menu == "Home") break;
     	$('#listProduct').addClass('active');
     	$('#a_'+menu).addClass('active');
	    break;
	}

	
	//Code for Data tables for display Products
	
	var $table = $('#productTable');
	
	if($table.length)
		{
		       var jsonUrl = '';
		       if(window.catid == ''){
		    	   jsonUrl = window.contextRoot + '/json/data/all/products';
		       }
		       
		       else{
		    	   jsonUrl = window.contextRoot + '/json/data/category/'+ window.catid +'/products';
		       }
		          
	           $table.DataTable( {
	        	   
	        	   lengthMenu: [[3,5,10,-1], ['3 Records', '5 Records', '10 Records', 'ALL']],
	        	   pageLength: 5,
	        	   ajax:
	        		   {
	        		     url: jsonUrl,
	        		     dataSrc: ''
	        		   },
	        		   columns: [
	        			          {
	        			        	  data: 'prodname'
	        			          },
	        			          
	        			          {
	        			        	  data: 'quantity'
	        			          },
	        			   
	        			          {
	        			        	  data: 'price',
	        			              mRender: function(data, type, row){
	        			            	return '&#8377; ' + data  
	        			                }      
	        			          },
	        			          
	        			          {
	        			        	   data : 'prodid',
	        			        	   bSortable: false,
	        			        	   mRender: function(data, type, row){
	        			        	   var str = '';
	        			        	   str += '<a href="'+window.contextRoot+ '/show/'+data+'/product" class="btn btn-primary"><i class="material-icons">visibility</i></a> &#160;';
	        			        	   str += '<a href="'+window.contextRoot+ '/cart/add/'+data+'/product" class="btn btn-success"><i class="material-icons">shopping_cart</i></a>';
	        			        	   
	        			        	   return str;
	        			        	   
	        			        	   }
	        			          
	        			          }
	        			          
	        		            ]
	        		   
	           });
	        
		}
	
	        //Dismissing Alert after 3 seconds
	
	 var $alert = $('.alert');
     
     if($alert.length) 
      {
    	 setTimeOut(function(){
    		 $alert.fadeOut('slow');
    	 } , 3000)
    	 
      }
     
     
     //--------------------------Data Tables For Admin----------------------//
     
       
     
     

	
	
});