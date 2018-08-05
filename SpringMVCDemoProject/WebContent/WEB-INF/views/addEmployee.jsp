<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   
<!DOCTYPE html>    
<html>
<script type="text/javascript"
    src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	
	/**$("#formSubmit").click(function(){ 
		console.log("test")
		
		
	});  */
	
	$( "#formSubmit" ).click(function() {
		  alert( "Handler for .click() called." );
		  var formObject=$("#employeeModel").serializeArray();
		  var formObject1=$("#employeeModel").serialize();
		  var json1 = JSON.stringify(formObject);
		  var formElemt={"name":"sasa","age":55,"salary":100000,"address":"asdsadsdsd"};
		  var json2 = JSON.stringify(formElemt);
		 console.log(json1);
		 console.log(json2)
		 
		 $.ajax({
			    type: "POST",
			    contentType : 'application/json',
			    url: "/SpringMVCDemoProject/saveWithAjax.html",
			    data:formElemt,
			    dataType: 'json',
			    success: function (data) {
			        alert('success');
			    },
			    error: function (e) {
			        
			    }
			});
	});
});


    function crunchifyAjax() {
        $.ajax({
            url : 'ajaxtest.html',
            success : function(data) {
                $('#result').html(data);
            }
        });
    }
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form id="employeeModel" action="/SpringMVCDemoProject/save.html" method="POST">
 <table>
       <tr>
           <td>Employee ID:</td>
           
           <td><input name="id" value="" readonly="readonly"/></td>
       </tr>
       <tr>
           <td>Employee Name:</td>
           <td><input name="name" value=""/></td>
       </tr>
       <tr>
           <td>Employee Age:</td>
           <td><input name="age" value=""/></td>
       </tr>
       <tr>
           <td>Employee Salary:</td>
           <td><input name="salary" value=""/></td>
       </tr>
       
       <tr>
           <td>Employee Address:</td>
           <td><input name="address" value=""/></td>
       </tr>
          <tr>
         <td colspan="2"><input type="button" id="formSubmit" value="Submit"/></td>
        </tr>
   </table> 

</form>

<div>


</div>

</body>
</html>