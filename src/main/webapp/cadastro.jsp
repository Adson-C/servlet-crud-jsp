<%@page import="br.adsweb.dto.CidaddeDTO"%>
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
	
		location.href = 'main?acao=cadastro&getCidades=true&idEstado=' + idEstado;
	}
	
</script>

</head>
<body onload="init()">

	<jsp:include page="cabecalho.jsp" />

	<h1>Cadastros</h1>

	<div class="main">
		<form action="">
			<fieldset>
				<legend>Cadastro de Pessoas</legend>

				<table cellpadding="5">
					<tr>
						<td style="color: #3842b9;">Nome:</td>
						<td><input type="text" name="nome" style="margin-top: 8px;"></td>
					</tr>
					
					<tr>
						<td style="color: #3842b9;">CPF:</td>
						<td><input type="text" name="cpf" style="margin-top: 8px;"></td>
					</tr>
					<tr>
						<td style="color: #3842b9;">Dat.Nasc:</td>
						<td><input type="text" name="dtnasc" style="margin-top: 8px;"></td>
					</tr>
					<tr>
						<td style="color: #3842b9;">Sexo:</td>
						<td style="color: #2a5572;"><input type="radio" name="sexo" value="M" checked="checked">Masculino
						<input style="color: #2a5572; padding: 2px;" type="radio" name="sexo" value="F">Feminino</td>
					</tr>
					
					<tr>
						<td style="color: #3842b9;">Preferências:</td>
						
						<td style="color: #2a5572;"><input type="checkbox" name="gosto" value="jazz" >Jazz
						<input style="color: #2a5572; padding: 2px;" type="checkbox" name="blues" value="blues">Blues
						<input style="color: #2a5572; padding: 2px;" type="checkbox" name="mpb" value="mpb">MPB
						<input style="color: #2a5572; padding: 2px;" type="checkbox" name="pop" value="pop">Pop
						<input style="color: #2a5572; padding: 2px;" type="checkbox" name="rock" value="rock">Rock
						</td>
					</tr>
					<tr>
						<td style="color: #3842b9;">Cométarios:</td>
						<td>
							<textarea rows="5" cols="30" name="comentarios"></textarea>
						</td>
					</tr>
				</table>
				<fieldset>
					<legend>Endereço:</legend>
					
					<table cellpadding="5">
						<tr>
							<td style="color: #3842b9;">UF:</td>
							<td>
								<select name="uf" id="uf" onchange="popularCidades(this)">
									<option value="0">Selecione...</option>
								<%
								
									List<EstadoDTO> listEstados = (List<EstadoDTO>) session.getAttribute("listEstados");
									for (EstadoDTO estado : listEstados) {
								%>
									<option value="<%=estado.getId_uf() %>">
										<%=estado.getDescricao() %>
									</option>
								<% 
									}
								%>
								</select>
							
							</td>
						</tr>
						<tr>
							<td style="color: #3842b9;">Cidade:</td>
							<td>
								<select name="cidade">
								
								<option>Selecione...</option>
									<%
										List<CidaddeDTO> listaCidades = (List<CidaddeDTO>) request.getAttribute("listaCidades");
										if (listaCidades != null) {
										for (CidaddeDTO cidade : listaCidades) {
											
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
							<td style="color: #3842b9;">Logradouro:</td>
							<td>
								<input type="text" name="lografouro"/>							
							</td>
						</tr>
						
					</table>
				</fieldset>

			</fieldset>
				<input type="submit" value="Cadastrar" style="font-size: large;"/>

		</form>
	</div>

	<jsp:include page="rodape.jsp" />

</body>
</html>