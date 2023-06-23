public class Body {
    double posx;
    double posy;
    double velx;
    double vely;
    double accx;
    double accy;
    double mass;
    int id;
Body()
{
    posx=Math.round(((Math.random()-0.5)*60)*100)/100;
    posy=Math.round(((Math.random()-0.5)*60)*100)/100;
    //velx=Math.round(((Math.random()-0.5)*10)*100)/100;
    //vely=Math.round(((Math.random()-0.5)*10)*100)/100;
    mass=10;

}

    @Override
    public String toString() {
        return "Body{" +
                "posx=" + posx +
                ", posy=" + posy +
                ", velx=" + velx +
                ", vely=" + vely +
                ", accx=" + accx +
                ", accy=" + accy +
                ", mass=" + mass +
                ", id=" + id +
                '}';
    }
}

