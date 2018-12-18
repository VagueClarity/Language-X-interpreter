
package interpreter;

import interpreter.bytecode.ByteCode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;
    private StringTokenizer stringTokenizer;
    private Program program = new Program();

    /**
     * Constructor Simply creates a buffered reader.
     * YOU ARE NOT ALLOWED TO READ FILE CONTENTS HERE
     * THIS NEEDS TO HAPPEN IN LOADCODES.
     */
    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));

    }
    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     *      Tokenize string to break it into parts.
     *      Grab THE correct class name for the given ByteCode from CodeTable
     *      Create an instance of the ByteCode class name returned from code table.
     *      Parse any additional arguments for the given ByteCode and send them to
     *      the newly created ByteCode instance via the init function.
     */
    public Program loadCodes() {
        String byteLine;


        // Tokenize String by bytecode name
        try {
            while((byteLine = byteSource.readLine()) != null) {

                // Delimiter is a space
                stringTokenizer = new StringTokenizer(byteLine);
                String className = stringTokenizer.nextToken();
                String byteInstance = CodeTable.getClassName(className);

                try {
                    String p = "interpreter.bytecode." + byteInstance;

                    ByteCode byteCode = (ByteCode) (Class.forName(p).newInstance());
                    // Store arguments
                    while(stringTokenizer.hasMoreElements()) {
                        byteCode.init(stringTokenizer.nextToken());
                    }
                    this.program.pushByteCode(byteCode);

                }
                catch(ClassNotFoundException | IllegalAccessException | InstantiationException e ){
                   System.out.println(e);
                }
            }
        }catch(IOException e){
            System.out.println("Can't read file");
        }
        this.program.resolveAddrs(program);
       return this.program;
    }

}
