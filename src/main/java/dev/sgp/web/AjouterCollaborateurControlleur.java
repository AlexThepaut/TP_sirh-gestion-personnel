package dev.sgp.web;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZonedDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;
import dev.sgp.util.Constantes;

public class AjouterCollaborateurControlleur extends HttpServlet {

	private static final long serialVersionUID = 4775538020842020128L;
	// recuperation du service
	private CollaborateurService collabService = Constantes.COLLAB_SERVICE;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// utilisation du service
		req.getRequestDispatcher("/WEB-INF/views/collab/ajouterCollaborateur.jsp").forward(req, resp);	
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String nom = req.getParameter("inputNom");
		String prenom = req.getParameter("inputPrenom");
		LocalDate dateNaissance = null;
		if(!req.getParameter("inputDateNaissance").equals("")){
			dateNaissance = LocalDate.parse(req.getParameter("inputDateNaissance"));			
		}
		String adresse = req.getParameter("inputAdresse");
		String numSecu = req.getParameter("inputNumSecu");

		String errMessage = "";
		//test de validité sur les données envoyées
        if(numSecu.length() != 15){
            errMessage += " Le numéro de sécurité sociale n'est pas valide "+numSecu;
        }
        if(!checkForm(prenom)){
            errMessage += " Le prénom n'est pas valide "+prenom;
        }
        if(!checkForm(nom)){
            errMessage += " Le nom n'est pas valide "+nom;
        }       
        if(!checkForm(adresse)){
            errMessage += " L'adresse n'est pas valide "+adresse;
        }
        if(dateNaissance == null){
            errMessage += " La date de naissance n'est pas renseignée "+adresse;
        }
        
        if(errMessage.length() > 0){
            resp.sendError(400, errMessage);
        }else{
            
            //génération des données manquantes
        	String emailPro = prenom + "." + nom + "@societe.com";
    		String photo = "/sgp/profile-default.png";
    		ZonedDateTime dateHeureCreation = ZonedDateTime.now();
            
    		collabService.sauvegarderCollaborateur(new Collaborateur(nom, prenom, dateNaissance, adresse, numSecu, emailPro, photo, dateHeureCreation));			
			resp.sendRedirect("/sgp/collaborateurs/lister");
        }   
	}

	private boolean checkForm (String data){
		boolean result = true;
		if(data.matches(".*[/+<>@].*")){
			result = false;
		}
		return result;
	}
}
