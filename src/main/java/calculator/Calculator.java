package calculator;

import java.util.ArrayList;

public class Calculator {
    /* 연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성 */
    // ArrayList : 동적 배열이라 크기를 지정하지 않아도 됨
    ArrayList<Integer> results = new ArrayList<>(); // 연산 결과들을 저장할 리스트


    /* 나눗셈에서 분모에 0이 들어오거나, 연산자 기호가 잘못 들어온 경우
      적합한 Exception 클래스를 생성하여 throw (매개변수로 해당 오류 내용을 전달)*/
    public int calculate(char operator, int num1, int num2) throws Exception {
        /* 위 요구사항에 맞게 구현 */
        /* return 연산 결과 */
        int result = 0;
        switch (operator) {  //operator의 종류 : +,-,*,/
            case '+' :
                result = num1 + num2;
                break;
            case '-' :
                result = num1 - num2;
                break;
            case '*' :
                result = num1 * num2;
                break;
            case '/' :
                if (num2 == 0){  //분모값으로 0이 입력된 경우 예외클래스로 throw
                    throw new BadInputException("분모값");  //예외처리
                }

                result = num1 / num2;
                break;
            default :  //잘못된 연산자값이 입력된 경우 예외클래스로 throw
                throw new BadInputException("연산자값");  //예외처리
        }


        System.out.println("결과: " + result);
        results.add(result);  //results리스트에 연산결과 추가

        return result;
    }

}
