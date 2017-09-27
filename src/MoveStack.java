public class MoveStack {
    public StackObject ptr;
    MoveStack(){
        ptr = null;
    }

    public void Push(int x, int y, Boolean isBlack){
        StackObject temp;

        if (ptr == null) ptr=new StackObject(x,y,isBlack);
        else{
            temp = new StackObject(x,y,isBlack);
            temp.next=ptr;
            ptr=temp;
        }

    }

    public StackObject Pop() {
        StackObject temp = ptr;
        ptr = ptr.next;
        return temp;
    }
}
