<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
  	<img id="logo" src="<%=request.getContextPath()%>/css/codoacodo.png" alt="Logo de Codo A Codo" width="70" height="40"> 
    <a class="navbar-brand" href="<%=request.getContextPath()%>">Codo a Codo</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" href="<%=request.getContextPath()%>/alta.jsp">Alta</a>       
        </li>
        <li class="nav-item">
          <a class="nav-link" href="<%=request.getContextPath()%>/api/ListadoController">Listado</a>
        </li>
      </ul>

      <form class="d-flex"
      	action="<%=request.getContextPath()%>/api/BuscarController" 
      	method="get">
        <input name="clave" class="form-control me-sm-2" type="text" placeholder="Buscar">
        <button class="btn btn-secondary my-2 my-sm-0" type="submit">Buscar</button>
      </form>
    </div>
  </div>
</nav>