package interpreter;

import interpreter.bytecode.*;
import jdk.nashorn.internal.codegen.CompilerConstants;

import java.util.ArrayList;
import java.util.HashMap;


public class Program {

    private ArrayList<ByteCode> program;
    private HashMap<String, Integer> labelPosition;  // to store label addresses and its position

    public Program() {

        program = new ArrayList<>();
    }

    protected ByteCode getCode(int pc) {

        return this.program.get(pc);
    }

    public int getSize() {

        return this.program.size();
    }

    public void pushByteCode(ByteCode code){

        this.program.add(code);
    }

    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labelPosition look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter(PC)
     * HINT: make note what type of data-stucture bytecodes are stored in.
     *
     * @param program Program object that holds a list of ByteCodes
     */
    public void resolveAddrs(Program program) {

        labelPosition = new HashMap<>();

        int size = program.program.size();
        ByteCode byteCode;
        // Store position of each label

        for(int i = 0; i < size; i++){
            byteCode =  program.program.get(i);

            if(byteCode instanceof LabelCode) {
                labelPosition.put(program.getCode(i).getArgs().get(0), i);
            }
        }

        // Store the position of each label into jump byteBodes(FalseBranch, Goto, Call)

        for(int i = 0; i < size; i++){
            byteCode = program.program.get(i);
            if(byteCode instanceof FalseBranchCode || byteCode instanceof GotoCode || byteCode instanceof CallCode) {

                byteCode.init(labelPosition.get(byteCode.getArgs().get(0)).toString());
            }

        }


    }




}
