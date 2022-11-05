<%@page import="java.text.SimpleDateFormat"%>
<%@page import="it.prova.gestionebigliettiweb.model.Biglietto"%>
<%@page import="java.util.List"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!doctype html>
<html lang="it" class="h-100" >
	 <head>
	 
	 	<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />
	   
	   <title>Dettaglio Biglietto</title>
	 </head>
	 
	<body class="d-flex flex-column h-100">
	 
		<!-- Fixed navbar -->
		<jsp:include page="../navbar.jsp"></jsp:include>
	 
	
		<!-- Begin page content -->
		<main class="flex-shrink-0">
		  <div class="container">
		  
		  		<div class="alert alert-success alert-dismissible fade show  ${successMessage==null?'d-none':'' }" role="alert">
				  ${successMessage}
				  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
				</div>
				<div class="alert alert-danger alert-dismissible fade show d-none" role="alert">
				  Esempio di operazione fallita!
				  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
				</div>
				<div class="alert alert-info alert-dismissible fade show d-none" role="alert">
				  Aggiungere d-none nelle class per non far apparire
				   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
				</div>
		  
		  
		  
		  		<div class='card'>
				    <div class='card-header'>
				        <h5>Ecco il dettaglio del biglietto selezionato</h5> 
				    </div>
				    <div class='card-body'>
				    
				        <% Biglietto bigliettoInPagina = (Biglietto)request.getAttribute("bigliettoDaVisualizzare_attr"); %>
				   		
				   		<dl class="row">
							<dt class="col-sm-3 text-right">Provenienza</dt>
							<dd class="col-sm-9"><%=bigliettoInPagina.getProvenienza() %></dd>
					    </dl>
					    
					    <dl class="row">
							<dt class="col-sm-3 text-right">Destinazione</dt>
							<dd class="col-sm-9"><%=bigliettoInPagina.getDestinazione() %></dd>
					    </dl>
					    
					    <dl class="row">
							<dt class="col-sm-3 text-right">Prezzo</dt>
							<dd class="col-sm-9"><%=bigliettoInPagina.getPrezzo() %></dd>
					    </dl>
					    
					    <dl class="row">
							<dt class="col-sm-3 text-right">Data Partenza</dt>
							<dd class="col-sm-9"><%=bigliettoInPagina.getData() %></dd>
					    </dl>
					 			   
			    	</div>
			    
			    	<div class='card-footer'>
					    <a href="ListBigliettiServlet" class='btn btn-outline-secondary' style='width:80px'>
					    	<i class='fa fa-chevron-left'></i> Back
						</a>
					</div>
			<!-- end card -->
			</div>	
		 
		   
		 <!-- end container -->  
		  </div>
		  
		</main>
		
		<!-- Footer -->
		<jsp:include page="../footer.jsp" />
		
		<!-- Modal conferma delete -->
		<div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="deleteModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="deleteModalLabel">Conferma Operazione</h5>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		        Continuare con l'operazione?
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Annulla</button>
		        <button type="button" class="btn btn-primary">Continua</button>
		      </div>
		    </div>
		  </div>
		</div>
		<!-- End Modal conferma delete -->
		
	</body>
</html>