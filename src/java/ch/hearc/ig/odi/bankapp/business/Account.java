package ch.hearc.ig.odi.bankapp.business;

/**
 * Classe permettant la gestion de comptes.
 * 
 * @author Loïc Megert <loic.megert@he-arc.ch>
 */
public class Account {

    /** Le propriétaire du compte. */
    private Customer customer;
    /** Le numéro du compte. */
    private String number;
    /** Le nom du compte. */
    private String name;
    /** Le solde du compte. Par défaut : 0 */
    private double balance = 0;
    /** Le taux d'intérêt du compte. Par défaut : 0.001 */
    private double rate = 0.001;

    /**
     * Permet d'obtenir le numéro du compte.
     * 
     * @return Le numéro du compte.
     */
    public String getNumber() {
        return this.number;
    }

    /**
     * Modifie le numéro du compte par celui passé en paramètre.
     * 
     * @param number Le nouveau numéro du compte.
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * Permet d'obtenir le nom du compte.
     * 
     * @return Le nom du compte.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Modifie le nom du compte par celui passé en paramètre.
     * 
     * @param name Le nouveau nom du compte.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Permet d'obtenir le solde du compte.
     * 
     * @return Le solde du compte.
     */
    public double getBalance() {
        return this.balance;
    }

    /**
     * Modifie le solde du compte par celui passé en paramètre.
     * 
     * @param balance Le nouveau solde du compte.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Permet d'obtenir le taux d'intérêt du compte.
     * 
     * @return Le taux d'intérêt du compte.
     */
    public double getRate() {
        return this.rate;
    }

    /**
     * Modifie le taux d'intérêt du compte par celui passé en paramètre.
     * 
     * @param rate Le nouveau taux d'intérêt du compte.
     */
    public void setRate(double rate) {
        this.rate = rate;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.customer.getFirstName());
        sb.append(" ");
        sb.append(this.customer.getLastName());
        sb.append(";");
        sb.append(this.number);
        sb.append(";");
        sb.append(this.name);
        sb.append(";");
        sb.append(this.balance);
        sb.append(";");
        sb.append(this.rate);
        return sb.toString();
    }

    /**
     * Constructeur paramétré pour les comptes.
     *
     * @param number Le numéro du compte.
     * @param name Le nom du compte.
     * @param rate Le taux d'intérêt du compte.
     * @param customer Le propriétaire du compte.
     */
    public Account(final String number, final String name, final double rate, final Customer customer) {
        this.number = number;
        this.name = name;
        this.rate = rate;
        this.customer = customer;
    }

    /**
     * Crédite le montant désiré sur le compte.
     *
     * @param amount Le montant à créditer.
     */
    public void credit(final double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Impossible de créditer un montant négatif ou null !");
        }
        this.balance += amount;
    }

    /**
     * Débite le montant désiré sur le compte.
     *
     * @param amount Le montant à débiter.
     */
    public void debit(final double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Impossible de débiter un montant négatif ou null !");
        }
        if (this.balance < amount) {
            throw new IllegalStateException("Solde insuffisant ! Débit refusé.");
        }
        this.balance -= amount;
    }

    /**
     * Transfère le montant désiré du compte source au compte cible.
     *
     * @param amount Le montant à transférer.
     * @param source Le compte source.
     * @param target Le compte cible.
     */
    public static void transfer(final double amount, final Account source, final Account target) {
        source.debit(amount);
        target.credit(amount);
    }

}
