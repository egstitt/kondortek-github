<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="data-table">
	<tr>
		<th>name</th>
		<th>action</th>
	</tr>
	<c:forEach items="${ wineries }" var="winery">
		<tr>
			<td>
				<a href="/wineries/view/${ winery.keyAsString }">
					${ winery.name }
				</a>
			</td>
			<td>
				<a href="/ws/winery/${ winery.keyAsString }.xml">marshall to XML</a>
			</td>
		</tr>
	</c:forEach>
	
</table>
