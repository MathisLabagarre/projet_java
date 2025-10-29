public class ObjRPL{
    
    private int [] value;

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

    public String toString(){
        String chaine = "";
        for(int i = 0; i < value.length - 1; i++){
            chaine += value[i] + ", ";
        }
        chaine += value[value.length - 1];
        return chaine;
    }

    public void objAdd(ObjRPL v1) throws Exception{
        if(this.value.length != v1.value.length){
            throw new Exception("Ne peut pas additionner deux vecteurs de taille différente");
        }
        else{
            for(int i = 0; i < this.value.length; i++){
                this.value[i] += v1.value[i];
            }
        }
    }

    public void objSubs(ObjRPL v1) throws Exception{
        if(this.value.length != v1.value.length){
            throw new Exception("Ne peut pas soustraire deux vecteurs de taille différente");
        }
        else{
            for(int i = 0; i < this.value.length; i++){
                this.value[i] -= v1.value[i];
            }
        }
    }

    public void objDivi(ObjRPL v1) throws Exception{
        if(this.value.length != v1.value.length){
            throw new Exception("Ne peut pas diviser deux vecteurs de taille différente");
        }
        else{
            for(int i = 0; i < this.value.length; i++){
                if(v1.value[i] == 0){
                    throw new Exception("Impossible de diviser par 0.");
                }
            }
            for(int i = 0; i < this.value.length; i++){
                this.value[i] /= v1.value[i];
            }
        }
    }

    public void objMult(ObjRPL v1) throws Exception{
        if(this.value.length != v1.value.length){
            throw new Exception("Ne peut pas multiplier deux vecteurs de taille différente");
        }
        else{
            for(int i = 0; i < this.value.length; i++){
                this.value[i] *= v1.value[i];
            }
        }
    }

    public void printObj(){
        for(int i = 0; i < value.length - 1; i++){
            System.out.print(value[i] + ", ");
        }
        System.out.print(value[value.length - 1] + " \n");
    }
}