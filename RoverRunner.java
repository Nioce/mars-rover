
/**
 * Write a description of class RoverRunner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.lang.Thread;
import java.lang.*;
public class RoverRunner
{
    public static void main(String[] arrrggggggs)
    {
        SimpleScanner input = new SimpleScanner();
        Rover r1 = new Rover("Curiosity");
        Rover r2 = new Rover("Spirit");
        Rover r3 = new Rover("Noice");

        RoverGroup group = new RoverGroup();
        group.add(r1);
        group.add(r2);
        group.add(r3);
        
        
        // Now let's do stuff
        boolean running = true;
        String exitCommand = "quit";
        
        while (running) {
            // Input name
            for(int yy = 0; yy<20; yy++){
                System.out.println();
            }
            for(Rover r: group.getAllRovers()){
                System.out.println("Rover "  + " = " +r.getName());
            }
            System.out.println("Enter the name of the Rover to act: ");
            String name = input.readString();
            for(int yy = 0; yy<20; yy++){
                System.out.println();
            }

            
            
            // Select Rover with matching name
            Rover actor = group.find(name);
            
            if (actor != null) {
                System.out.println("Enter a number to select an option");
                System.out.println("After every command you will need to-");
                System.out.println("Re-enter the rover name");
                System.out.println("===================================");
                System.out.println("1. Move");
                System.out.println("2. Rotate Right");
                System.out.println("3. Roate Left");
                System.out.println("4. Kill another rover");
                System.out.println("5. Recharge a rovers power");
                System.out.println("6. Show how much battery life is left in a rover");
                System.out.println("7. Damage another rover");
                System.out.println("8. Teleport to another location");
                System.out.println("9. Take Picture");
                System.out.println("10. Send Pictures");
                System.out.println("11. Suicide");
                System.out.println("12. Heal");
                System.out.println("13. Get Info of rover");
                System.out.println("14. Revive a rover");
                System.out.println();
                System.out.print("Enter a command for " + actor + ": ");
                String command = input.readString();
                
                // If the rover is foun
                if (command.equals("1")) {
                    System.out.println("Enter distance to move: ");
                    int distance = input.readInt();
                    actor.move(distance);
                }
                else if (command.equals("2")) {
                    System.out.println("Enter amount to rotate to the right ");
                    int rotate = input.readInt();
                    actor.rotateRight(rotate);
                }
                else if (command.equals("3")) {
                    System.out.println("Enter amount to rotate to the left ");
                    int rotate = input.readInt();
                    actor.rotateLeft(rotate);
                }
                else if (command.equals("5")) {
                    System.out.println("Enter amount Recharge the rover");
                    int amount = input.readInt();
                    actor.recharge(amount);
                }
                else if (command.equals("6")){
                    actor.showBatteryLife();
                }
                else if (command.equals("7")) {
                    System.out.println("Enter the name the target rover: ");
                    String targetName = input.readString();
                    
                    Rover target = group.find(targetName);
                    if (target != null) {
                        System.out.println("Enter amount of damage to do to the other rover");
                        int amount = input.readInt();
                        actor.damamge(target, amount);
                    }
                    else {
                        System.out.println("Error: No such target.");
                    }
                }
                else if (command.equals("9")) {
                    actor.takePicture();
                }
                else if (command.equals("10")) {
                    actor.sendPictures();
                }
                else if (command.equals("14")) {
                    actor.revive();
                }
                else if (command.equals("8")) {
                    System.out.println();
                    System.out.println("Enter the x cord to go to");
                    int ss = input.readInt();
                    System.out.println("Enter the y cord to go to");
                    int bb = input.readInt();
                    actor.teleport(ss, bb);
                }
                else if (command.equals("12")){
                    System.out.print("Enter the amount to heal");
                    int ss = input.readInt();
                    actor.heal(ss);
                }
                else if (command.equals("11")) {
                    actor.commitSuicide();
                }
                else if (command.equals("13")){
                    System.out.println(actor);
                }
                else if (command.equals("4")) {
                    System.out.println("Enter the name the target rover: ");
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
