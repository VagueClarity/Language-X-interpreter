package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LabelCode extends ByteCode {


    /**
     ** LABEL <label>; target for branches;(FALSEBRANCH, GOTO and CALL)
     */


    ArrayList<String> arguments = new ArrayList<>();
    public void init(String s){
        arguments.add(s);
    }
    public void execute(VirtualMachine machine){

        return;
    }

    public String toString(){

        if(arguments!=null) {

            return "LABEL " + arguments.get(0);
        }
        else return "LABEL ";
    }

    public ArrayList<String> getArgs(){

        return arguments;

    }
}
