import java.util.*;
public class Trajectory {
    double g;   // vary the value of g to vary the interaction

    double[] calc(Body t[], int i) // i is target body j is index for other body
    {
        double[] netacc = new double[2]; // store net accelaration
        double[] calcacc = new double[2]; // store acceleration wrt to one body temp
        for (int j=0; j<t.length;j++) {
            if (j==i)   // to avoid calculation of force with itslef
            {
                continue;
            }
            calcacc = forcexy(t[i].mass, t[j].mass, t[j].posx - t[i].posx, t[j].posy - t[i].posy);
            netacc[0] = netacc[0] + calcacc[0]; //calculating net force
            netacc[1] = netacc[1] + calcacc[1];
        }
        netacc[0]=netacc[0]/t[i].mass; // calculate net acc
        netacc[1]=netacc[1]/t[i].mass;
        return netacc;

    }
    double force(double m1, double m2, double x, double y)
    {
        double r=(x*x+y*y); //r is r2
        double f = (g*m1*m2)/r; //r is rs so no squareroot
        return f; // net force
    }
    double[] forcexy(double m1, double m2, double x, double y) // calculate force on each dimension and return array
    {                                                           // o is x axis 1 is y axis
        double fxy[] = new double[2];
        if (x==0)       // when a body is directly on y axis wrt to target body
        {
            fxy[0]=0;
            fxy[1]=force(m1, m2 , x, y);
            return fxy;
        }
        if (y==0)           //when body is on x axis wrt target body
        {
            fxy[1]=0;
            fxy[0]=force(m1, m2 , x, y);
            return fxy;
        }
        double theta = y/x;

        theta = Math.atan(theta);
        if ((Math.signum(x)==-1) && (Math.signum(y)==1))       // theta is adjusted according to quadrant with target body at origin
        {
            theta = theta+Math.PI;
        }
        else if ((Math.signum(x)==-1) && (Math.signum(y)==-1))
        {
            theta = theta+Math.PI;

        } else if ((Math.signum(x)==1)&&(Math.signum(y)==-1))
        {
            theta = theta+(2*(Math.PI));
        }
        fxy[0] = Math.cos(theta)*force(m1, m2 ,x, y);   //force in x axis
        fxy[1]= Math.sin(theta)*force(m1, m2, x, y);    //force in y axis
        return fxy;
    }
}
