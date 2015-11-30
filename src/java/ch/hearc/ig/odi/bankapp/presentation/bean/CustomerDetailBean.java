package ch.hearc.ig.odi.bankapp.presentation.bean;

import ch.hearc.ig.odi.bankapp.business.Account;
import ch.hearc.ig.odi.bankapp.business.Customer;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Named;

/**
 * Cette classe est un Backing Bean lié à la page "customerDetail.xhtml".
 * Elle permet de gérer le client à détailler.
 * 
 * @author Loïc Megert <loic.megert@he-arc.ch>
 */
@Named("CustomerDetailBean")
@SessionScoped
public class CustomerDetailBean implements Serializable {
    
    /** Le client à détailler. */
    private Customer customer;
    /** La listes des comptes possédés par le client. */
    private DataModel<Account> accounts;
    
    /** 
     * Reçoit le client à détailler.
     * 
     * @param customer  Le client à détailler.
     * @return "success" si le client a été reçu, sinon retourne "failure".
     */
    public String getCustomer(final Customer customer) {
        this.customer = customer;
        
        if(customer != null) {
            return "success";
        } else {
            return "failure";
        }
    }
    
    /**
     * Permet d'obtenir la liste des comptes du client.
     * 
     * @return La liste des comptes du client.
     */
    public DataModel<Account> getAccounts() {
        accounts = new ListDataModel<>();
        
        accounts.setWrappedData(customer.getAccounts());
        
        return accounts;
    }

    /**
     * Permet d'obtenir le client à détailler.
     * 
     * @return Le client à détailler.
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Modifie le client à détailler par celui passé en paramètre.
     * 
     * @param customer Le nouveau client à détailler.
     */
    public void setCustomer(final Customer customer) {
        this.customer = customer;
    }
    
}
