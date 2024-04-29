package calculator;

import java.util.ArrayList;

public class Calculator {
    /* 연산 결과를 저장하는 컬렉션 타입 필드 선언 (외부에서 직접접근 불가!)*/
    // ArrayList : 동적 배열이라 크기를 지정하지 않아도 됨
    private ArrayList<Integer> results;  //연산결과들 저장할 리스트
    private ArrayList<Double> areaResults;  //원넓이값들 저장할 리스트


    //static: 클래스 멤버 선언
    //final: 수정 불가
    //static final : 상수 (유일하며 불변인 값)
    static final double PI = 3.14;  //PI는 3.14로 고정된 값임



    // 생성자
    public Calculator(){
        this.results = new ArrayList<>(); // 연산 결과들을 저장할 리스트가 생성자 통해 초기화
        this.areaResults = new ArrayList<>(); // 원넓이값들을 저장할 리스트가 생성자 통해 초기화
    }


    /* 나눗셈에서 분모에 0이 들어오거나, 연산자 기호가 잘못 들어온 경우
      적합한 Exception 클래스를 생성하여 throw (매개변수로 해당 오류 내용을 전달)*/
    public int calculate(char operator, int num1, int num2) throws Exception {

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


        results.add(result);  //results리스트에 연산결과 추가

        return result;
    }


    // getter
    public ArrayList<Integer> getResults(){
        return results;
    }

    // setter
    public void setResults (ArrayList<Integer> results){
        this.results = results;
    }


    //가장 먼저 저장된 결과값 삭제 메서드
    public void removeResult() {
        if (!results.isEmpty()) {
            results.remove(0);  //가장 먼저 저장된 결과값 삭제 (인덱스 0번째)
            System.out.println("가장 먼저 저장된 결과가 삭제되었습니다.");
        } else {  //results리스트가 비어있으면
            System.out.println("저장된 결과가 없습니다.");
        }
    }


    //저장된 연산 결과들 조회 메서드
    public void inquiryResults() {
        for (int value : results) {  //향상된 for-each문
            System.out.println(value);  //저장된 연산결과들 출력
        }
    }





    //원의 넓이를 구하는 메서드
    public double calculateCircleArea (double radius) throws Exception {
        if (radius < 0){
            throw new BadInputException("원지름값");  //예외처리
        }

        double area = PI * radius * radius;
        areaResults.add(area);
        return area;
    }


    // getter
    public ArrayList<Double> getAreaResults(){
        return areaResults;
    }

    // setter
    public void setAreaResults (ArrayList<Double> areaResults){
        this.areaResults = areaResults;
    }


    //저장된 원넓이값들 조회 메서드
    public void inquiryAreaResults() {
        for (double value : areaResults) {  //향상된 for-each문
            System.out.println(value);  //저장된 연산결과들 출력
        }
    }
}


