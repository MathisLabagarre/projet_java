public class HelloThread extends Thread {
    public HelloThread(){
        start();
        while (true) {
            System.out.println("A");        
        }
    }

    public void run(){
        while(true){
            System.out.println("B");
        }
    }
    public static void main(String[] args){
        new HelloThread();
    }
}

//normalement alterne entre A et B pour montrer qu'il y a plusieurs threads qui tournent
