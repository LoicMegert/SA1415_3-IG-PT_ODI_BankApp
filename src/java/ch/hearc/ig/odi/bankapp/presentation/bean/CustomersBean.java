package ch.hearc.ig.odi.bankapp.presentation.bean;

import ch.hearc.ig.odi.bankapp.business.Customer;
import ch.hearc.ig.odi.bankapp.services.Services;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Cette classe est un Backing Bean lié à la page "customersList.xhtml".
 * Elle permet de gérer les clients enregistrés auprès d'une banque.
 * 
 * @author Loïc Megert <loic.megert@he-arc.ch>
 */
@Named(value = "customersBean")
@RequestScoped
public class CustomersBean implements Serializable {
    
    /** La liste des clients enregistrés auprès d'une banque. */
    private DataModel<Customer> customers;
    
    /** Services mises à disposition du programmeur. */
    @Inject
    private Services services;
    
    /**
     * Permet d'obtenir la liste des clients enregistrés auprès d'une banque.
     * 
     * @return La liste des clients enregistrés auprès d'une banque.
     */
    public DataModel<Customer> getCustomers() {
        customers = new ListDataModel<>();
        customers.setWrappedData(services.getCustomersList());
        return customers;
    }
}
