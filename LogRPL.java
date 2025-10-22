import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class LogRPL {
    String logFilePath;
    BufferedWriter writeLogFile;
    BufferedReader readLogFile;

    public LogRPL(){
        // String defaultName = "./logFile";
        // int compteur = 0;
        // while(true){
        //     File logFile = new File(defaultName + compteur + ".txt");
        //     if(!logFile.exists()){
        //         this.logFilePath = defaultName + compteur + ".txt";
        //         break;
        //     }
        //     compteur++;
        // }
        this.logFilePath = "./logFile.txt";
        try{
            this.writeLogFile = new BufferedWriter(new FileWriter(this.logFilePath));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public LogRPL(String path){
        try{
            this.readLogFile = new BufferedReader(new FileReader(path));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void writeLog(String entry){
        try{
            if(this.writeLogFile != null){
                this.writeLogFile.write(entry);
                this.writeLogFile.newLine();
                this.writeLogFile.flush();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void stopLog(){
        try{
            if(this.writeLogFile != null){
                this.writeLogFile.close();
            }
            if(this.readLogFile != null){
                this.readLogFile.close();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
