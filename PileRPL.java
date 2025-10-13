import java.util.Stack;

public class PileRPL {
    
    private final int maxSize = 10;
    private Stack<ObjRPL> pile;

    public static void main(String args[]){
        //A ENLEVER 
    }

    public PileRPL(){
        this.pile = new Stack<ObjRPL>();
    }

    public void stack(ObjRPL objet){
        this.pile.add(objet);
    }

    public void add(){
        ObjRPL v1 = pile.pop();
        ObjRPL v2 = pile.pop();
        //this.pile.add(v1.add(v2));
    }

    public void stackPrint(){
        for(int i = 0; i < this.pile.size(); i++){
            this.pile.elementAt(i).printObj();
            System.out.println("\n");
        }
    }
}
