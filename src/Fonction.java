public class Fonction extends Symbole{
    private Expression parametre ;

    // Constructor
    public Fonction(String identifiant, Expression parametre) {
        super(identifiant);
        this.parametre = parametre;
    }

    public double Evaluer(){
        switch(this.getIdentifiant()){
            case "sin":
                return Math.sin(Math.toRadians(this.parametre.Evaluer()));
            case "cos":
                return Math.cos(Math.toRadians(this.parametre.Evaluer())) ;
            case "tan":
                return Math.tan(Math.toRadians(this.parametre.Evaluer())) ;
            case "abs":
                return Math.abs(this.parametre.Evaluer()) ;
            case "sqr":
                return Math.sqrt(this.parametre.Evaluer()) ;
            case "log":
                return Math.log(this.parametre.Evaluer()) ;
            default:
                return 0;
        }
    }
}
