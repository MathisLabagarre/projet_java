public class UserRPL {

    boolean local;
    String log;
    
    public static void main(String[] args){
        switch (args.length) {
            case 2:
                String[] user = args[0].split("=");
                if(!user[0].equals("-user")) break; //à changer pour expliquer le pb à l'utilisateur
                if (user[1].equals("local")) {
                    if(!args[1].startsWith("-log=")) break;
                    String[] logs = args[1].split("=");
                    new UserRPL(logs[1]);
                }
                else if (user[1].equals("remote")){
                    new UserRPL(false);
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
        new ServiceRPL(this.log);
    }

    public UserRPL(String log){
        this.local = true;
        this.log = log;
        new ServiceRPL(log);
    }

    public UserRPL(boolean local){
        this.local = local;
        this.log = "none";
    }
}
