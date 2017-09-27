public class StackObject {
    int x,y;
    Boolean IsBlack;
    StackObject next;
    StackObject(int x, int y, Boolean IsBlack)
    {
        this.x = x;
        this.y=y;
        this.IsBlack=IsBlack;
        next = null;
    }
}
