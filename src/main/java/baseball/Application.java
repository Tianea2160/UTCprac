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
            int ball=0;
            for(int i=0;i < len; i++){
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

    public static void question(Boolean flag, String ans, String val, Scanner scanner){
        if (print_res(val, ans)) {
            System.out.println("restart?(yes : 1, no : 2)");
            ans = scanner.next();
            if (ans.equals("1")) {
                flag = Boolean.FALSE;
            }
            else{
                flag  = Boolean.TRUE;
            }

        }
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        String ans = null;
        int val1 = 0;
        //random num make
        val1 = 100*RandomUtils.nextInt(1,9) + 10*RandomUtils.nextInt(1,9) + RandomUtils.nextInt(1,9);
//        String val = Integer.toString(val1);
        String val = "123";
        System.out.println();
        Boolean flag  = Boolean.TRUE;

        while(flag) {
            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                ans = scanner.next();
                //여기서 예외 처리 해야함
                ans_filter(ans, scanner);
                question(flag, ans, val, scanner);
                break;
            }
            System.out.println("");
        }
    }
}
