public class ObjRPL{
    
    private int[] value;

    // public static void main(String args[]){
    //     // A SUPPRIMER 
    //     ObjRPL test = new ObjRPL(50, 51, 55);
    //     for(int i = 0; i < test.value.length; i++){
    //         System.out.println(test.value[i]);
    //     }
    // }

    public ObjRPL(int value){
        int [] values = {value};
        this.value = values;
    }
    
    public ObjRPL(int value1, int value2){
        int [] values = {value1, value2};
        this.value = values;
    }

    public ObjRPL(int value1, int value2, int value3){
        int [] values = {value1, value2, value3};
        this.value = values;
    }

    public int objSize(){
        return this.value.length;
    }

    public ObjRPL objAdd(ObjRPL v1){
        if(this.value.length != v1.value.length){
            System.out.println("Ne peut pas aditionner deux vecteurs de taille différente");
            return v1;
        }
        
    }

    public void printObj(){
        for(int i = 0; i < this.value.length; i++){
            System.out.print(value[i] + " ");
        }
    }

    // public ObjRPL add(ObjRPL value){
    //     return 
    // }
}