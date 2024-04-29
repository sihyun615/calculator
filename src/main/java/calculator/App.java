package calculator;

import java.util.Objects;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        // Calculator 인스턴스 생성
        Calculator calculator = new Calculator();

        Scanner sc = new Scanner(System.in);


        while(true){  //무한루프
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = sc.nextInt();  //입력 정수 저장
            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = sc.nextInt();  //입력 정수 저장

            System.out.print("사칙연산 기호를 입력하세요: ");
            //next()의 반환값이 string이므로 charAt(0)으로 char로 바꾼후 0번째 char 반환
            char operator = sc.next().charAt(0);



            // Calculator 클래스의 calculate 메서드 호출
            try {
                int result = calculator.calculate(operator, num1, num2);
                System.out.println("결과 : " + result);
            } catch (Exception e) {  //예외처리
                System.out.println("오류: " + e.getMessage());
            }





            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
            if (Objects.equals(sc.next(), "remove")){  //입력받은 값이 "remove"이면
                calculator.removeResult();  // Calculator 클래스의 removeResult메서드 사용
            }


            System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
            if (Objects.equals(sc.next(), "inquiry")){  //입력받은 값이 "inquiry"이면
                calculator.inquiryResults();  // Calculator 클래스의 inquiryResults메서드 사용
            }


            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            if (Objects.equals(sc.next(), "exit")){  //입력받은 값이 "exit"이면 while문 종료
                break;
            }
        }

    }
}
