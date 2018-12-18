package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class HaltCode extends ByteCode {



    public void init(String argument){
        return;

    }
    public  void execute(VirtualMachine machine){

        machine.setRunning(false);
    }
    public String toString(){

        return "HALT";
    }

    public ArrayList<String> getArgs(){
        return null;
    }
}
