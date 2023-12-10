import java.util.ArrayList;

public abstract class NonTerminalExpression extends Expression{
    protected ArrayList<Expression> expressions;
    private NonTerminalExpression next;

    // Constructor
    public NonTerminalExpression(String exp, ArrayList<Expression> expressions, NonTerminalExpression next) {
        super(exp);
        this.expressions = expressions;
        this.next = next;
    }

    // Getters
    public ArrayList<Expression> getExpressions() {
        return expressions;
    }
    public NonTerminalExpression getNext() {
        return next;
    }

    // Setters
    public void setExpressions(ArrayList<Expression> expressions) {
        this.expressions = expressions;
    }
    public void setNext(NonTerminalExpression next) {
        this.next = next;
    }


    // Cette fonction effectue deux travails qui sont

    // HandleRequest() du patron Chain of Responsability, elle permet de faire
    // passer la requete à son suivant

    // Interpret() du patron Interpreter afin d'evaluer l'expression non terminale
    // en suivant une grammaire bien définie
    public abstract double Evaluer();
}
