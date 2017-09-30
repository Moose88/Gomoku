public class StackObject {
    int x,y;
    Boolean IsBlack;
    StackObject next;
    StackObject(int x, int y, Boolean IsBlack) // A stack object for our stack
    {
        this.x = x;
        this.y=y;
        this.IsBlack=IsBlack;
        next = null;
    }
}
