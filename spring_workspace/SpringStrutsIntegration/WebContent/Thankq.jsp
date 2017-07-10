<%@ page import="edu.aspire.CustomerFormBean"%>
<html>
<body>
<%
	CustomerFormBean custForm = (CustomerFormBean) session
			.getAttribute("customerForm");
	out.println("<h1> Thank you Mr." + custForm.getFirstName() + " "
			+ custForm.getLastName());
%>
</body>
</html>