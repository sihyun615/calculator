package calculator;

import java.util.Objects;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        int[] results = new int[10];  //10개의 연산 결과들을 저장할 배열
        int idx = 0;  //배열 인덱스

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

            if (idx >= results.length){  //idx값이 배열길이10이상의 값을 가지면(여기서는 idx값 10이면)
                for (int i = 0; i < results.length - 1; i++) {
                    results[i] = results[i + 1];  //배열의 값을 하나씩 앞당겨서 저장
                }
                idx--;  //여기서는 idx값이 10에서 9가 될 것임
            }

            results[idx] = result;  //배열에 결과 저장
            idx++;  //인덱스 증가



            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String more = sc.next();  //더 계산할지말지 입력받기
            if (Objects.equals(more, "exit")){  //입력받은 값이 "exit"이면 while문 종료
                break;
            }
        }

    }
}
