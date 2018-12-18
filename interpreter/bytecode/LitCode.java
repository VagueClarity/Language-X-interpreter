package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LitCode extends ByteCode{

    ArrayList<String> arguments = new ArrayList<>();

    /**
     * LIT n – load the literal value n LIT 0 i – this form of Lit was
     * generated to load 0 on the stack to initialize the variable i to
     * the value 0 and reserve space on the runtime stack for i
     */

    public void init(String s){
        arguments.add(s);

    }
    public void execute(VirtualMachine machine){

        machine.runStack().push(Integer.parseInt(arguments.get(0)));

    }

    public String toString(){

        if(!arguments.isEmpty()) {

            return "LIT " + arguments.get(0);
        }
        else return "LIT " +  arguments.get(0) + " " + arguments.get(1)+ "   int " + arguments.get(1);
    }

    public ArrayList<String> getArgs(){
        return arguments;
    }
}
