import java.awt.*;

public class Tracker implements Runnable {

    Trajectory world1;
    Body b[];

    @Override
    public void run() {

        world1=new Trajectory();
        world1.g=0.00001;
        b= new Body[5];
        for(int i=0;i<5;i++)
        {
            b[i]=new Body();
            b[i].id=i;
            System.out.println(b[i].toString());
        }
        Painterr p = new Painterr(b);
        Thread t = new Thread(p);
        t.start();
        try {
            t.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        double starttime=System.currentTimeMillis();
        double currenttime;

        for(int i=0;;i++)
       {
           world1.calc(b);
           world1.displacement(b);
           world1.collider(b);
           currenttime=System.currentTimeMillis();
           if((currenttime-starttime)<1) {
               try {
                   Thread.sleep((long) (1 - (currenttime - starttime)));
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
           starttime = System.currentTimeMillis();
            if(i%10==0)
            {
                for(int k=0;k<5;k++)
                {
                    System.out.println(b[k].toString());
                }

            }

        }
    }

}
