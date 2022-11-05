package it.prova.gestionebigliettiweb.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestionebigliettiweb.service.MyServiceFactory;

@WebServlet("/PrepareDeleteBigliettoServlet")
public class PrepareDeleteBigliettoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idBigliettoParam = request.getParameter("idBiglietto");
		
		if (!NumberUtils.isParsable(idBigliettoParam)) {
			request.setAttribute("errorMessage", "Attenzione, quelcosa è andato storto,id non valido.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		try {
			request.setAttribute("bigliettoDaVisualizzare_attr",
					MyServiceFactory.getBigliettoServiceInstance().findById(Long.parseLong(idBigliettoParam)));
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione, quelcosa è andato, non sono riuscito a caricare il biglietto.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		
		request.getRequestDispatcher("/biglietto/delete.jsp").forward(request, response);
	}

}
