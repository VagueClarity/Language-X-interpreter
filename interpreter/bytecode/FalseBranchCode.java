package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class FalseBranchCode extends ByteCode{

    ArrayList<String> arguments = new ArrayList<>();
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

        if(machine.runStack().pop() == 0){
            machine.setPc(Integer.parseInt(arguments.get(0)) );
        }
        else{
            return;
        }

    }
    public String toString(){

        if(arguments!=null) {

            return "FALSEBRANCH " + addrs;
        }
        else return "FALSEBRANCH ";
    }

    public ArrayList<String> getArgs(){
        return arguments;
    }
}
