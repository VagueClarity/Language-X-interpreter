package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LoadCode extends ByteCode{

    ArrayList<String> arguments =  new ArrayList<>();
    public void init(String s){
        arguments.add(s);

    }
    public void execute(VirtualMachine machine){

       machine.runStack().load(Integer.parseInt(arguments.get(0)));
    }


    public String toString(){

        if(arguments!=null) {

            return "LOAD " + arguments.get(0) + " " + arguments.get(1) + "    <load " + arguments.get(1) + ">";
        }
        else return "LOAD ";
    }

    public ArrayList<String> getArgs(){
        return arguments;
    }
}
