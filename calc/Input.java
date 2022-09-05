package calc;

class Input {
    private final Number firstOperand;
    private final Number secondOperand;
    private final String operator;

    Input (Number firstOperand, Number secondOperand, String operator){
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.operator = operator;
    }

    public Number getFirstOperand (){
        return firstOperand;
    };
    public Number getSecondOperand (){
        return secondOperand;
    };
    public String getOperator (){
        return operator;
    };
}
