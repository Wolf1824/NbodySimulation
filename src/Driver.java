public class Driver {
    public static void main(String args[])
    {
        Tracker tr = new Tracker();
        Thread t= new Thread(tr);
        t.run();
    }
}
