package ch.hearc.ig.odi.bankapp.presentation.bean;

import ch.hearc.ig.odi.bankapp.business.Account;
import ch.hearc.ig.odi.bankapp.business.Customer;
import ch.hearc.ig.odi.bankapp.services.Services;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Cette classe est un Backing Bean lié à la page "createAccount.xhtml".
 * Elle permet de gérer la création de compte.
 *
 * @author Loïc Megert <loic.megert@he-arc.ch>
 */
@Named(value = "accountCreateBean")
@SessionScoped
public class AccountCreateBean implements Serializable {
    
    /** Le numéro du compte. */
    private String number;
    /** Le nom du compte. */
    private String name;
    /** Le solde du compte. */
    private double balance;
    /** Le taux d'intérêt du compte. */
    private double rate;
    /** Le client propriétaire du nouveau compte. */
    private Customer customer;
    
    /** Services mises à disposition du programmeur. */
    @Inject
    private Services services;
    
    /**
     * Effectuer l'ouverture du nouveau compte auprès de la banque.
     * 
     * @return "success" si le compte a pu être ouvert, sinon retourne "failure".
     */
    public String submit() {
        Account account = services.saveAccount(number, name, rate, customer);
        
        if(account != null) {
            account.setBalance(balance);
            return "success";
        } else {
            return "failure";
        }
    }
    
    /**
     * Reçoit le futur propriétaire du nouveau compte.
     * 
     * @param customer Le futur propriétaire du compte.
     * @return "success" si le client a été reçu, sinon retourne "failure".
     */
    public String getCustomer(final Customer customer) {
        if(customer != null) {
            this.customer = customer;
            return "success";
        } else {
            return "failure";
        }
    }

    /**
     * Permet d'obtenir le numéro du nouveau compte.
     * 
     * @return Le numéro du compte.
     */
    public String getNumber() {
        return number;
    }

    /**
     * Modifie le numéro du compte par celui passé en paramètre.
     * 
     * @param number Le nouveau numéro du compte.
     */
    public void setNumber(final String number) {
        this.number = number;
    }

    /**
     * Permet d'obtenir le nom du nouveau compte.
     * 
     * @return Le nom du compte.
     */
    public String getName() {
        return name;
    }

    /**
     * Modifie le nom du compte par celui passé en paramètre.
     * 
     * @param name Le nouveau nom du compte.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Permet d'obtenir le solde du nouveau compte.
     * 
     * @return Le solde du compte.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Modifie le solde du compte par celui passé en paramètre.
     * 
     * @param balance Le nouveau solde du compte.
     */
    public void setBalance(final double balance) {
        this.balance = balance;
    }

    /**
     * Permet d'obtenir le taux d'intérêt du nouveau compte.
     * 
     * @return Le taux d'intérêt du compte.
     */
    public double getRate() {
        return rate;
    }

    /**
     * Modifie le taux d'intérêt du compte par celui passé en paramètre.
     * 
     * @param rate Le nouveau taux d'intérêt du compte.
     */
    public void setRate(final double rate) {
        this.rate = rate;
    }

    /**
     * Permet d'obtenir le futur propriétaire du nouveau compte.
     * 
     * @return Le futur propriétaire du nouveau compte.
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Modifie le propriétaire du nouveau compte par celui passé en paramètre.
     * 
     * @param customer Le nouveau propriétaire du compte.
     */
    public void setCustomer(final Customer customer) {
        this.customer = customer;
    }
    
}
