package calculator;

import java.util.Objects;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        // Calculator클래스를 상속받은 두 클래스의 각각의 인스턴스 생성
        ArithmeticCalculator arithmeticCal = new ArithmeticCalculator(
                new AddOperator(), new SubtractOperator(), new MultiplyOperator(),
                new DivideOperator(), new ModOperator());
        CircleCalculator circleCal = new CircleCalculator();

        Scanner sc = new Scanner(System.in);


        while(true) {  //무한루프
            System.out.println("\n1. 사칙연산 진행");
            System.out.println("2. 원의 넓이 구하기");
            System.out.print("위의 메뉴 중 한 가지를 골라 숫자를 입력하세요: ");
            int menu = sc.nextInt();  //입력 정수 저장

            switch (menu) {
                case 1:  //1번 사칙연산 진행을 선택한 경우
                    System.out.print("\n첫 번째 숫자를 입력하세요: ");
                    int num1 = sc.nextInt();  //입력 정수 저장
                    System.out.print("두 번째 숫자를 입력하세요: ");
                    int num2 = sc.nextInt();  //입력 정수 저장

                    System.out.print("사칙연산 기호를 입력하세요: ");
                    //next()의 반환값이 string이므로 charAt(0)으로 char로 바꾼후 0번째 char 반환
                    char operator = sc.next().charAt(0);


                    // ArithmeticCalculator 클래스의 calculate 메서드 호출
                    try {
                        double result = arithmeticCal.calculate(operator, num1, num2);
                        System.out.println("결과 : " + result);
                    } catch (Exception e) {  //예외처리
                        System.out.println("오류: " + e.getMessage());
                    }


                    System.out.println("\n가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
                    if (Objects.equals(sc.next(), "remove")) {  //입력받은 값이 "remove"이면
                        arithmeticCal.removeResult();  // ArithmeticCalculator 클래스의 removeResult메서드 사용
                    }


                    System.out.println("\n저장된 연산결과들을 조회하시겠습니까? (inquiry 입력 시 조회)");
                    if (Objects.equals(sc.next(), "inquiry")) {  //입력받은 값이 "inquiry"이면
                        System.out.println("\n저장된 연산결과들을 조회합니다.");
                        arithmeticCal.inquiryResults();  //Calculator 클래스의 inquiryResults메서드 상속받아 사용
                    }

                    break;  //switch문에서 빠져나감




                case 2:  //2번 원의 넓이 구하기를 선택한 경우
                    System.out.print("\n원의 반지름을 입력하세요: ");
                    double radius = sc.nextDouble();  //입력 저장

                    // CircleCalculator 클래스의 calculateCircleArea 메서드 호출
                    try {
                        double areaResult = circleCal.calculateCircleArea(radius);
                        System.out.println("결과 : " + areaResult);
                    } catch (Exception e) {  //예외처리
                        System.out.println("오류: " + e.getMessage());
                    }


                    System.out.println("\n저장된 원의 넓이 값들을 조회합니다.");
                    circleCal.inquiryResults();  //Calculator 클래스의 inquiryResults메서드 상속받아 사용

                    break;  //switch문에서 빠져나감



                default:
                    System.out.println("잘못된 메뉴값을 입력하였습니다. 다시 입력하세요.\n");
                    continue;  //while문의 다음 반복으로 넘어감

            }



            System.out.println("\n더 계산하시겠습니까? (exit 입력 시 종료)");
            if (Objects.equals(sc.next(), "exit")) {  //입력받은 값이 "exit"이면 while문 종료
                break;  //while문에서 빠져나감
            }


        }
    }
}
