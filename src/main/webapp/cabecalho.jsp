
<div class="cabecalho">

	<div class="logo">
	<a href="index.jsp">
	
		<img alt="Logo Adson" src="img/logoads.png" style="width: 30%; padding: 10px">
	
	</a>
	
	</div>
	<ul>

		<li><a href="main?acao=index" class="cli" style="color: black; font-weight: bold; "${param.index eq 'index' ? 'cli' : '' }>Home</a></li>
		<li><a href="main?acao=montagemCadastro" class="cli1" style="color: black; font-weight: bold; "${param.cadastro eq 'cadastro' ? 'cli1' : '' }>Casdastro</a></li>
		<li><a href="main?acao=consultas" class="cli2" style="color: black; font-weight: bold; "${param.consultas eq 'consultas' ? 'cl2' : '' }>Consultas</a></li>
		<li><a href="main?acao=logout" class="cli3" style="color: black; font-weight: bold; "${param.logout eq 'logout' ? 'cl3' : '' }>Sair</a></li>

	</ul>
	<div class="boasVindas" style="float: right; clear: both; font-style: italic;">
		Bem-vindo(a) <b>${sessionScope.usuario.usuario }</b>!
	</div>

</div>