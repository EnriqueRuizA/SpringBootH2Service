<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous"/>
</head>
<body>
	<div class = "container mt-4">
		<table class = "table">
			<thead>
				<tr>
					<th>
						Producto
					</th>
					<th>
						Cadena
					</th>
					<th>
						Tarifa
					</th>
					<th>
						Fecha de aplicación
					</th>
					<th>
						Precio
					</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var ="precio" items="#{listaPrecios}">
					<tr>
						<th>
							${precio.getProductId()}
						</th>
						<th>
							${precio.getBrandId()}
						</th>
						<th>
							${precio.getPriceList()}	
						</th>
						<th>
							${precio.startDate}
							-
							${precio.endDate}
						</th>
						<th>
							${precio.price}
						</th>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>