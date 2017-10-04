
/**
 * Write a description of class Rover here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;
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
    private ArrayList<Picture> pics;
    
    public void SetName(String name)
    {
        this.name = name;
        this.pics = new ArrayList<Picture>();
    }
    // constructor(s)
    public Rover(String name)
    {
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
    
    private String getDirectionName(int num){
        if(dir == 0){
            return "North";
        }
        if(dir == 1){
            return "East";
        }
        if(dir == 2){
            return "South";
        }
        else{
            return "West";
        }
     }
    
    public String getName() {
        return name;
    }
    // methods - stuff the Rover can do
    public void move(int dist)
    {
        if(isAlive == true){
            this.batterylf -= 2 * x;
            if (this.batterylf == 0){
                this.isAlive = false;
            }
            else{
                if (dir == 0)
                {
                    y += dist;
                }
                else if (dir == 1)
                {
                    x += dist;
                }
                else if (dir == 2)
                {
                    y -= dist;
                }
                else 
                {
                    x -= dist;
                }
    
                System.out.println(name + " moved in direction " + getDirectionName(dir));
            }
        }
        else{
            System.out.println(name + " Has hit that o o f button ");
        }
    }
    
    public void rotateLeft(int xx) 
    {
        if(isAlive == true){
            this.batterylf -= 1 * x;
            if (this.batterylf == 0 || isAlive == false){
                this.isAlive = false;
                System.out.println(name + " Is dead stop it");
            }

            while(dir>3){
                dir += 4;
                System.out.println(name + " turned to the left");    
            }
         }
       }
    
    public void recharge(int xx){
        this.batterylf += x;
    }
    
    public void takepicture(){
        Picture p = new Picture(x,y,dir,name);
        pics.add(p);
    }
    
    public void sendpictures(){
        for(Picture p: pics){
            System.out.println(p);
        }
    }
    
    
    public void teleport(int xx, int yy){
        this.x = x;
        this.y = y;
    }
    
    public void kill(Rover other){
        if(this.isAlive == true || other.isAlive == true){
            System.out.println(this.name + " oofs " + other.name);
            other.isAlive = false;
            other.health = 0;
        }
        else{
            System.out.println(this.name + " is ded nibba");
        }
    }
    
    public void suicide(){
        if(isAlive == true){
        this.batterylf -= 50;
            if (this.batterylf == 0){
                this.isAlive = false;
            }
            else{
            System.out.println(this.name + " tried to kill them selves ");
            System.out.println("My advice call get them to call 1-800-273-8255 ");
        }}
    }
    
    public void damamge(Rover other, double xx){
        if (this.isAlive == true || other.isAlive == true){
            other.health -= x;
            System.out.println(this.name + " did " + x + " damage to " + other.name);
            if (other.health > 0){
                other.isAlive = true;
                System.out.println(other.name + " Now has " + other.health + " health");
            }
            else{
                other.isAlive = false;
                other.health = 0;
                System.out.println(other.name + " Now has " + other.health + " health");
                System.out.println(other.name + " Has been killed by " + this.name);
            }
        }
    }
    
    public void rotateRight(int xx)
    {
        if(isAlive == true){
            dir += x;
            

            while(dir>3){
                dir -=4;
            }
            
            System.out.println(name + " turned to the right");     
        }
        else{
            System.out.println(name + " OML STIOP HES DEAD");
        }
        
        
    
    }

    public String toString() 
    {
        return "Rover[name=" + name + ", x=" + x + ", y=" + y + ", direction=" + getDirectionName(dir) + "]";
    }
}
