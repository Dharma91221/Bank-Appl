function check(){
	 var letters = /^[A-Za-z]+$/;
	 var re = /(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}/;  
	 var name=document.form1.name.value;
	 var pw=document.form1.pass.value;
     if(!name.match(letters))
     {
    	 
    	 document.getElementById('nameCheck').innerHTML='should be only alphabets ';
    	 
    	 return false;
     }
     if(pw=="" || pw == null){
    	 //document.write(pw);
	 document.getElementById('passCheck').innerHTML='should not be empty';
     return false;
     }
    
     if(!re.test(form1.pw.value)){
    	document.getElementById('passCheck').innerHTML= 'Username must contain only letters, numbers and underscores!';
         
         return false;
     }
     
     else{
 		
    	 return true;
     }
}