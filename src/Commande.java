import javax.swing.*;
import java.util.ArrayList;
import java.util.Stack;

public class Commande extends NonTerminalExpression{


    public Commande(String exp,ArrayList<Expression> expressions, NonTerminalExpression next) {

        super(exp, expressions, next);
    }

    public double Evaluer() {
        String membres[] = this.getExp().split(" ");
        switch (membres[0]){
            case "print":
                setNext(new Plus(membres[1].trim(),new ArrayList<>(),null));
                System.out.println(this.getNext().Evaluer());
                return this.getNext().Evaluer();
            case "let":
                String m[] = membres[1].split("=");
                setNext(new Plus(m[1].trim(),new ArrayList<>(),null));
                Variable v = new Variable(m[0],"double",this.getNext().Evaluer());
                Table_des_Symboles.Ajouter_Symbole(v);
                return this.getNext().Evaluer();
            default:
                return 0;
        }
    }

    public double Handle() {
        return 0;
    }
}

