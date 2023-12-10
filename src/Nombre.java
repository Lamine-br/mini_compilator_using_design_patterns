public class Nombre extends Expression {

    public Nombre(String exp) {
        super(exp);
    }

    public double Evaluer() {
        return Double.parseDouble(this.getExp());
    }
}
