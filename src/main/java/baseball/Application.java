package baseball;

import utils.RandomUtils;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        String ans;
        BaseBall baseBall;
        do {
            baseBall = new BaseBall();
            do {
                System.out.print("숫자를 입력해주세요 : ");git
                ans = scanner.next();
                baseBall.AnsFilter(ans, scanner);
            } while (!baseBall.compare(ans));
        } while (baseBall.askRestart(scanner));
    }
}
