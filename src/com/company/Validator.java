package com.company;

import com.company.exceptions.IncompatibleOperandsException;
import com.company.exceptions.InvalidOperandException;
import com.company.exceptions.InvalidOperationException;
import com.company.exceptions.InvalidStringException;
import org.apache.commons.validator.routines.IntegerValidator;

public class Validator {
    static Validator validator;
    IntegerValidator integerValidator = IntegerValidator.getInstance();

    private Validator() {}

    public static Validator getInstance(){
        if(validator == null)
            validator = new Validator();
        return validator;
    }

    public boolean validate(String string) throws InvalidOperandException, InvalidOperationException, IncompatibleOperandsException, InvalidStringException {
        String[] strs = string.split(" ");

        if(strs.length == 3) {
            Integer operandOne = validator.getOperand(strs[0]);
            Integer operandTwo = validator.getOperand(strs[2]);
            Character operation = validator.getOperation(strs[1]);

            if (operation != null) {
                if (operandOne == null && operandTwo == null) {
                    operandOne = Roman.toInt(strs[0]);
                    operandTwo = Roman.toInt(strs[2]);
                } else if (operandOne != null && operandTwo == null || operandOne == null && operandTwo != null)
                    throw new IncompatibleOperandsException("Incompatible operands");
            }

            return operandOne != null && operandTwo != null && operation != null;
        }
        else throw new InvalidStringException("Invalid String");

    }

    public Integer getOperand(String string) throws InvalidOperandException {
        Integer operand = integerValidator.validate(string);
        if(operand != null && operand >= 1 && operand <= 10)
            return operand;
        else if(operand != null && (operand < 1 || operand > 10))
            throw new InvalidOperandException("Operand must be from 1 to 10");
        return null;
    }


    public Character getOperation(String string) throws InvalidOperationException {
        if(string.length() == 1){
            char operation = string.charAt(0);
            if(operation == '+' || operation == '-' || operation == '*' || operation == '/')
                return operation;
            else throw new InvalidOperationException("Invalid operation");
        }
        else throw new InvalidOperationException("Invalid operation");
    }
}
