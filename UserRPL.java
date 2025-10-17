public class UserRPL {

    boolean local;
    String log;
    

    public static void main(String[] args){
        switch (args.length) {
            case 2:
                String[] user = args[0].split("=");
                if (user[1].equals("local")) {
                    
                }
                else if (user[1].equals("remote")){

                }
                break;
            case 1:
                //parse entrée puis écoute en local
                break;
            case 0:
                new UserRPL();
                break;
            default:
                System.out.println("Trop d'arguments");
                break;
        }
        System.out.println("Fin du programme.");
    }

    public UserRPL(){
        this.local = true;
        this.log = "none";
    }

    public UserRPL(boolean local, String log){
        this.local = local;
        this.log = log;
    }
}
