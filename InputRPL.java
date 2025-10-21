import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputRPL {
    
    Scanner stdin;
    String query;

    public InputRPL(boolean local, String log){
        query = "";
        if (local){
            this.stdin = new Scanner(System.in);
        }
        else{

        }
    }

    public void scan(){
        try{
            this.query = this.stdin.nextLine();
        }
        catch(NoSuchElementException e){
            e.printStackTrace();
            this.query = "";
        }
    }

    public void close(){
        this.stdin.close();
    }
}
