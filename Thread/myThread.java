public class myThread extends Thread {

    private static int licznik = 0;
    private static final int max = 30;
    
    private synchronized int getLicznik(){
        return this.licznik;
    
    }

    private synchronized void setLicznik(int l){
        this.licznik = l;
    
    }
    
    public String toString(){
        return String.valueOf(getLicznik());
    }

    public void run() {
    int i = 1;
    while(i < this.max){
        setLicznik(getLicznik()+1);
        System.out.println("Nazwa w¹tku: "+this.getName()+", wartoœæ licznika: "+this.toString());
        i++;

        for(int s=1; s<200; s++){
                     try {
                             sleep(1);
                           } catch (InterruptedException e) {
                         // TODO
                     }
        }
        }
    }

//-----------------------------------------------------
    public static void main(String[] args) {
        myThread th1 = new myThread();
        th1.setName("#1");
        th1.setPriority(1);
        myThread th2 = new myThread();
        th2.setName("#2");
        th2.setPriority(9);
        
        th1.start();
        th2.start();

        try {
            th1.join();
        } catch (InterruptedException e) {
            // TODO
        }
        System.out.println("Zakoñczenie w¹tku: "+th1.getName());
        
        try {
            th2.join();
        } catch (InterruptedException e) {
            // TODO
        }
        System.out.println("Zakoñczenie w¹tku: "+th2.getName());
    }
}
