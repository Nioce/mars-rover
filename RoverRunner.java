
/**
 * Write a description of class RoverRunner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class RoverRunner
{
    public static void main(String[] arrrggggggs)
    {
        SimpleScanner input = new SimpleScanner();
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
        RoverGroup group = new RoverGroup();
        group.add(r1);
        group.add(r2);
        group.add(r3);
        
        // Now let's do stuff
        boolean running = true;
        String exitCommand = "quit";
        
        while (running) {
            // Input name
            System.out.print("Enter the name of the Rover to act: ");
            String name = input.readString();
            
            // Select Rover with matching name
            Rover actor = group.find(name);
            
            if (actor != null) {
                // If the rover is found
                System.out.print("Enter a command: ");
                String command = input.readString();
                
                if (command.equals("move")) {
                    System.out.print("Enter distance to move: ");
                    int distance = input.readInt();
                    actor.move(distance);
                }
                else if (command.equals("rotate right")) {
                    int rotate = input.readInt();
                    actor.rotateRight(rotate);
                }
                else if (command.equals("rotate left")) {
                    int rotate = input.readInt();
                    actor.rotateLeft(rotate);
                }
                else if (command.equals("kill")) {
                    System.out.print("Enter the name the target rover: ");
                    String targetName = input.readString();
                    
                    Rover target = group.find(targetName);
                    
                    if (target != null) {
                        actor.kill(target);
                        System.out.println(target);
                    }
                    else {
                        System.out.println("Error: No such target.");
                    }
                }
                else {
                    System.out.println("Error: Invalid command.");
                }
                
                System.out.println(actor);
            }
            else if (name.equals(exitCommand)) {
                running = false; // set flag to exit loop
            }
            else {
                System.out.println("Error: " + name + " doesn't exist.");
            }
            
            // just a blank line
            System.out.println();
        }
        
        System.out.println("Goodbye.");
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
