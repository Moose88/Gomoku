public class MoveStack {
    public StackObject ptr;
    MoveStack(){
        ptr = null;
    }

    public void Push(int x, int y, Boolean isBlack){ // Keeps track if the move is black or white, then adds the values of x and y to a stack
        StackObject temp;

        if (ptr == null) ptr=new StackObject(x,y,isBlack);
        else{
            temp = new StackObject(x,y,isBlack);
            temp.next=ptr;
            ptr=temp;
        }

    }

    public StackObject Pop() { // If the stack is popped, moves the pointer
        if (ptr==null) return null;
        StackObject temp = ptr;
        ptr = ptr.next;
        return temp;
    }
}
