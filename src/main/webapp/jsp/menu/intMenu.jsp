<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>


<h1>Welcome <c:out value="${session.user.name} ${session.user.surname}"></c:out></h1>
<ul>
	<li><a href="">Moduli</a></li>
	<li><a href="">Diario</a></li>
</ul>



