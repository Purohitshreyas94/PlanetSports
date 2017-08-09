$(function()
{
	//active menu problem
	switch(menu)
	{
	case 'About Us':
		$('#about').addClass('active');
		break;
	
	case 'Contact':
		$('#contact').addClass('active');
		break;
		

	case 'My Account':
		$('#myaccount').addClass('active');
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
	
	case 'Cart':
		$('#cart').addClass('active');
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
	        			        	data: 'code', 
	        			        	mRender: function(data,type,row){
	        			        		
	        			        		return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="dataTableImg"/>';
	        			        	}
	        			          },
	        			          {
	        			        	  data: 'prodname'
	        			          },
	        			          
	        			          {
	        			        	  data: 'quantity',
	        			        	  mRender: function(data,type,row)
	        			        	  {
	        			        		  if(data<1)
	        			        			  {
	        			        			      return '<span style="color:red">Out Of Stock!</span>';
	        			        			  }
	        			        	      return data;
	        			        	  }
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
     
     
     //--------------------------Data Tables For Admin Product----------------------
     
     var $adminProductsTable = $('#adminProductsTable');
 	
 	if($adminProductsTable.length)
 		{
 		       var jsonUrl = window.contextRoot + '/json/data/admin/all/products';
 		       
 		          
 	           $adminProductsTable.DataTable( {
 	        	   
 	        	   lengthMenu: [[10,30,50,-1], ['10 Records', '30 Records', '50 Records', 'ALL']],
 	        	   pageLength: 30,
 	        	   ajax:
 	        		   {
 	        		     url:jsonUrl,
 	        		     dataSrc:''
 	        		   },
 	        		   columns: [
 	        			             {
     			        	              data: 'prodid'
     			                     },
 	        			            {
 	        			        	  data : 'code', 
 	        			        	  bSortable : false,
 	        			        	  mRender : function(data,type,row){
 	        			        		  return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="adminDataTableImg"/>';
 	        			        	 }	  
 	        			           },
 	        			          {
 	        			        	  data: 'prodname'
 	        			          },
 	        			          {
 	        			        	  data: 'quantity',
 	        			        	  mRender : function(data,type,row)
 	        			        	  {
 	        			        		  if(data<1){
 	        			        			  return '<span style="color:red">Out of Stock!</span>';
 	        			        		  }
 	        			        		  return data;
 	        			        	  }
 	        			          },
 	        			          {
 	        			        	  data: 'price',
 	        			              mRender: function(data, type, row){
 	        			            	return '&#8377;' + data  
 	        			                }      
 	        			          }, 
 	        			          {
 	        			        	   data : 'prodid',
 	        			        	   bSortable: false,
 	        			        	   mRender: function(data, type, row){
 	        			        	   var str = '';
 	        			        	  
 	        			        	  str += '<a href="'+window.contextRoot+'/manage/'+data+'/product" class="btn btn-primary btn-xs">';
 	        			        	  str += '<i class="material-icons">mode_edit</i></a>&#160;';
 	        			        	  
 	        			        	 str += '<a href="'+window.contextRoot+'/manage/'+data+'/delete/product" class="btn btn-primary btn-xs ">';
	        			        	 str +='<i class="material-icons">delete</i></a>';
 	        			        	             
 	        			        	   return str;
 	        			        	   
 	        			        	   } 	        			        
 	        			          }
 	        			          
 	        		            ]
 	        		   
 	           });
 	        
 		}
     
     
     
     //--------------------------Data table ends here----------------------

	
 	
 	
 	//------------------------------Data table for Admin for Category----------
 	
var $adminCategroyTable = $('#adminCategroyTable');
 	
 	if($adminCategroyTable.length)
 		{
 		       var jsonUrl = window.contextRoot + '/json/data/admin/all/category';
 		       
 		          
 	           $adminCategroyTable.DataTable( {
 	        	   
 	        	   lengthMenu: [[5,10,20,-1], ['5 Records', '10 Records', '20 Records', 'ALL']],
 	        	   pageLength: 10,
 	        	   ajax:
 	        		   {
 	        		     url:jsonUrl,
 	        		     dataSrc:''
 	        		   },
 	        		   columns: [
 	        			             {
     			        	              data: 'catid'
     			                     },
 	        			           
 	        			          {
 	        			        	  data: 'catname'
 	        			          },
 	        			            
 	        			          {
 	        			        	   data : 'catid',
 	        			        	   bSortable: false,
 	        			        	   mRender: function(data, type, row){
 	        			        	   var str = '';
 	        			        	 
 	        			        	  str += '<a href="'+window.contextRoot+'/manage/'+data+'/category" class="btn btn-primary bt-xs">';
 	        			        	  str += '<i class="material-icons">mode_edit</i></a>';
 	        			        	   
 	        			        	 str += '<a href="'+window.contextRoot+'/manage/'+data+'/delete/category" class="btn btn-primary btn-xs">';
	        			        	   str +='<i class="material-icons">delete</i></a>&#160;';
 	        			        	             
 	        			        	   return str;
 	        			        	   
 	        			        	   } 	        			        
 	        			          }
 	        			          
 	        		            ]
 	        		   
 	           });
 	        
 		}
 	
	//------------------------------------Data table for Category ends here--------------
});