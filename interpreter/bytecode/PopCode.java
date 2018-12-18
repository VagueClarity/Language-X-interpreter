package interpreter.bytecode;


import interpreter.VirtualMachine;

import java.util.ArrayList;

public class PopCode extends ByteCode{

    // Store the arguments
    private ArrayList<String> arguments  = new ArrayList<>();
    public void init(String argument){

        arguments.add(argument);

    }
    public void execute(VirtualMachine machine){


        // pop the top n things
        for(int i = 1; i < Integer.parseInt(arguments.get(0)); i++ ){

            machine.runStack().pop();
        }
    }

    public String toString(){

        if(arguments!=null) {

            return "POP " + arguments.get(0);
        }
        else return "POP ";
    }

    public ArrayList<String> getArgs(){
        return arguments;
    }
}
