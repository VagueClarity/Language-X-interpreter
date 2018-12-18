package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class CallCode extends ByteCode{

    private ArrayList<String> arguments = new ArrayList<>();
    String addrs;

    public void init(String s){
        if(!arguments.isEmpty()) {
            arguments.add(0, s);
        }else{
            arguments.add(s);
            addrs = s;
        }
    }

    public void execute(VirtualMachine machine){

        // mark the return add and set pc to argument given
        int pc  = machine.getPc();
        machine.pushAddr(pc);
        machine.setPc(Integer.parseInt(arguments.get(0)) - 1);



    }

    public String toString(){


         return "CALL " + addrs;
    }

    public ArrayList<String> getArgs(){

        return arguments;
    }
}

