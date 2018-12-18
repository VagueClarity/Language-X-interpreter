package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class WriteCode extends ByteCode {

    ArrayList<String> arguments = new ArrayList<>();

    /**
     * WRITE; Write the value of the top of the stack to output. Leave the value on the top of the stack
     * @param s
     */

    public void init(String s){

        return;
    }
    public  void execute(VirtualMachine machine){

        // Output it on console
        System.out.println(machine.runStack().peek());
        arguments.add(Integer.toString(machine.runStack().peek()));

    }

    public String toString(){
        if(arguments!= null) {

            return "WRITE " + arguments.get(0);
        }
        else return "WRITE ";
    }

    public ArrayList<String> getArgs(){
        return arguments;
    }
}
