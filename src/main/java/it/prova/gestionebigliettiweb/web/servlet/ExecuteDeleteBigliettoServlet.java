package it.prova.gestionebigliettiweb.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestionebigliettiweb.service.MyServiceFactory;

@WebServlet("/ExecuteDeleteBigliettoServlet")
public class ExecuteDeleteBigliettoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idDaEliminareParam = request.getParameter("idBiglietto");
		
		if(!NumberUtils.isParsable(idDaEliminareParam)) {
			request.setAttribute("errorMessage","Attenzione, l'id del biglietto da cancellare non è valido");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}
		
		try {
			MyServiceFactory.getBigliettoServiceInstance().rimuovi(Long.parseLong(idDaEliminareParam));
			request.setAttribute("listaDiBiglietti", MyServiceFactory.getBigliettoServiceInstance().listAll());
			request.setAttribute("successMessage", "La cancellazione è andata a buon fine!");
			request.getRequestDispatcher("/biglietto/result.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage","Attenzione, si è verificato un errore durante la cancellazione");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}
	}

}
