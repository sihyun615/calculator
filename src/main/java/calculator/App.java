package calculator;

import java.util.Objects;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        while(true){  //무한루프
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = sc.nextInt();  //입력 정수 저장
            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = sc.nextInt();  //입력 정수 저장

            System.out.print("사칙연산 기호를 입력하세요: ");
            //next()의 반환값이 string이므로 charAt(0)으로 char로 바꾼후 0번째 char 반환
            char operator = sc.next().charAt(0);


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
                    if (num2 == 0){
                        System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                    }
                    else {
                        result = num1 / num2;
                    }
                    break;
                default :
                    System.out.println("잘못된 연산자입니다.");
                    return;
            }

            if(operator!='/' || num2!=0){  //나눗셈 연산에서 분모(두번째 정수)가 0인 경우 result 출력X!
                System.out.println("결과: " + result);
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String more = sc.next();  //더 계산할지말지 입력받기
            if (Objects.equals(more, "exit")){  //입력받은 값이 "exit"이면 while문 종료
                break;
            }
        }


    }
}
