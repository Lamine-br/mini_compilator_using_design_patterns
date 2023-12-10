public abstract class Symbole extends Expression {
    private String identifiant;

    // Constructor
    public Symbole(String identifiant) {
        super("");
        this.identifiant = identifiant;
    }

    //Getters
    public String getIdentifiant() {
        return identifiant;
    }

    // Setters
    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public abstract double Evaluer();
}
