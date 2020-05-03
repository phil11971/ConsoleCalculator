package com.company;

import com.company.exceptions.IncompatibleOperandsException;
import com.company.exceptions.InvalidOperandException;

public class Calculator {
    boolean isRoman;
    static Calculator calculator;
    Validator validator;

    private Calculator() {
        validator = Validator.getInstance();
    }

    public static Calculator getInstance(){
        if(calculator == null)
            calculator = new Calculator();
        return calculator;
    }

    public String executeOperation(String string) throws InvalidOperandException, IncompatibleOperandsException, ArithmeticException, Exception {
        if(validator.validate(string)){

            String[] strs = string.split(" ");

            Integer operandOne = validator.getOperand(strs[0]);
            Integer operandTwo = validator.getOperand(strs[2]);
            char operation = validator.getOperation(strs[1]);

            if(operandOne == null && operandTwo == null)
            {
                isRoman = true;
                operandOne = Roman.toInt(strs[0]);
                operandTwo = Roman.toInt(strs[2]);
            }

            int res = 0;

            switch(operation){
                case '+':
                    res = operandOne + operandTwo;
                    break;
                case '-':
                    res = operandOne - operandTwo;
                    break;
                case '*':
                    res = operandOne * operandTwo;
                    break;
                case '/':
                    res = operandOne / operandTwo;
                    break;
            }

            if(isRoman){
                isRoman = !isRoman;
                String resu = Roman.toRoman(res);
                return resu != null ? resu : Integer.toString(res);
            }

            return Integer.toString(res);
        }
        else throw new Exception("Unknown exception of validation");
    }
}