import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("Entrez vos commandes. Tapez end pour terminer votre programme.");
        System.out.println("Une commande doit �tre de la forme");
        System.out.println("let <variable> = <expression>");
        System.out.println("ou");
        System.out.println("print <expression>");
        String l1 = "" ;
        Scanner scan = new Scanner(System.in) ;

        while(true) {
            System.out.print("> ");
            l1 = scan.nextLine() ;
            if(l1.trim().equals("end")){
                break ;
            }
            Commande cmd = new Commande(l1,new ArrayList<>(),null);
            Interpreteur i = Interpreteur.getInstance();
            i.setExp(cmd);
            i.interpreter();
        }
        System.out.println("Fin du programme") ;
        scan.close() ;
        }
    }

