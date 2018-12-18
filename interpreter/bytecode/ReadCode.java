package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ReadCode extends ByteCode {

    ArrayList<String> arguments = new ArrayList<>();

    public void init(String s){

        return;

    }
    public  void execute(VirtualMachine machine){

        Scanner scanner = new Scanner(System.in);

        try {

            System.out.print("Please input an integer: ");
            int input = scanner.nextInt();
            machine.runStack().push(input);
            arguments.add(Integer.toString(input));

        }catch(InputMismatchException e){
            System.out.println("Input should only be an integer");
        }



    }

    public String toString(){

       return ("Read " + arguments.get(0));
    }

    public ArrayList<String> getArgs(){

        return arguments;
    }


}
