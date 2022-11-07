package it.prova.gestionebigliettiweb.web.servlet.biglietto;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestionebigliettiweb.model.Biglietto;
import it.prova.gestionebigliettiweb.service.MyServiceFactory;
import it.prova.gestionebigliettiweb.utility.UtilityBigliettoForm;

@WebServlet("/admin/ExecuteInsertBigliettoServlet")
public class ExecuteInsertBigliettoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String provenienzaParam = request.getParameter("provenienza");
		String destinazioneParam = request.getParameter("destinazione");
		String prezzoParam = request.getParameter("prezzo");
		String dataParam = request.getParameter("data");
		
		Biglietto daInserire = UtilityBigliettoForm.createArticoloFromParams(provenienzaParam, destinazioneParam, prezzoParam, dataParam);
		
		if(!UtilityBigliettoForm.validateBigliettoBean(daInserire)) {
			request.setAttribute("errorMessage", "Attenzione, alcuni campi non sono validi o non sono stati inseriti.");
			request.setAttribute("biglietto_attr", daInserire);
			request.getRequestDispatcher("/biglietto/insert.jsp").forward(request, response);
			return;
		}
		
		try {
			MyServiceFactory.getBigliettoServiceInstance().inserisciNuovo(daInserire);
			request.setAttribute("listaDiBiglietti", MyServiceFactory.getBigliettoServiceInstance().listAll());
			request.setAttribute("successMessage", "Il biglietto è stato aggiunto con successo");
			request.getRequestDispatcher("/biglietto/result.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione, si è verificato un problema durante l'inserimento.");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
