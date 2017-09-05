window.onload=function(){
   var oBtn1=document.getElementById("obtn1");
   var oBtn2=document.getElementById("obtn2");
	var full1=document.getElementById("full");
	oBtn2.onclick=function(){
		var one=document.getElementsByClassName("form-control")[0].value;
		var two=document.getElementsByClassName("form-control")[1].value;
		var three=document.getElementsByClassName("form-control")[2].value;
		var code=document.getElementsByClassName("form-control")[3].value;
        document.getElementById("one").value=one;
        document.getElementById("two").value=two;
        document.getElementById("three").value=three;
         document.getElementById("code").value=code;
		full1.style.display="block";

	}
	oBtn1.onclick=function(){
		full1.style.display="none";
	}

}
	
