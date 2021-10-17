<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="es" xml:lang="es">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous"/>
</head>
<body>
	<div class = "container mt-4">
		<table class = "table">
			<caption>Lista de precios</caption>
			<thead>
				<tr>
					<th id="Producto">
						Producto
					</th>
					<th id="Cadena">
						Cadena
					</th>
					<th id="Tarifa">
						Tarifa
					</th>
					<th id="Fecha de aplicación">
						Fecha de aplicación
					</th>
					<th id="Precio">
						Precio
					</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var ="precio" items="#{listaPrecios}">
					<tr>
						<th id="ProductId">
							${precio.getProductId()}
						</th>
						<th id="BrandId">
							${precio.getBrandId()}
						</th>
						<th id="PriceList">
							${precio.getPriceList()}	
						</th>
						<th id="StartEndDate">
							${precio.getStartDate()}
							-
							${precio.getEndDate()}
						</th>
						<th id="Price">
							${precio.getPrice()}
						</th>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>