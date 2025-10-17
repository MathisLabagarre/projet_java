public class PileRPL {
    
    private final int maxSize = 10;
    private ObjRPL [] pile;
    private int nbElements;

    public PileRPL(){
        pile = new ObjRPL[maxSize];
        nbElements = 0;
    }

    public ObjRPL pop(){
        ObjRPL firstObj = pile[0];
        for(int i = 1; i < maxSize - 1; i++){
            pile[i - 1] = pile[i];
        }
        nbElements--;
        return firstObj;
    }

    public void stack(ObjRPL objet){
        if(nbElements >= maxSize){
            System.out.println("Ne peut plus empiler car la pile est pleine");
        }
        else{
            for(int i = nbElements; i > 0; i--)
                pile[i] = pile[i - 1];
            pile[0] = objet;
            nbElements++;
        }
    }

    public void add(){
        if(nbElements < 2){
            System.out.println("Pas assez d'éléments dans la pile pour additionner.");
        }
        else{
            ObjRPL v1 = pop();
            ObjRPL v2 = pop();
            v1.objAdd(v2);
            stack(v1);
        }
    }

    public void subst(){
        if(nbElements < 2){
            System.out.println("Pas assez d'élements dans la pile pour soustraire");
        }
        else{
            ObjRPL v1 = pop();
            ObjRPL v2 = pop();
            v1.objSubs(v2);
            stack(v1);
        }
    }

    public void swap(){
        if(nbElements < 2){
            System.out.println("Pas assez d'élements dans la pile pour soustraire");
        }
        else{
            ObjRPL v1 = pop();
            ObjRPL v2 = pop();
            stack(v1);
            stack(v2);
        }
    }

    public void print(){
        // for(int i = 0; i < pile.length; i++){
        //     System.out.print(pile[i] + " ");
        // }

        int largeurTab = 0;
        for(int i = 0; i < maxSize; i++){
            if(pile[i] == null){
                break;
            }
            String chaine = pile[i].toString();
            largeurTab = (chaine.length() > largeurTab ? chaine.length() : largeurTab);
        }

        String chaineVide = "";
        for(int j = 0; j < largeurTab; j++){
            chaineVide += " ";
        }
        for(int i = maxSize - 1; i >= 0; i--){
            String chaine = "";
            if(pile[i] == null) chaine = chaineVide;
            else chaine = pile[i].toString();

            if(chaine.length() < largeurTab){
                for(int j = 0; j < largeurTab - chaine.length() + j; j++){
                    if(j%2 == 1) chaine = chaine + " ";
                    else chaine = " " + chaine;
                }
            }
            System.out.print("+");
            for(int k = 0; k < largeurTab; k++){
                System.out.print("-");
            }
            System.out.print("+\n");
            System.out.print("|" + chaine + "|\n");
        }
        System.out.print("+");
        for(int k = 0; k < largeurTab; k++){
            System.out.print("-");
        }
        System.out.println("+\n");
    }
}
