package it.prova.gestionebigliettiweb.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;
import it.prova.gestionebigliettiweb.model.Biglietto;
import it.prova.gestionebigliettiweb.service.MyServiceFactory;
import it.prova.gestionebigliettiweb.utility.UtilityBigliettoForm;

@WebServlet("/ExecuteUpdateBigliettoServlet")
public class ExecuteUpdateBigliettoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String provenienzaParam = request.getParameter("provenienza");
		String destinazioneParam = request.getParameter("destinazione");
		String prezzoParam = request.getParameter("prezzo");
		String dataParam = request.getParameter("data");
		String idBigliettoParam = request.getParameter("idBiglietto");
		
		Biglietto daAggiornare = UtilityBigliettoForm.createArticoloFromParams(provenienzaParam, destinazioneParam, prezzoParam, dataParam);
		
		if(!NumberUtils.isParsable(idBigliettoParam)) {
			request.setAttribute("errorMessage", "Attenzione, quelcosa è andato storto durante la richiesta; l'id non è valido.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		
		daAggiornare.setId(Long.parseLong(idBigliettoParam));
		
		if(!UtilityBigliettoForm.validateBigliettoBean(daAggiornare)) {
			request.setAttribute("errorMessage", "Attenzione, alcuni campi non sono validi o non sono stati inseriti.");
			request.setAttribute("biglietto_attr", daAggiornare);
			request.getRequestDispatcher("/biglietto/update.jsp").forward(request, response);
			return;
		}
		
		try {
			MyServiceFactory.getBigliettoServiceInstance().aggiorna(daAggiornare);
			request.setAttribute("listaDiBiglietti", MyServiceFactory.getBigliettoServiceInstance().listAll());
			request.setAttribute("successMessage", "Il biglietto è stato aggiornato correttamente.");
			request.getRequestDispatcher("/biglietto/result.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione, si è verificato un problema durante l'aggiornamento.");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
