package dev.sgp.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditerCollaborateurControlleur extends HttpServlet {

	private static final long serialVersionUID = -5496324344535557458L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String matricule=req.getParameter("matricule");
		String titre=req.getParameter("titre");
		String nom=req.getParameter("nom");
		String prenom=req.getParameter("prenom");

		if(matricule==null||titre==null||nom==null||prenom==null){
			String errorReponse = "Les élèments suivant sont manquants : ";
			if(matricule==null){
				errorReponse += "un matricule, ";
			}
			if(titre==null){
				errorReponse += "un titre, ";
			}
			if(nom==null){
				errorReponse += "un nom, ";
			}
			if(prenom==null){
				errorReponse += "un prenom, ";
			}
			resp.sendError(400, errorReponse);
		}else{
			resp.setContentType("text/html");
			// code HTML ecrit dans le corps de la reponse
			resp.setStatus(201);
			resp.getWriter().write("<h1>Creation d’un collaborateur avec les informations suivantes :</h1>"
					+ "<ul>"
					+ "<li>matricule="+ matricule + "</li>"
					+ "<li>titre="+ titre + "</li>"
					+ "<li>nom="+ nom + "</li>"
					+ "<li>prenom="+ prenom + "</li>"
					+ "</ul>");
		}
	}
}
