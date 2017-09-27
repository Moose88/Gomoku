public class StackObject {
    int x,y;
    String colour;
    StackObject next;
    StackObject(int x, int y, String colour)
    {
        this.x = x;
        this.y=y;
        this.colour=colour;
        next = null;
    }
}
