
package smartcollision;

import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;

public class Ship {
    private double x , y, s, c;
    public LinkedList<DyObstacle> dangerList = new LinkedList<>();
    public ArrayList<Point> shipTrack = new ArrayList<>();
    
    private double stepx, stepy;
    private double c2r;
    
    public Ship(double x, double y, double s, double c){
        this.x=x;
        this.y=y;
        if(s > 20)
            this.s = 20;
        else
            this.s = s;
        this.c=c;
    }
    public Ship() {
        this.x = DataBase.defaultx;
        this.y = DataBase.defaulty;
        this.s = DataBase.defaults;
        this.c = DataBase.defaultc;
    }
    
    public double getParameter(int index){
        switch(index){
            case 1 : return x;
            case 2 : return y;
            case 3 : return s;
            case 4 : return c;
            default : return 0;//error
        }
    }
    
    public void giveValue(int index, double newValue){//change ship's parameter
        switch(index){
            case 1: x = newValue; break;
            case 2: y = newValue; break;
            case 3: s = newValue; break;
            case 4: c = newValue; break;
            default: x =DataBase.defaultx; y = DataBase.defaulty;
                s = DataBase.defaults; c = DataBase.defaultc;
                break;
        }
        
        while (this.c<0||this.c>=360) {
            if(this.c<0) this.c+=360;
            if(this.c>=360) this.c-=360;
        }
        if(this.c<0||this.c>360) System.err.println("course out of limits!!");
        
        if(this.s<0||this.s>20) System.err.println("speed out of limits!!");
    }
    
    public void goAhead(){//position, course, speed test
        c2r = Math.toRadians(c);
        stepx = s*Math.sin(c2r);
        stepy = s*Math.cos(c2r);
        x+=stepx;
        y-=stepy;
        
        shipTrack.add(new Point((int)x, (int)y));
        
        if(x<0) x = 1120;
        if(x>1120) x = 0;
        if(y<0) y = 800;
        if(y>800) y = 0;
    }
    
//    public void changeDirection(double c){//change direction should be step and step
//        double enddirection = this.c + c;
//        for(;;){
//            if (this.c >= enddirection) break;
//            this.c++;
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(Ship.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        //0-360 limit
//        while (this.c<0||this.c>=360) {
//            if(this.c<0) this.c+=360;
//            if(this.c>=360) this.c-=360;
//        }
//        if(this.c<0||this.c>360) System.err.println("course out of limits!!");
//    }
    
//    public void changeSpeed(double s){//speed at 0-20 kn
//        //adjust s
//        double endspeed = this.s + s;
//        for(;;){
//            if (this.s >= endspeed) break;
//            this.s++;
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(Ship.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        if(this.s<0||this.s>20) System.err.println("speed out of limits!!");
//    }
    
}
