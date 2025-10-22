import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;

public class InputRPL {
    
    Scanner stdin;
    BufferedReader reader;
    String query;
    Boolean replay;

    public InputRPL(boolean local, String log){
        query = "";
        if (local){
            if(log.equals("replay")){
                this.replay = true;
                try{
                    this.reader = new BufferedReader(new FileReader("./logFile.txt"));
                }
                catch(Exception e){
                    System.out.println("Impossible de lire le fichier. Arrêt ...");
                }
            }
            else if(log.equals("none")){
                this.stdin = new Scanner(System.in);
                this.replay = false;
            }
        }
        else{

        }
    }

    public void scan(){
        if(replay){
            try{
                this.query = this.reader.readLine();
                if(this.query == null){
                    this.query = "exit";
                }
            }
            catch(Exception e){
                this.query = "exit";
            }
        }
        else{
            try{
                this.query = this.stdin.nextLine();
            }
            catch(NoSuchElementException e){
                e.printStackTrace();
                this.query = "";
            }
        }
    }

    public void close(){
        if(!this.replay) this.stdin.close();
        if(this.replay){
            try{
                this.reader.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
            
        }
    }
}
