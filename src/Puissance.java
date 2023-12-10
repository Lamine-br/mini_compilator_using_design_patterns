import java.util.ArrayList;
import java.util.Stack;

import static java.lang.Math.pow;

public class Puissance extends NonTerminalExpression{

    // Constructor
    public Puissance(String exp,ArrayList<Expression> expressions, NonTerminalExpression next) {

        super(exp, expressions, next);
    }
    public double Evaluer() {
        Stack<Character> pile = new Stack();
        boolean done = false;
        int pos=0;
        for (char i : this.getExp().trim().toCharArray()) {
            if (i == '(') {
                pile.push(i);
            } else if (i == ')') {
                pile.pop();
            }
            if(pile.isEmpty()) {
                if (i == '^') {
                    done = true;
                    ArrayList<Expression> sub_expressions = new ArrayList<>();
                    String str1 = this.getExp().substring(0,pos);
                    if(str1.toCharArray()[0]=='(' && str1.toCharArray()[str1.length()-1]==')' ){
                        str1 = str1.substring(1,str1.length()-1);
                    }
                    String str2 = this.getExp().substring(pos+1);
                    if(str2.toCharArray()[0]=='(' && str2.toCharArray()[str2.length()-1]==')' ){
                        str1 = str2.substring(1,str2.length()-1);
                    }
                    Expression exp1 = new Plus(str1,new ArrayList<>(),null);
                    Expression exp2 = new Plus(str2,new ArrayList<>(),null);
                    sub_expressions.add(exp1);
                    sub_expressions.add(exp2);
                    this.setExpressions(sub_expressions);
                    System.out.println("Puissance");
                    break;
                }
            }
            pos++;
        }
        if(done){
            return pow((int)this.expressions.get(0).Evaluer(),(int)this.expressions.get(1).Evaluer()) ;
        }else{
            if(this.getExp().toCharArray()[0]=='(' && this.getExp().toCharArray()[this.getExp().length()-1]==')' ){
                String str = this.getExp().substring(1,this.getExp().length()-1);
                Expression exp = new Plus(str,new ArrayList<>(),null);
                return exp.Evaluer();
            }
            if(this.getExp().length()>5){
                Expression exp;
                Fonction fct;
                switch (this.getExp().substring(0,3)){
                    case "sin":
                        exp = new Plus(this.getExp().substring(4,this.getExp().length()-1),new ArrayList<>(),null);
                        fct = new Fonction("sin",exp);
                        return fct.Evaluer();
                    case "cos":
                        exp = new Plus(this.getExp().substring(4,this.getExp().length()-1),new ArrayList<>(),null);
                        fct = new Fonction("cos",exp);
                        return fct.Evaluer();
                    case "tan":
                        exp = new Plus(this.getExp().substring(4,this.getExp().length()-1),new ArrayList<>(),null);
                        fct = new Fonction("tan",exp);
                        return fct.Evaluer();
                    case "abs":
                        exp = new Plus(this.getExp().substring(4,this.getExp().length()-1),new ArrayList<>(),null);
                        fct = new Fonction("abs",exp);
                        return fct.Evaluer();
                    case "sqr":
                        exp = new Plus(this.getExp().substring(4,this.getExp().length()-1),new ArrayList<>(),null);
                        fct = new Fonction("sqr",exp);
                        return fct.Evaluer();
                    case "log":
                        exp = new Plus(this.getExp().substring(4,this.getExp().length()-1),new ArrayList<>(),null);
                        fct = new Fonction("log",exp);
                        return fct.Evaluer();
                }
            }

            try{
                Double.parseDouble(this.getExp());
                Nombre e = new Nombre(this.getExp());
                return e.Evaluer();
            }
            catch(Exception e){
                return Table_des_Symboles.Valeur_Symbole(this.getExp());
            }
        }
    }
}