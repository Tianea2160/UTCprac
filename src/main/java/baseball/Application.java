package baseball;

import utils.RandomUtils;
import java.util.Scanner;

public class Application {
    public static boolean print_res(String val, String pred){
        if(val.equals(pred)){
            System.out.println("3 strike");
            return true;
        }else{
            //strike, ball 찾기
            int len = val.length();
            int strike = 0;
            int ball = 0;
            for(int i = 0;i < len; i++){
                if(Character.toString(val.charAt(i)).equals(Character.toString(pred.charAt(i)))) strike++;
                if(val.contains(Character.toString(pred.charAt(i)))) ball++;
            }
            ball-=strike;
            if(ball ==0 && strike == 0) {
                System.out.println("nothing");
            }else{
                System.out.println("strike : " + strike + ", ball : " + ball + "\n");
            }
            return false;
        }
    }
    public static void ans_filter(String ans, Scanner scanner){
        while (ans.length() != 3) {
            System.out.println("다시 입력하세요");
            ans = scanner.next();
        }
    }
    //너무 절차지향적으로 코딩되어 있음 이부분을 나중에 좀더 좋은 방법으로 수정하고 싶음
    public static Boolean question(String ans, String val, Scanner scanner){
        if (print_res(val, ans)) {
            System.out.println("restart?(yes : 1, no : 2)");
            ans = scanner.next();
            if (ans.equals("1")) return Boolean.TRUE;
            else return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
    //랜덤 변수 만들기 함수
    private static int make_val(){
        int val = 0;
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        while(num1 ==num2 || num2 == num3 || num3 == num1){
            num1 = RandomUtils.nextInt(1,9);
            num2 = RandomUtils.nextInt(1,9);
            num3 = RandomUtils.nextInt(1,9);
        }
        val = num1*100 + num2*10 + num3;
        return val;
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        String ans;
        int val1;
        //random num make
        val1 = make_val();
        String val = Integer.toString(val1);
        System.out.println();
        Boolean flag = Boolean.TRUE;

        while(flag) {
            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                ans = scanner.next();
                ans_filter(ans, scanner);
                flag = question(ans, val, scanner);
                break;
            }
        }
    }
}
