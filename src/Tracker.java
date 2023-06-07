public class Tracker implements Runnable {

    Trajectory world1;

    @Override
    public void run() {
        world1=new Trajectory();
        world1.g=10;
        Body [] b= new Body[5];
        System.out.println(b[1]);
       //for(int i=0;i<=200;i++){
         //   if(i%2==0) {
           //     world1.calc(b);
            //}
            //world1.displacement(b);
            //if(i%10==0)
            //{
              //  System.out.println(b);
            //}
        //}
    }
}
