public class MoveStack {
    StackObject ptr;
    MoveStack(){
        ptr = null;
    }

    public void Push(int x, int y, String colour){
        StackObject temp;

        if (ptr == null) ptr=new StackObject(x,y,colour);
        else{
            temp = new StackObject(x,y,colour);
            temp.next=ptr;
            ptr=temp;
        }

    }

}
