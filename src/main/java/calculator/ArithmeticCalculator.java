package calculator;

public class ArithmeticCalculator extends Calculator {  // Calculator클래스를 상속받음

    // Operator 인터페이스
    private final Operator addOperator;
    private final Operator subtractOperator;
    private final Operator multiplyOperator;
    private final Operator divideOperator;
    private final Operator modOperator;


    // ArithmeticCalculator 생성자를 통해 사칙연산 클래스들 초기화
    public ArithmeticCalculator(Operator addOperator,
                                Operator subtractOperator,
                                Operator multiplyOperator,
                                Operator divideOperator,
                                Operator modOperator){

        this.addOperator = addOperator;
        this.subtractOperator = subtractOperator;
        this.multiplyOperator = multiplyOperator;
        this.divideOperator = divideOperator;
        this.modOperator = modOperator;
    }


    /* 나눗셈에서 분모에 0이 들어오거나, 연산자 기호가 잘못 들어온 경우
      적합한 Exception 클래스를 생성하여 throw (매개변수로 해당 오류 내용을 전달)*/
    public double calculate(char operator, int num1, int num2) throws Exception {

        double result = 0;
        switch (operator) {  //operator의 종류 : +,-,*,/
            case '+' :
                result = addOperator.operate(num1,num2);
                break;
            case '-' :
                result = subtractOperator.operate(num1,num2);
                break;
            case '*' :
                result = multiplyOperator.operate(num1,num2);
                break;
            case '/' :
                if (num2 == 0){  //분모값으로 0이 입력된 경우 예외클래스로 throw
                    throw new BadInputException("분모값");  //예외처리
                }
                result = divideOperator.operate(num1,num2);
                break;
            case '%' :
                if (num2 == 0){  //분모값으로 0이 입력된 경우 예외클래스로 throw
                    throw new BadInputException("나누는 값");  //예외처리
                }
                result = modOperator.operate(num1,num2);
                break;
            default :  //잘못된 연산자값이 입력된 경우 예외클래스로 throw
                throw new BadInputException("연산자값");  //예외처리
        }

        saveResults.add(result);  // Calculator클래스의 saveResults리스트에 연산결과 추가

        return result;
    }



    //가장 먼저 저장된 결과값 삭제 메서드
    public void removeResult() {
        if (!saveResults.isEmpty()) {
            saveResults.remove(0);  // Calculator클래스의 saveResults리스트에서 값 삭제
            System.out.println("가장 먼저 저장된 결과가 삭제되었습니다.");
        } else {  //saveResults리스트가 비어있으면
            System.out.println("저장된 결과가 없습니다.");
        }
    }

}
