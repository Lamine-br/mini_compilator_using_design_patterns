import java.util.ArrayList;

public class Table_des_Symboles {
    private ArrayList<Symbole> symboles = new ArrayList<>();;

    private static Table_des_Symboles instance = new Table_des_Symboles();

    // Constructor
    private Table_des_Symboles(){
    }

    public static Table_des_Symboles getInstance(){
        return instance;
    }

    // Getters
    public static ArrayList<Symbole> getSymboles() {
        return getInstance().symboles;
    }
    public static Symbole getSymboleByPos(int i){
        return getInstance().symboles.get(i);
    }
    public static Symbole getSymboleById(String Id) {
        for(int i=0;i<getInstance().symboles.size();i++){
            if(getInstance().symboles.get(i).getIdentifiant().equals(Id)){
                return getInstance().symboles.get(i);
            }
        }
        return null;
    }

    public static boolean modifier_val(String Id,double valeur) {
        for(int i=0;i<getInstance().symboles.size();i++){
            if(getInstance().symboles.get(i).getIdentifiant().equals(Id)){
                ((Variable)getInstance().symboles.get(i)).setValeur(valeur);
                return true;
            }
        }
        return false;
    }
    public static boolean exists(String Id) {
        for(int i=0;i<getInstance().symboles.size();i++){
            if(getInstance().symboles.get(i).getIdentifiant().equals(Id)){
                return true;
            }
        }
        return false;
    }
    // Setters
    public static void setSymboles(ArrayList<Symbole> symboles) {
        getInstance().symboles = symboles;
    }

    // Lire le valeur d'un symbole depuis la table des symboles
    public static double Valeur_Symbole(String id){
        return getSymboleById(id).Evaluer();
    }

    // Modifier un symbole qui existe déja, sinon l'ajouter dans la table des symboles
    public static void Ajouter_Symbole(Symbole s){
        if(exists(s.getIdentifiant())){
            modifier_val(s.getIdentifiant(),((Variable)s).getValeur());
        }else{
            getInstance().symboles.add(s);
        }
    }

}
