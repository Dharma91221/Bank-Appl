 function validate() 
    {
	 var re = /(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}/;    
	 var pw=document.form1.pw.value;
	
	 
         //document.write(pw);
         if(pw=="" || pw == null){
        	 //document.write(pw);
        	 document.getElementById('passcheck').innerHTML='should not be empty';
        	 return false;
         }
        
        if(!re.test(form1.pw.value)){
        	document.getElementById('passcheck').innerHTML= 'Username must contain only letters, numbers and underscores!';
             
             return false;
        }
         
     	else{
     		
     		return true;
     	}
        fn=fn.substring(0,3);
        ln=ln.substring(0,3);
   	 	email=fn+ln+"@gmail.com";
   	 	document.form1.email.value=email;
           
    }
 function dofocus(){
	 var fn=document.form1.fn.value;
	 var ln=document.form1.ln.value;
	
	 fn=fn.substring(0,3);
     ln=ln.substring(0,3);
	 	email=fn+ln+"@gmail.com";
	 	document.form1.email.value=email;
	 	return false;
 }