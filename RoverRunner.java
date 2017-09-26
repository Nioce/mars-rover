
/**
 * Write a description of class RoverRunner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RoverRunner
{
    public static void main(String[] arrrggggggs)
    {
        Rover r1 = new Rover("Curiosity");
        Rover r2 = new Rover("Spirit");
        Rover r3 = new Rover("Noice");
        System.out.println(r1);
        
        r3.SetName("gayyy");
        
        r1.move();
        System.out.println(r1);

        r1.rotateRight();
        System.out.println(r1);
        
        r3.move();
        System.out.println(r3);
        r3.move();
        System.out.println(r3);
        r3.rotateRight();
        System.out.println(r3);
        r2.rotateRight();
        for (int x=0; x<5; x++){
            r2.move();
        }
        System.out.println(r2);
        r2.rotateRight();
        r2.move();
        r2.move();
        System.out.println(r2);
        r2.picture();
        r2.picture(r3);
        System.out.println();
        r2.damamge(r3, 52);
        System.out.println();
        r2.damamge(r3, 74);
        System.out.println();
        r1.move();
        System.out.println(r1);
        
        r1.kill(r2);
    }
}
