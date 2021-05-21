package fr.eni.groupe4.encheres.bll;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import fr.eni.groupe4.encheres.bo.Utilisateur;

public final class FormulaireInscription {
	private static final String CHAMP_PSEUDO = "pseudo";
	private static final String CHAMP_NOM = "nom";
	private static final String CHAMP_PRENOM = "prenom";
	private static final String CHAMP_EMAIL  = "email";
	private static final String CHAMP_TELEPHONE = "telephone";
	private static final String CHAMP_RUE = "rue";
	private static final String CHAMP_CPO = "codePostal";
	private static final String CHAMP_VILLE = "ville";
    private static final String CHAMP_MDP   = "motDePasse";
    private static final String CHAMP_CONF   = "confirmation";
    
    private String              resultat;
    private Map<String, String> erreurs      = new HashMap<String, String>();

    /* On rend les getters & setters dispos pour inscription.jsp */
    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }
    
    public Utilisateur inscrireUtilisateur( HttpServletRequest request ) {
    	String pseudo = getValeurChamp( request, CHAMP_PSEUDO );
    	String nom = getValeurChamp( request, CHAMP_NOM );
    	String prenom = getValeurChamp( request, CHAMP_PRENOM );
    	String email = getValeurChamp( request, CHAMP_EMAIL );
    	String telephone = getValeurChamp( request, CHAMP_TELEPHONE );
    	String rue = getValeurChamp( request, CHAMP_RUE );
        String codePostal = getValeurChamp( request, CHAMP_CPO );
        String ville = getValeurChamp( request, CHAMP_VILLE );
        String motDePasse = getValeurChamp( request, CHAMP_MDP );
        String confirmation = getValeurChamp( request, CHAMP_CONF );

        Utilisateur utilisateur = new Utilisateur();

        try {
            validationPseudo( pseudo );
        } catch ( Exception e ) {
            setErreur( CHAMP_PSEUDO, e.getMessage() );
        }
        utilisateur.setPseudo( pseudo );
        
        try {
            validationNom( nom );
        } catch ( Exception e ) {
            setErreur( CHAMP_NOM, e.getMessage() );
        }
        utilisateur.setNom( nom );
        
        try {
            validationPrenom( prenom );
        } catch ( Exception e ) {
            setErreur( CHAMP_PRENOM, e.getMessage() );
        }
        utilisateur.setPrenom( prenom );
        
        try {
            validationEmail( email );
        } catch ( Exception e ) {
            setErreur( CHAMP_EMAIL, e.getMessage() );
        }
        utilisateur.setEmail( email );
        
        try {
            validationTelephone( telephone );
        } catch ( Exception e ) {
            setErreur( CHAMP_TELEPHONE, e.getMessage() );
        }
        
        utilisateur.setTelephone( telephone );
        
        try {
            validationRue( rue );
        } catch ( Exception e ) {
            setErreur( CHAMP_RUE, e.getMessage() );
        }
        utilisateur.setRue( rue );
        
        try {
            validationCodePostal( codePostal );
        } catch ( Exception e ) {
            setErreur( CHAMP_CPO, e.getMessage() );
        }
        utilisateur.setCodePostal( codePostal );
        
        try {
            validationVille( ville );
        } catch ( Exception e ) {
            setErreur( CHAMP_VILLE, e.getMessage() );
        }
        utilisateur.setVille( ville );

        try {
            validationMotsDePasse( motDePasse, confirmation );
        } catch ( Exception e ) {
            setErreur( CHAMP_MDP, e.getMessage() );
            setErreur( CHAMP_CONF, null );
        }
        utilisateur.setMotDePasse( motDePasse );

        if ( erreurs.isEmpty() ) {
            resultat = "Inscription effectuée avec succès !";
        } else {
            resultat = "Échec de l'inscription.";
        }

        return utilisateur;
    }
    private void validationEmail( String email ) throws Exception {
        if ( email != null ) {
            if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
                throw new Exception( "Veuillez renseigner une adresse mail valide." );
            }
        } else {
            throw new Exception( "Veuillez renseigner une adresse mail." );
        }
    }

    /* Conditions d'erreur pour chacun des champs du formulaire d'inscription */
    
    private void validationPseudo( String pseudo ) throws Exception {
        if ( pseudo != null && pseudo.length() < 3 ) {
            throw new Exception( "Le pseudo doit contenir au moins 3 caractères." );
        }
    }

    private void validationNom( String nom ) throws Exception {
        if ( nom == null ) {
            throw new Exception( "Veuillez renseigner un nom." );
        }
    }

    private void validationPrenom( String prenom ) throws Exception {
        if ( prenom == null ) {
            throw new Exception( "Veuillez renseigner un prénom." );
        }
    }
    
    private void validationTelephone( String telephone ) throws Exception {
        if ( telephone != null && telephone.length() < 10 ) {
            throw new Exception( "Veuillez renseigner un numéro de téléphone valide." );
        }
    }
    
    private void validationRue( String rue ) throws Exception {
        if ( rue == null ) {
            throw new Exception( "Veuillez renseigner une adresse." );
        }
    }
    
    private void validationCodePostal( String codePostal ) throws Exception {
        if ( codePostal == null ) {
            throw new Exception( "Veuillez renseigner le code postal." );
        }
    }
    
    private void validationVille( String ville ) throws Exception {
        if ( ville == null ) {
            throw new Exception( "Veuillez renseigner la ville." );
        }
    }
    
    private void validationMotsDePasse( String motDePasse, String confirmation ) throws Exception {
        if ( motDePasse != null && confirmation != null ) {
            if ( !motDePasse.equals( confirmation ) ) {
                throw new Exception( "Les mots de passe entrés sont différents, merci de les saisir à nouveau." );
            } else if ( motDePasse.length() < 3 ) {
                throw new Exception( "Les mots de passe doivent contenir au moins 3 caractères." );
            }
        } else {
            throw new Exception( "Merci de saisir et confirmer votre mot de passe." );
        }
    }
    
     /* Ajoute un message correspondant au champ spécifié à la map des erreurs. */
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

    /* Méthode utilitaire qui retourne null si un champ est vide, et son contenu sinon. */
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur.trim();
        }
    }
}
