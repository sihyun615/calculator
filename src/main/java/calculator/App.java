package calculator;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("첫 번째 숫자를 입력하세요: ");
        int num1 = sc.nextInt();  //입력 정수 저장
        System.out.print("두 번째 숫자를 입력하세요: ");
        int num2 = sc.nextInt();  //입력 정수 저장

        System.out.print("사칙연산 기호를 입력하세요: ");
        //next()의 반환값이 string이므로 charAt(0)으로 char로 바꾼후 0번째 char 반환
        char operator = sc.next().charAt(0);

    }
}
