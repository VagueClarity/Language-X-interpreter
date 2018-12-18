package interpreter;

import java.util.Stack;
import interpreter.bytecode.ByteCode;

public class VirtualMachine {

    private RunTimeStack runStack;
    private Stack returnAddrs;
    private Program program;
    private int pc;
    private boolean isRunning;
    private boolean dump;

    protected VirtualMachine(Program program) {
        this.program = program;

    }

    void executeProgram(){
        pc = 0;
        runStack = new RunTimeStack();
        returnAddrs = new Stack<Integer>();
        isRunning = true;
        dump = false;
        while(isRunning){
            ByteCode code = program.getCode(pc);
            code.execute(this);
            System.out.println(code.toString());

            if(dump) {

                System.out.println(code.toString());
                runStack.dump();
            }
            pc++;
        }

    }


    public boolean isProgramRunning(){

        return isRunning;
    }

    public void setRunning(boolean v){

        isRunning = v;
    }

    public int popAddr(){

        return (int) returnAddrs.pop();
    }

    public int getPc(){

        return pc;
    }
    public void setPc(int pc){

        this.pc = pc;
    }


    public RunTimeStack runStack(){

        return runStack;
    }

    @SuppressWarnings("unchecked")
    public int pushAddr(int pc){

        this.returnAddrs.push(pc);
        return pc;

    }

    public boolean getDump(){
        return dump;

    }

    public void setDump(boolean flag){

        dump = flag;
    }

}
