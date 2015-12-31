/**
 * 
 */
	 $(document).ready(function (){
    	loadp(1)
    	 
    	$('.delete').click(function(){
    	if(confirm("您确定要删除吗")){
    		window.location.href=$(this).attr('hs')
    		
    	}
    	})
    	
    	
    	$('.page').click(function(){
    		var va= $(this).attr('ps')
    		$('.active').removeClass('active')
    		$(this).attr('class','active')
    		loadp(va)
    	})
    	
    	
    	
    	$('.pagelast').click(function(){
    		
    		var va=$('.active').attr('ps')
    		var vi=parseInt(va)
    		//alert(vi)
    		if(vi>1){
	    		$('.active').removeClass('active')
	    		va= vi-1
	    		
	    		$('#'+va).attr('class','active')
	    		loadp(va)
    		}
    		
    	})
    	
    	
    	$('.pagenext').click(function(){
    		var total=$('nav').attr('total')
    		var totali=parseInt(total)
    		//alert(totali)
    		var va=$('.active').attr('ps')
    		var vi=parseInt(va)
    		if(vi<totali){
    		$('.active').removeClass('active')
    		//alert(va)
    		va= vi+1
    		//alert(va)
    		$('#'+va).attr('class','active')
    		loadp(va)
    		}
    	})
    	
    })//readyend;

    function loadp(p){
    		$('tbody tr').each(function(){
    		var cc = $(this).attr('class');
    		if(cc==p)
    		{
    			$(this).show();
    		}
    		else{
    			$(this).hide();
    		}
    	});
    }
   	
    
   
    
    	
