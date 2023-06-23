import javax.swing.*;
import java.awt.*;

public class Painterr extends Canvas implements Runnable {
Body[] t;

    public Painterr() {

    }

    Double transformationx(int i)
    {
            System.out.println(t[i].posx+500);
            return t[i].posx+500;

    }
    Double transformationy(int i)
    {
        System.out.println(-(t[i].posy-500));
        return -(t[i].posy-500);

    }
    Painterr(Body b[])
    {
        t=b;

    }

    @Override
    public void run() {
        JFrame f = new JFrame();

        f.setSize(1000, 1000);
        f.setBackground(Color.white);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(this);
        f.setVisible(true);
        for (; ; ) {

            this.repaint();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        for(int i=0;i<t.length;i++) {

            g.drawRect(Math.toIntExact(Math.round(this.transformationx(i))), Math.toIntExact(Math.round(this.transformationy(i))), 5, 5);
        }
    }





}
