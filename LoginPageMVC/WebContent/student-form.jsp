<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action = "processForm" modelAttribute = "student">
<!-- 	First Name :<form:input type ="text" path ="firstName"/> -->
<!-- 	<br><br> -->
<!-- 	Last Name :<form:input path ="lastName"/> -->
	First Name :<input type = "text" name= "firstName">
	<br><br>
	Last Name :<input type ="text" name= "lastName">
	<br><br>
	Country :<select name="country">
  		<option value="India">India</option>
  		<option value="Japan">Japan</option>
  		<option value="America">America</option>
  		<option value="England">England</option>
	</select>	
	<br>
	<br>
	Gender:
	<input type="radio" name="gender" value="male"> Male
	<input type="radio" name="gender" value="female"> Female<br>
<input type = "Submit" value = "Submit"/>
</form>

</body>
</html>