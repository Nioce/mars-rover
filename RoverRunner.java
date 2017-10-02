
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
        System.out.println(r2);
        r2.rotateRight(1);
        System.out.println(r2);
        r2.rotateRight(7);
        System.out.println(r2);
        r2.rotateRight(1);
        System.out.println(r2);
         // 0=North, 1=East, 2=South, 3=West
         
        r2.teleport(20,40);
        System.out.println(r2);
        
        System.out.println();
        
        r2.takepicture();
        r2.move(4);
        r2.takepicture();
        r2.rotateRight(2);
        r2.move(5);
        r2.takepicture();

        System.out.println();
        r2.sendpictures();
        /**
        r3.SetName("gayyy");
        
        r1.move(2);
        System.out.println(r1);

        r1.rotateRight(3);
        System.out.println(r1);
        
        r3.move(4);
        System.out.println(r3);
        r3.move(2);
        System.out.println(r3);
        r3.rotateRight(5);
        System.out.println(r3);
        r2.rotateRight(3);
        for (int x=0; x<5; x++){
            r2.move(4);
        }
        System.out.println(r2);
        r2.rotateRight(7);
        r2.move(1);
        r2.move(4);
        System.out.println(r2);
        r2.picture();
        r2.picture(r3);
        System.out.println();
        r2.damamge(r3, 52);
        System.out.println();
        r2.damamge(r3, 74);
        System.out.println();
        System.out.println(r1);
        **/
        r1.kill(r2);
    }
}
