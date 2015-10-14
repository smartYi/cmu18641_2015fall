<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.ArrayList, model.Automobile, model.Optionset"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Result</title>
</head>
<body>
This is your customized car:<p>
<% Automobile automobile = (Automobile) request.getAttribute("automobile"); %>
	<table border="1px" width="200px">
		<tr>
			<td><%= automobile.getMake() + automobile.getModel() %></td>
			<td>Base price</td>
			<td>$<%=automobile.getBasePrice() %></td>
		</tr>
		<% for(Optionset optionset : automobile.getOptionSets()) {%>
		<tr>
			<td><%=optionset.getName() %></td>
			<td><%=automobile.getOptionChoice(optionset.getName()) %></td>
			<td><%=automobile.getOptionChoicePrice(optionset.getName()) %></td>
		</tr>
		<%} %>
		<tr>
			<td>Total cost</td>
			<td></td>
			<td><%=automobile.getTotalPrice() %></td>
		</tr>
	</table>
</body>
</html>