package calculator;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        // ArrayList : 동적 배열이라 크기를 지정하지 않아도 됨
        ArrayList<Integer> results = new ArrayList<>(); // 연산 결과들을 저장할 리스트

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
                        continue; // 다음 반복으로 넘어감
                    }

                    result = num1 / num2;
                    break;
                default :
                    System.out.println("잘못된 연산자입니다.");
                    continue; // 다음 반복으로 넘어감
            }


            System.out.println("결과: " + result);
            results.add(result);  //results리스트에 연산결과 추가


            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
            if (Objects.equals(sc.next(), "remove")){  //입력받은 값이 "remove"이면
                if (!results.isEmpty()) {
                    results.remove(0);  //가장 먼저 저장된 결과값 삭제 (인덱스 0번째)
                    System.out.println("가장 먼저 저장된 결과가 삭제되었습니다.");
                } else {  //results리스트가 비어있으면
                    System.out.println("저장된 결과가 없습니다.");
                }
            }


            System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
            if (Objects.equals(sc.next(), "inquiry")){  //입력받은 값이 "inquiry"이면
                for (int value : results) { // 저장된 연산결과들 출력
                    System.out.println(value);
                }
            }


            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            if (Objects.equals(sc.next(), "exit")){  //입력받은 값이 "exit"이면 while문 종료
                break;
            }
        }

    }
}
