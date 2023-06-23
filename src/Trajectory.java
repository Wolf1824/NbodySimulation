
public class Trajectory {
    double g;   // vary the value of g to vary the interaction

    void calc(Body t[]) // i is target body j is index for other body
    {
        double [] calcacc = new double [2];
        Body com = new Body();
        for (int i=0;i<t.length;i++) {
            com=com(t, i);
            calcacc=forcexy(t[i].mass,com.mass,com.posx-t[i].posx,com.posy-t[i].posy);
            t[i].accx=calcacc[0];
            t[i].accy=calcacc[1];
            t[i].accx = t[i].accx / t[i].mass; // calculate net acc
            t[i].accy = t[i].accy / t[i].mass;
        }

    }
    private double force(double m1, double m2, double x, double y)
    {
        double r=(x*x+y*y); //r is r2
        double f = (g*m1*m2)/r; //r is rs so no squareroot
        return f; // net force
    }
    private double[] forcexy(double m1, double m2, double x, double y) // calculate force on each dimension and return array
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
    private Body com (Body t[], int j)
    {
        Body b = new Body();
        for (int i=0; i<t.length; i++)
        {
            if (i==j)
            {
                continue;
            }
            b.mass=b.mass+t[i].mass;
            b.posx= b.posx+(t[i].posx*t[i].mass);
            b.posy= b.posy+(t[i].posy*t[i].mass);
            b.posx=b.posx/b.mass;
            b.posy=b.posy/b.mass;
        }
        return b;
    }
    void displacement(Body t[])
    {
        double time =0.01;
        for(int i=0; i<t.length;i++)
        {

            t[i].posx=t[i].posx+(t[i].velx*time+((0.5*t[i].accx)*time*time));
            t[i].velx=t[i].velx+t[i].accx*time;
            t[i].posy=t[i].posy+(t[i].vely*time+(0.5*t[i].accy*time*time));
            t[i].vely=t[i].vely+t[i].accy*time;
        }
    }
    void collider(Body t[])
    {
        for(int j=0;j<t.length;j++)
        {
            if(t[j].posy>500)
            {


            }
            if(t[j].posx>500)
            {

            }
            if(t[j].posy<(-500))
            {

            }
            if(t[j].posx<(-500))
            {

            }

        }
    }
}
