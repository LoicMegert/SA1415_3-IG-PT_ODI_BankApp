package ch.hearc.ig.odi.bankapp.presentation.bean;

import ch.hearc.ig.odi.bankapp.services.Services;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Cette classe est un Backing Bean lié à la page "createCustomer.xhtml".
 * Elle permet de gérer la création de nouveau client.
 * 
 * @author Loïc Megert <loic.megert@he-arc.ch>
 */
@Named(value = "customerCreateBean")
@RequestScoped
public class CustomerCreateBean implements Serializable {
    
    /** Le numéro du nouveau client. */
    private int id;
    /** Le prénom du nouveau client. */
    private String firstName;
    /** Le nom du nouveau client. */
    private String lastName;
    
    /** Services mises à disposition du programmeur. */
    @Inject
    private Services services;
    
    /**
     * Effectuer l'enregistrement du nouveau client auprès de la banque.
     * 
     * @return "success" pour signaler le succès de l'enregistrement.
     */
    public String submit() {
        services.saveCustomer(id, firstName, lastName);
        
        return "success";
    }

    /**
     * Permet d'obtenir le numéro du nouveau client.
     * 
     * @return Le numéro du nouveau client.
     */
    public int getId() {
        return id;
    }

    /**
     * Modifie le numéro du nouveau client par celui passé en paramètre.
     * 
     * @param id Le nouveau numéro du client.
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * Permet d'obtenir le prénom du nouveau client.
     * 
     * @return Le prénom du nouveau client.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Modifie le prénom du nouveau client par celui passé en paramètre.
     * 
     * @param firstName Le nouveau prénom du client.
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * Permet d'obtenir le nom du nouveau client.
     * 
     * @return Le nom du nouveau client.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Modifie le nom du nouveau client par celui passé en paramètre.
     * 
     * @param lastName Le nouveau nom du client.
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }
    
}
