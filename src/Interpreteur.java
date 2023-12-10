public class Interpreteur {

    private Table_des_Symboles tds= Table_des_Symboles.getInstance() ;
    private Expression exp;

    private static Interpreteur instance = new Interpreteur();

    private Interpreteur(){

    }

    public static Interpreteur getInstance(){
        return instance;
    }

    public Table_des_Symboles getTds() {
        return getInstance().tds;
    }
    public Expression getExp() {
        return exp;
    }

    public void setExp(Expression exp) {
        getInstance().exp = exp;
    }

    public void interpreter(){
        getInstance().getExp().Evaluer();
    }

}
