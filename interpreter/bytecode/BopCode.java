package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;


public class BopCode extends ByteCode {


    ArrayList<String> arguments = new ArrayList<>();  // has operations
    public void init(String s){
        arguments.add(s);

    }

    public void execute(VirtualMachine machine){
        int n1 = machine.runStack().pop();
        int n2 = machine.runStack().pop();

        String s = arguments.get(0);

        switch (s){

            case "+":
                machine.runStack().push(n2 + n1);
                break;

            case "-":
                machine.runStack().push(n2 - n1);
                break;

            case "/":
                try {
                    machine.runStack().push(n2 / n1);
                }catch(ArithmeticException e){
                    System.out.println("Did you try to divide by zero?");
                }
                break;

            case "*":
                machine.runStack().push(n2 * n1);
                break;

            case "==":
                if(n2 == n1){
                    machine.runStack().push(1);
                }else {
                    machine.runStack().push(0);
                }
                break;

            case "!=":
                if(n2 != n1){
                    machine.runStack().push(1);
                }else {
                    machine.runStack().push(0);
                }
                break;

            case "<=":
                if(n2 <= n1){
                    machine.runStack().push(1);
                }else {
                    machine.runStack().push(0);
                }
                break;

            case ">":
                if(n2 > n1){
                    machine.runStack().push(1);
                }else {
                    machine.runStack().push(0);
                }
                break;

            case ">=":
                if(n2 >= n1){
                    machine.runStack().push(1);
                }else {
                    machine.runStack().push(0);
                }
                break;

            case "<":
                if(n2 < n1){
                    machine.runStack().push(1);
                }else {
                    machine.runStack().push(0);
                }
                break;

            case "|":
                machine.runStack().push(n2 | n1);
                break;

            case "&":
                machine.runStack().push(n2 & n1);
                break;

            default:
                throw new IllegalArgumentException("Argument must be one of the following: + - / * == != <= > >= < | &");


        }
    }

    public String toString(){

        if(arguments!=null) {

            return "BOP " + arguments.get(0);
        }
        else return "BOP ";
    }

    public ArrayList<String> getArgs(){
        return arguments;
    }
}
