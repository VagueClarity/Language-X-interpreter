package interpreter;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Vector;

public class RunTimeStack {

    private ArrayList runTimeStack;
    private Stack<Integer> framePointer;

    public RunTimeStack() {
        runTimeStack = new ArrayList<Integer>();
        framePointer = new Stack<>();
        // Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }
    public void dump(){

        int pointer = framePointer.pop();
        System.out.print("[");
        while(runTimeStack.size() > pointer){

            System.out.print(pop());
            if(runTimeStack.size() != pointer){
                System.out.print(", ");
            }
        }
        System.out.print("] \n" );



    }

    public int peek(){

        return (int) runTimeStack.get(runTimeStack.size()-1);
    }

    public int pop(){

        System.out.println("Stack size: " + (runTimeStack.size() - 1));
        if(!runTimeStack.isEmpty()) {
            return (int) runTimeStack.remove(runTimeStack.size() - 1);
        }
        else
            return 0;

    }

    public int push(int i){
        runTimeStack.add(i);
        return i;
    }

    public void newFrameAt(int offset){

        framePointer.add(offset);
    }

    public void popFrame(){

        int returnVal = pop();
        while(runTimeStack.size() > framePointer.peek()){
           pop();
        }
        runTimeStack.add(returnVal);
        framePointer.pop();

    }

    public int store(int offset){
        int val = pop();
        runTimeStack.set(framePointer.peek() + offset, val);
        return val;

    }

    public int load(int offset){

       return  push((int)runTimeStack.get(framePointer.peek() + offset));

    }
    public Integer push (Integer val){

        runTimeStack.add(val);
       return val;
    }

    public int framePeek(){

        return framePointer.peek();
    }

    public int sizeOfStack(){

        return runTimeStack.size();
    }

    public int sizeOfFrameStack(){

        return framePointer.size();
    }
}
