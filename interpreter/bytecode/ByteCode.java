package interpreter.bytecode;


import interpreter.VirtualMachine;

import java.util.ArrayList;

public abstract class ByteCode {




    public abstract void execute(VirtualMachine machine);

    public abstract void init(String className);

    public abstract ArrayList<String> getArgs();

}
