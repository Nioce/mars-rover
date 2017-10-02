
/**
 * Write a description of class picture here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Picture
{
    // instance variables - replace the example below with your own
    private int x;
    private int y;
    private int dir; 
    private String name;
    
    public Picture(int x,  int y ,int  dir, String name){
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.name = name;
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
    
    public String toString()
    {
        return "Picture From [name= " + name + ", x=" + x + ", y=" + y + ", direction=" + getDirectionName(dir) + "]";
    }
}
