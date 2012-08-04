<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="data-table">
	<tr>
		<th>name</th>
		<th>type</th>
		<th>action</th>
	</tr>

	<c:forEach items="${ wines }" var="wine">
		<tr>
			<td>
				<a href="/wines/view/${ wine.keyAsString }">
					${ wine.name }
				</a>
			</td>
			<td>${ wine.type }</td>
			<td>
				<a href="/ws/wine/${ wine.keyAsString }.xml">marshall to XML</a>
			</td>
		</tr>
	</c:forEach>
	
</table>
