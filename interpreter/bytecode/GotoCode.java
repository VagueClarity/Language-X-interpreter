package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class GotoCode extends ByteCode {

    ArrayList<String> arguments = new ArrayList<>();
    String addr;
    public void init(String s){

        if(!arguments.isEmpty()) {
            arguments.add(0, s);
        }else{
            arguments.add(s);
            addr = s;
        }

    }

    public void execute(VirtualMachine machine){

        machine.setPc(Integer.parseInt(arguments.get(0)) - 1);
    }
    public String toString(){

        return "GOTO" + addr;

    }

    public ArrayList<String> getArgs(){

        return arguments;
    }
}
