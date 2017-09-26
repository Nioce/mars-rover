
/**
 * Write a description of class Rover here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
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
    public void SetName(String name)
    {
        this.name = name;
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
    }
    
    
    // methods - stuff the Rover can do
    public void move()
    {
        if(isAlive == true){
            this.batterylf -= 2;
            if (this.batterylf == 0){
                this.isAlive = false;
            }
            else{
                if (dir == 0)
                {
                    y += 1;
                }
                else if (dir == 1)
                {
                    x += 1;
                }
                else if (dir == 2)
                {
                    y -= 1;
                }
                else 
                {
                    x -= 1;
                }
    
                System.out.println(name + " moved in direction " + dir);
            }
        }
        else{
            System.out.println(name + " Has hit that o o f button ");
        }
    }
    
    public void rotateLeft() 
    {
        if(isAlive == true){
            this.batterylf -= 1;
            if (this.batterylf == 0){
                this.isAlive = false;
            }
            else{
                dir -= 1;
                
                if (dir < 0)
                {
                    dir = 3;
                }
                
                System.out.println(name + " turned to the left");    
            }
        }
        else {
            System.out.println(name + " Is dead stop it");
        }
    }
    public void picture(){
        if(isAlive == true){
            this.batterylf -= 5;
            if (this.batterylf == 0){
                this.isAlive = false;
            }
            else{
            System.out.println(name + " Takes a bad selfie #feelsBadMan");
        }
    }
    }
    public void picture(Rover other){
        if(isAlive == true){
            this.batterylf -= 5;
            if (this.batterylf == 0){
                this.isAlive = false;
            }
            else{
            System.out.println(this.name + " Takes a glamore shot of " + other);
        }
        }
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
    public void damamge(Rover other, double x){
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
    public void rotateRight()
    {
        if(isAlive == true){
            dir += 1;
            
            if (dir == 4)
            {
                dir = 0;
            }
            
            System.out.println(name + " turned to the right");     
        }
        else{
            System.out.println(name + " OML STIOP HES DEAD");
        }
        
        
    
    }

    public String toString() 
    {
        return "Rover[name=" + name + ", x=" + x + ", y=" + y + ", dir=" + dir + "]";
    }
}
