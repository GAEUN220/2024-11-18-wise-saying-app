package com.ll;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
}

class App {
    public void run() {
        System.out.println("== 명언 앱==");

        Scanner scanner = new Scanner(System.in);

        while ( true ) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine();
            if (cmd.equals("등록"))
                break;
        }

        while ( true ) {
            System.out.print("명언 : ");
            String cmd2 = scanner.nextLine();
            if (cmd2.equals("현재를 사랑하라."))
            break;
        }

        while ( true ) {
            System.out.print("작가 : ");
            String cmd3 = scanner.nextLine();
            if (cmd3.equals("작자미상"))
            break;
        }

        System.out.println("1번 명언이 등록되었습니다.");

        while ( true ) {
            System.out.print("명령) ");
            String cmd4 = scanner.nextLine();
            if (cmd4.equals("종료"))
            break;
        }

        scanner.close();
    }
}