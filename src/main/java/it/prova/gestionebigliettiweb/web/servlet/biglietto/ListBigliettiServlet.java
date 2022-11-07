package it.prova.gestionebigliettiweb.web.servlet.biglietto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestionebigliettiweb.model.Biglietto;
import it.prova.gestionebigliettiweb.service.MyServiceFactory;

@WebServlet("/ListBigliettiServlet")
public class ListBigliettiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Biglietto> result = new ArrayList<>();

		try {

			result = MyServiceFactory.getBigliettoServiceInstance().listAll();

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage",
					"Attenzione, errore durante la consultazione del DB, nessun caricamento effettuato.");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}
		request.setAttribute("listaDiBiglietti", result);
		request.getRequestDispatcher("/biglietto/result.jsp").forward(request, response);
	}

}
