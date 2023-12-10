public class Variable extends Symbole{
    private String type;
    private double valeur;

    // Constructor
    public Variable(String identifiant, String type, double valeur) {
        super(identifiant);
        this.type = type;
        this.valeur = valeur;
    }

    // Getters
    public String getType() {
        return type;
    }
    public double getValeur() {
        return valeur;
    }

    // Setters
    public void setType(String type) {
        this.type = type;
    }
    public void setValeur(double valeur) {
        this.valeur = valeur;
    }


    public double Evaluer(){
        return this.valeur;
    }
}
