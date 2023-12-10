public abstract class Expression {
    private String exp;

    // Constructor
    public Expression(String exp) {
        this.exp = exp;
    }

    // Getters
    public String getExp() {
        return exp;
    }

    // Setters
    public void setExp(String exp) {
        this.exp = exp;
    }

    public abstract double Evaluer();
}
