    //This method checks for the special characters in text fields.
    
	function validateData(txt_str)
	{
		var index=0;
		var infoArray = new Array();

		var txt_string = new String(txt_str);    	

		for(i=0; i<txt_string.length; i++)
	   	{
	   		characterCode = txt_string.charAt(i);
			
			//alert(characterCode);

			if((characterCode >='0' && characterCode <='9' ) || (characterCode >='A' && characterCode <='Z') )
    			result = true;
    		else
    		{
				result = false;
    			infoArray[index]=new Array(2);
				infoArray[index][0]="[MSG_50]&nbsp;&nbsp;";
				infoArray[index][1]=[MSG_50];
				index++;    			
    			break;
    		}
    	}

		infoArray[index]="infoArray";
	    if (index>0)
	    {
			window.showModalDialog("messagepopup.jsp",infoArray,"dialogHeight:200px;dialogWidth:400px;resizable:yes;");
	        return false;
	    }
		else
			return true;
	}
