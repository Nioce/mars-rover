
/**
 * Write a description of class Rover here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
public class Rover
{
    // fields
    private String name;
    private int x;
    private int y;
    private int dir; // 0=North, 1=East, 2=South, 3=West
    private boolean isAlive = true;
    private int health;
    private int batterylf;
    private int numPics;
    private int memory = 5;
    private ArrayList<Picture> pics;
    
    // constructor(s)
    public Rover(String name) {
        this.name = name;
        this.x = 0;
        this.y = 0;
        this.dir = 0;
        this.health = 100;
        this.isAlive = true;
        this.batterylf = 100;
        this.numPics = 0;
        this.pics = new ArrayList<Picture>();
    }
    
    // methods - stuff the Rover can do
    public void setName(String name) {
        this.name = name;
        this.pics = new ArrayList<Picture>();
    }

    
    public String getName() {
        return name;
    }
    
    private String getDirectionName() {
        if (dir == 0) {
            return "North";
        }
        else if (dir == 1) {
            return "East";
        }
        else if (dir == 2) {
            return "South";
        }
        else {
            return "West";
        }
     }

    public void move(int dist) {
        if(isAlive == true) {
            this.batterylf -= 2 * dist;
            
            if (this.batterylf == 0) {
                this.isAlive = false;
                System.out.println("He ded he cant do this, power = " + batterylf);
            }
            else {
                if (dir == 0) {
                    y += dist;
                }
                else if (dir == 1) {
                    x += dist;
                }
                else if (dir == 2) {
                    y -= dist;
                }
                else {
                    x -= dist;
                }
    
                System.out.println(name + " moved in direction " + getDirectionName());
            }
        }
        else {
            System.out.println(name + " Has hit that o o f button ");
        }
    }
    
    public void rotateRight(int turns)
    {
        if(isAlive == true){
            dir += turns;
            

            while(dir > 3){
                dir -=4;
            }
            
            System.out.println(name + " turned to the right");     
        }
        else{
            System.out.println(name + " OML STIOP HES DEAD");
        }
    
    }
    
    public void rotateLeft(int turns) 
    {
        if(isAlive == true && batterylf > 0) {
            this.batterylf -= 1 * turns;
            
            if (this.batterylf == 0 || isAlive == false) {
                this.isAlive = false;
                System.out.println(name + " Is dead stop it");
            }

            while(dir > 3) {
                dir += 4;
                System.out.println(name + " turned to the left");    
            }
        }
    }
    
    public void showBatteryLife() {
        System.out.println(batterylf);
    }
    
    public void recharge(int xx) {
        this.batterylf += xx;
    }
    public void revive(){
        this.isAlive = true;
        
    }
    public void takePicture(){
        if (numPics < memory && batterylf > 0 && isAlive == true ) {
            System.out.println();
            Picture p = new Picture(x,y,dir,name);
            pics.add(p);
            
            System.out.println("Picture taken");
        }
        else if (numPics > memory) {
            System.out.println("Please send all transmite the pictures to clear the cache, so you can take more pictures");
        }
        else {
            System.out.println("He ded he cant do this, power = " + batterylf);
        }
    }
    
    public void sendPictures(){
        if (batterylf == 0 || isAlive == false) {
            System.out.println("He ded he cant do this, power = " + batterylf);
        }
        else {
            for(Picture p: pics){
                System.out.println(p);
                this.batterylf -= 4;
            }
        }
        numPics = 0;
    }
    
    public void teleport(int x, int y){ 
        System.out.println();
        
        this.batterylf -= (Math.abs(this.x - x) + Math.abs(this.y - y))/2;
        
        if (batterylf == 0 || isAlive == false){
            System.out.println("He ded he cant do this, power = " + batterylf);
        }
        else{
            this.x = x;
            this.y = y;
            
            System.out.println("SPAPSGSDGOSNGSINGIRGSGIN, *has teleported too* x = " + x + " y = " + y);
        }
    }
    
    //public void aliveornot() {
    //    return this.isAlive;
    //}
    
    public void kill(Rover other){
        System.out.println();
        
        if(this.isAlive == true || other.isAlive == true) {
            System.out.println(this.name + " oofs " + other.name);
            other.isAlive = false;
            other.health = 0;
        }
        else {
            System.out.println(this.name + " is ded nibba");
        }
    }
    
    public void commitSuicide() {
        System.out.println();
        
        if(isAlive == true) {
            
            this.batterylf -= 50;
            
            if (this.batterylf == 0) {
                this.isAlive = false;
            }
            else {
                System.out.println(this.name + " tried to kill them selves ");
                System.out.println("My advice call get them to call 1-800-273-8255");
            }
        }
    }
    
    public void heal(int amount) {
        this.health += amount;
    }
    
    public void damamge(Rover other, int amount) {
        if (this.isAlive == true || other.isAlive == true) {
            System.out.println();
            
            int smallRandom = (int)(Math.random() * 25 + 1);
            int largeRandom = (int)(Math.random() * 100 + 1);
                        
            int damageApplied = amount + smallRandom;
            int damageTaken = largeRandom;
            
            other.health -= damageApplied;
            this.health -= damageTaken;
            
            System.out.println(this.name + " did " + damageApplied + " damage to " + other.name);
            System.out.println(this.name + " Took " + damageTaken + " From " + other.name);
            
            if (other.health > 0) {
                other.isAlive = true;
                System.out.println(other.name + " Now has " + other.health + " health");
                System.out.println(this.name + " Now has " + this.health + " health");
            }
            else {
                other.isAlive = false;
                other.health = 0;
                System.out.println(other.name + " Now has " + other.health + " health");
                System.out.println(other.name + " Has been killed by " + this.name);
                System.out.println();
                System.out.println(this.name + " Now has " + this.health + " health");
            }
        }
    }
    
    public void downloadMoreRam(int amount) {
        memory += amount;
    }

    public String toString() 
    {
        return "Rover[name=" + name + ", x=" + x + ", y=" + y + ", direction=" + getDirectionName() + "]";
    }
}
