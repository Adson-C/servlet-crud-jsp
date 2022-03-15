<%@page import="br.adsweb.dto.PrefereciaMusicalDTO"%>
<%@page import="br.adsweb.dto.CidadeDTO"%>
<%@page import="br.adsweb.dto.EstadoDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Castrados</title>

   <link rel="stylesheet" href="css/global.css"> 

<script type="text/javascript">

	function init() {
		document.getElementById('uf').value = ${ param.idEstado != null ? param.idEstado : '0'};
	}
	
	function popularCidades(comboEstados) {
		var idEstado = comboEstados.options[comboEstados.selectedIndex].value;
	
		location.href = 'main?acao=montagemCadastro&getCidades=true&idEstado=' + idEstado;
	}
	
</script>

</head>
<body onload="init()">

	<jsp:include page="cabecalho.jsp" />

	<h1>Cadastros</h1>

	<div class="main">
		<form action="main?acao=cadastroPessoa" method="post">
		
		<div class="erroDiv" style="display: ${msgErro != null ? block: 'none' }">
			${msgErro != null ? msgErro: '' }
		</div>
		
			<fieldset>
				<legend>Cadastro de Pessoas</legend>

				<table cellpadding="5">
					<tr>
						<td style="color: #3842b9;">Nome*:</td>
						<td><input type="text" name="nome" style="margin-top: 8px;" 
						maxlength="45" value="${param.nome }"></td>
					</tr>
										
					<tr>
						<td style="color: #3842b9;">CPF*:</td>
						<td><input type="text" name="cpf" style="margin-top: 8px;" 
						maxlength="11" value="${param.cpf }"></td>
					</tr>
					<tr>
						<td style="color: #3842b9;">Dat.Nasc:</td>
						<td><input type="text" name="dtnasc" style="margin-top: 8px;" 
						maxlength="10" value="${param.dtnasc }"></td>
					</tr>
					<tr>
						<td style="color: #3842b9;">Sexo*:</td>
						<td style="color: #2a5572;"><input type="radio" name="sexo" value="M"
						 <%= "M".equals(request.getParameter("sexo")) ? "checked" : "" %>/>Masculino
						<input style="color: #2a5572; padding: 2px;" type="radio" name="sexo" value="F"
						<%= "F".equals(request.getParameter("sexo")) ? "checked" : "" %>/>Feminino</td>
					</tr>
					
					<tr>
						<td style="color: #3842b9;">Preferências:</td>
						
						<td style="color: #2a5572;"> 
						
							<%
								List<PrefereciaMusicalDTO> preferecias = (List<PrefereciaMusicalDTO>) session.getAttribute("listarPreferencias");
								for (PrefereciaMusicalDTO preferecia : preferecias) {
							%>
								<input type="checkbox" name="gostos" 
								value="<%= preferecia.getIdPreferencia() %>" />
								<%= preferecia.getDescricao() %>
							
							<% 
							
								}
							%>
						</td>
					</tr>
					<tr>
						<td style="color: #3842b9;">Cométarios:</td>
						<td>
							<textarea rows="5" cols="30" name="comentarios">${param.comentarios }</textarea>
						</td>
					</tr>
				</table>
				<fieldset>
					<legend>Endereço:</legend>
					
					<table cellpadding="5">
						<tr>
							<td style="color: #3842b9;">UF*:</td>
							<td>
								<select name="uf" id="uf" onchange="popularCidades(this)" 
								style="font-family: Segoe UI; font-size: 12pt; width: 175px">
									<option value="0">Selecione...</option>
								<%
								List<EstadoDTO> listEstados = (List<EstadoDTO>) session.getAttribute("listEstados");
															for (EstadoDTO estado : listEstados) {
								%>
									<option value="<%=estado.getId_uf()%>">
										<%=estado.getDescricao()%>
									</option>
								<%
								}
								%>
								</select>
							
							</td>
						</tr>
						<tr>
							<td style="color: #3842b9;">Cidade*:</td>
							<td>
								<select name="cidade" style="font-family: Segoe UI; font-size: 12pt; width: 280px">
								
								<option value="0">Selecione...</option>
									<%
									List<CidadeDTO> listaCidades = (List<CidadeDTO>) request.getAttribute("listaCidades");
																	if (listaCidades != null) {
																	for (CidadeDTO cidade : listaCidades) {
									%>
										<option value="<%= cidade.getIdCidade() %>">
											<%= cidade.getDescricao() %>
										</option>
									<%
											}
										}
									%>
								</select>
							
							</td>
						</tr>
						<tr>
							<td style="color: #3842b9;">Logradouro*:</td>
							<td>
								<input type="text" name="logradouro" value="${param.logradouro}"/>							
							</td>
						</tr>
						
					</table>
				</fieldset>

			</fieldset>
					<span style="color: black;">* Campos obrigatórios</span>
				<input type="submit" value="Cadastrar" style="width: 200px; 
				font-weight: bold; padding: 5px 10px; font-size: 16pt; margin: 2rem auto 3rem 18rem; color: #164560;"/> 
    
				<input type="reset" value="Limpar" style="width: 200px; 
				font-weight: bold; padding: 5px 10px; font-size: 16pt; color: #853415;"/>

		</form>
	</div>

	<jsp:include page="rodape.jsp" />

</body>
</html>