package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class DumpCode extends ByteCode{

    ArrayList<String> arguments = new ArrayList<>();
    public void init(String s){
        arguments.add(s);

    }

    public void execute(VirtualMachine machine){
        String flag = arguments.get(0);

        if(flag.equals("ON")) {
            machine.setDump(true);
        }
        if(flag.equals("OFF")){
            machine.setDump(false);
        }
    }
    public String toString(){

        return null;
    }

    public ArrayList<String> getArgs(){
        return arguments;
    }
}
