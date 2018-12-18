package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class ReturnCode extends ByteCode {

    ArrayList<String> arguments = new ArrayList<>();

    // arguments[0] is
    public void init(String s){
        arguments.add(s);

    }
    public  void execute(VirtualMachine machine){


        int addr = machine.popAddr();

        int returnVal = machine.runStack().pop(); // return Value at top of stack

        // Remove everything from current stack frame until next framePointer is reached

        while(  machine.runStack().sizeOfStack() > machine.runStack().framePeek() ){

            machine.runStack().pop();

        }

        machine.runStack().popFrame();            // pop the current frame
        machine.runStack().push(returnVal);       // return value is now on previous frame
        machine.setPc(addr);
    }


    public String toString(){

        if(!arguments.isEmpty()) {

            return "RETURN " + arguments.get(0);
        }
        else return "RETURN ";
    }

    public ArrayList<String> getArgs(){
        return arguments;
    }
}
