package ch.hearc.ig.odi.bankapp.business;

import java.util.*;

/**
 * Classe permettant la gestion de clients.
 * 
 * @author Loïc Megert <loic.megert@he-arc.ch>
 */
public class Customer {

    /** La liste des comptes possédés par ce client. */
    private Map<String, Account> accounts;
    /** Le numéro du client. */
    private int number;
    /** Le prénom du client. */
    private String firstName;
    /** Le nom du client. */
    private String lastName;

    /**
     * Permet d'obtenir le numéro du client.
     * 
     * @return Le numéro du client.
     */
    public int getNumber() {
        return this.number;
    }

    /**
     * Modifie le numéro du client par celui passé en paramètre.
     * 
     * @param number Le nouveau numéro du client.
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * Permet d'obtenir le prénom du client.
     * 
     * @return Le prénom du client.
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Modifie le prénom du client par celui passé en paramètre.
     * 
     * @param firstName Le nouveau prénom du client.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Permet d'obtenir le nom du client.
     * 
     * @return Le nom du client.
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Modifie le nom du client par celui passé en paramètre.
     * 
     * @param lastName Le nouveau nom du client.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.number);
        sb.append(";");
        sb.append(this.firstName);
        sb.append(";");
        sb.append(this.lastName);
        sb.append(";");
        sb.append(this.accounts.toString());
        return sb.toString();
    }
    
    /**
     * Constructeur paramétré pour les clients.
     *
     * @param number Le numéro du client.
     * @param firstName Le prénom du client.
     * @param lastName Le nom du client.
     */
    public Customer(final Integer number, final String firstName, final String lastName) {
        this.number = number;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accounts = new HashMap<>();
    }

    /**
     * Retourne le compte possédant le numéro passé en paramètre.
     *
     * @param number Le numéro du compte désiré.
     * @return Le compte recherché ou null s'il n'existe pas.
     */
    public Account getAccountByNumber(final String number) {
        return this.accounts.get(number);
    }

    /**
     * Envoie la liste des comptes possédés par ce client.
     * 
     * @return La liste des comptes possédés par ce client.
     */
    public List<Account> getAccounts() {
        return new ArrayList<>(this.accounts.values());
    }
    
    /**
     * Ajoute un compte à la liste des comptes du client.
     *
     * @param number Le numéro du compte.
     * @param name Le nom du compte.
     * @param rate Le taux d'intérêt du compte.
     * @return Le compte créé ou null s'il existe déjà.
     */
    public Account addAccount(final String number, final String name, final double rate) {
        if(!accounts.containsKey(number)) {
            Account account = new Account(number, name, rate, this);
            this.accounts.put(number, account);
            
            return account;
        } else {
            return null;
        }
    }

}
