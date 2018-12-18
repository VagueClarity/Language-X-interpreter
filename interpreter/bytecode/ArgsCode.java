package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class ArgsCode extends ByteCode {

    ArrayList<String> arguments = new ArrayList<>();

    public void init(String s){
        arguments.add(s);
    }

    public void execute(VirtualMachine machine){
        int n = machine.runStack().sizeOfStack() - Integer.parseInt(arguments.get(0));

        machine.runStack().newFrameAt(n);
    }


    public String toString(){
        if(arguments!=null) {

            return "ARGS " + arguments.get(0);
        }
        else return "ARGS ";
    }

    public ArrayList<String> getArgs(){
        return arguments;
    }
}
