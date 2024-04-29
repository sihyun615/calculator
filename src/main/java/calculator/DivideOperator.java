package calculator;

public class DivideOperator implements Operator {
    @Override
    public double operate(int num1, int num2) {  //Operator 인터페이스를 구현
        return (double) num1 / num2;
    }
}
