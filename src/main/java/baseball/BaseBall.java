package baseball;

import utils.RandomUtils;

import java.util.Scanner;

public class BaseBall {
    private String RandomNum;

    public BaseBall() {
        int num1 = 0, num2 = 0, num3 = 0;
        while (num1 == num2 || num2 == num3 || num1 == num3) {
            num1 = RandomUtils.nextInt(1, 9);
            num2 = RandomUtils.nextInt(1, 9);
            num3 = RandomUtils.nextInt(1, 9);
        }
        RandomNum = Integer.toString(num1 * 100 + num2 * 10 + num3);
    }

    public String getRandomNum() {
        return RandomNum;
    }


    public boolean compare(String num){
        int strike = 0, ball = 0, len = num.length();
        //3개 모두 같은 경우
        if(num.equals(RandomNum)){
            System.out.println("3 strike");
            return true;
        }
        for(int i = 0;i < len; i++){
            if(Character.toString(RandomNum.charAt(i)).equals(Character.toString(num.charAt(i)))) strike++;
            if(RandomNum.contains(Character.toString(num.charAt(i)))) ball++;
        }
        ball-=strike;
        if(ball ==0 && strike == 0) {
            System.out.println("nothing");
        }else{
            System.out.println("strike : " + strike + ", ball : " + ball + "\n");
        }
        return false;
    }

    public boolean askRestart(Scanner scanner){
        String ans;
        System.out.println("restart?(yes : 1, no : 2)");
        ans = scanner.next();
        if (ans.equals("1")) return true;
        else return false;
    }
    public void AnsFilter(String ans, Scanner scanner) {
        while (ans.length() != 3) {
            System.out.println("다시 입력하세요");
            ans = scanner.next();
        }
    }

}
