public class Body {
    double posx;
    double posy;
    double velx;
    double vely;
    double accx;
    double accy;
    double mass;
Body()
{
    posx=((Math.random()-0.5)*60);
    posy=((Math.random()-0.5)*60);
    velx=((Math.random()-0.5)*10);
    vely=((Math.random()-0.5)*10);
    mass=10;

}
}

