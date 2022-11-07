<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="it" class="h-100" >
	 <head>
	 
	 	<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />
	   
	   <title>Aggiorna Biglietto</title>
	 </head>
	   <body class="d-flex flex-column h-100">
	   
	   		<!-- Fixed navbar -->
	   		<jsp:include page="../navbar.jsp"></jsp:include>
	    
			
			<!-- Begin page content -->
			<main class="flex-shrink-0">
			  <div class="container">
			  
			  		<div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none':'' }" role="alert">
					  ${errorMessage}
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
				        <h5>Aggiorna il tuo biglietto</h5> 
				    </div>
				    <div class='card-body'>
		
							<h6 class="card-title">I campi con <span class="text-danger">*</span> sono obbligatori</h6>
		
		
							<form method="post" action="ExecuteUpdateBigliettoServlet" class="row g-3" novalidate="novalidate">

								<div class="col-md-6">
									<label for="codice" class="form-label">Provenienza<span class="text-danger">*</span></label>
									<input type="text" name="provenienza" id="provenienza" class="form-control" placeholder="Inserire la provenienza"  
										value="${biglietto_attr.provenienza==null?'':biglietto_attr.provenienza}" required>
								</div>
								
								<div class="col-md-6">
									<label for="codice" class="form-label">Destinazione<span class="text-danger">*</span></label>
									<input type="text" name="destinazione" id="destinazione" class="form-control" placeholder="Inserire la destinazione"  
										value="${biglietto_attr.destinazione==null?'':biglietto_attr.destinazione}" required>
								</div>
								
								<div class="col-md-6">
									<label for="codice" class="form-label">Prezzo<span class="text-danger">*</span></label>
									<input type="number" name="prezzo" id="prezzo" class="form-control" placeholder="Inserire il prezzo"  
										value="${biglietto_attr.prezzo==null?'':biglietto_attr.prezzo}" required>
								</div>
												
												
								<div class="col-md-3">
									<label for="dataNascita" class="form-label">Data Partenza<span class="text-danger">*</span></label>
									<input class="form-control"  name="data" id="data" type="date" placeholder="dd/MM/yy" title="formato : gg/mm/aaaa" 
										value="<fmt:formatDate value="${biglietto_attr.data}" pattern = "yyyy-MM-dd"/>" required/>
								</div>
								
								
							<div class="col-12">
								<input type="hidden" name = "idBiglietto" value = "${biglietto_attr.id}">
								<button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">Conferma</button>
							</div>
							<a href="ListBigliettiServlet" class='btn btn-outline-secondary' style='width:80px'>
					    		<i class='fa fa-chevron-left'></i> Back
							</a>
						</form>
					<!-- end card-body -->			   
				    </div>
				<!-- end card -->
				</div>		
					  
			    
			  <!-- end container -->  
			  </div>
			  
			</main>
			
			<!-- Footer -->
			<jsp:include page="../footer.jsp" />
	  </body>
</html>