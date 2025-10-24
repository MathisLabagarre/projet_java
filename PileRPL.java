public class PileRPL {
    
    private final int maxSize = 10;
    private ObjRPL [] pile;
    private int nbElements;

    public PileRPL(){
        pile = new ObjRPL[maxSize];
        nbElements = 0;
    }

    public ObjRPL pop(){
        ObjRPL obj = pile[nbElements - 1];
        pile[nbElements - 1] = null;
        nbElements--;
        return obj;
    }

    public void stack(ObjRPL objet) throws Exception{
        if(nbElements >= maxSize){
            throw new Exception("Ne peut plus empiler car la pile est pleine");
        }
        else{
            pile[nbElements] = objet;
            nbElements++;
        }
    }

    public void add() throws Exception{
        if(nbElements < 2){
            throw new Exception("Pas assez d'éléments dans la pile pour additionner.");
        }
        else{
            ObjRPL v1 = pop();
            ObjRPL v2 = pop();
            try {
                v1.objAdd(v2);
                stack(v1);
            }
            catch(Exception e){
                System.out.println(e);
                throw e;
            }
 
        }
    }

    public void subst() throws Exception{
        if(nbElements < 2){
            throw new Exception("Pas assez d'élements dans la pile pour soustraire");
        }
        else{
            ObjRPL v1 = pop();
            ObjRPL v2 = pop();
            try{
                v1.objSubs(v2);
                stack(v1);
            }
            catch(Exception e){
                throw e;
            }
        }
    }

    public void swap() throws Exception{
        if(nbElements < 2){
            throw new Exception("Pas assez d'élements dans la pile pour échanger");
        }
        else{
            ObjRPL v1 = pop();
            ObjRPL v2 = pop();
            stack(v1);
            stack(v2);
        }
    }
    
    public void mult() throws Exception{
        if(nbElements < 2){
            throw new Exception("Pas assez d'élements dans la pile pour multiplier");
        }
        else{
            ObjRPL v1 = pop();
            ObjRPL v2 = pop();
            try {
                v1.objMult(v2);
                stack(v1);
            }
            catch (Exception e){
                throw e;
            }
        }
    }

    public void div() throws Exception{
        if(nbElements < 2){
            throw new Exception("Pas assez d'élements dans la pile pour diviser");
        }
        else{
            ObjRPL v1 = pop();
            ObjRPL v2 = pop();
            try{
                v1.objDivi(v2);
                stack(v1);
            }
            catch (Exception e){
                throw e;
            }
        }
    }

    public void print(OutputRPL output){
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
            output.print("+");
            for(int k = 0; k < largeurTab; k++){
                output.print("-");
            }
            output.print("+\n");
            output.print("|" + chaine + "|\n");
        }
        output.print("+");
        for(int k = 0; k < largeurTab; k++){
            output.print("-");
        }
        output.print("+\n");
    }
}
