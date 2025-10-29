import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class InputRPL {
    
    String query;
    Boolean replay;
    boolean local;

    Scanner stdin;
    BufferedReader reader;

    BufferedReader in;
    Socket socket;

    public InputRPL(Socket socket){
        this.query = "";
        this.local = false;
        this.socket = socket;
        try {
            this.in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public InputRPL(boolean local, String log){
        this.query = "";
        if (local){
            this.local = true;
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
            else if(log.equals("rec"))
            {
                this.stdin = new Scanner(System.in);
                this.replay = false;
            }
        }
    }

    public void scan(){
        if(local){
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
        else{
            try{
                this.query = in.readLine();
            }
            catch(Exception e){
                this.query = "exit";
            }
        }
    }

    public void close(){
        if(this.local){
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
        else{
            try{
                this.socket.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
