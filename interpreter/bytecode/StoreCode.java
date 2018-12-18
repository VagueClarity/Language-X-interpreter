package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class StoreCode extends ByteCode {

    ArrayList<String> arguments = new ArrayList<>();
    private int num;
    /**
     * STORE N <id> - pop the top of the stack; store the value into the offset n from
     * the start of the frame; <id> is used as a comment and for dumping, it’s the
     * variable name where the arguments is stored
     *
     */

    public void init(String s){

        arguments.add(s);
    }
    public void execute(VirtualMachine machine){
        num = machine.runStack().peek();

        machine.runStack().store(Integer.parseInt(arguments.get(0)));

    }

    public String toString(){

        if(arguments!=null) {

            return ("STORE " + arguments.get(0) + " " + arguments.get(1) + "   "  + arguments.get(1) + " = " + num);
        }
        else return "STORE ";
    }

    public ArrayList<String> getArgs(){
        return arguments;
    }
}
