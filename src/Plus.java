import javax.swing.*;
import java.util.ArrayList;
import java.util.Stack;

public class Plus extends NonTerminalExpression{

    // Constructor
    public Plus(String exp,ArrayList<Expression> expressions, NonTerminalExpression next) {

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
                if (i == '+') {
                    done = true;
                    ArrayList<Expression> sub_expressions = new ArrayList<>();
                    String str1 = this.getExp().substring(0,pos);
                    if(str1.toCharArray()[0]=='(' && str1.toCharArray()[str1.length()-1]==')' ){
                        str1 = str1.substring(1,str1.length()-1);
                    }
                    String str2 = this.getExp().substring(pos+1);
                    if(str2.toCharArray()[0]=='(' && str2.toCharArray()[str2.length()-1]==')' ){
                        str2 = str2.substring(1,str2.length()-1);
                    }
                    Expression exp1 = new Plus(str1,new ArrayList<>(),null);
                    Expression exp2 = new Plus(str2,new ArrayList<>(),null);
                    sub_expressions.add(exp1);
                    sub_expressions.add(exp2);
                    this.setExpressions(sub_expressions);
                    break;
                }
            }
            pos++;
        }
        if(done){
            return this.expressions.get(0).Evaluer() + this.expressions.get(1).Evaluer() ;
        }else{
            setNext(new Moins(this.getExp(),new ArrayList<>(),null));
            return this.getNext().Evaluer();
        }
    }

}
