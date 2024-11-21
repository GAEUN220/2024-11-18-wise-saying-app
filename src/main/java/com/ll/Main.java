package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
}

class App {
    List<wiseSaying> wiseSayings = new ArrayList<>(); // 리스트 생성

    public void run() {
        System.out.println("== 명언 앱 ==");

        Scanner scanner = new Scanner(System.in);

        int lastId = 0;

        while (true) {

            System.out.print("명령) ");
            String cmd = scanner.nextLine();

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                String content = scanner.nextLine();
                System.out.print("작가 : ");
                String author = scanner.nextLine();
                int id = ++lastId;

                wiseSayings.add(new wiseSaying(id, content, author)); // 리스트 추가

                System.out.println("%d번 명언이 등록되었습니다.".formatted(id)); // 출력
            } else if (cmd.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");

                for (int i = wiseSayings.size() - 1; i >= 0; i--) {
                    System.out.println(wiseSayings.get(i));
                }
            }
        }

        scanner.close();
    }
}

class wiseSaying {
    int id;
    String content;
    String author;

    wiseSaying(int id, String content, String author) {
        this.id =id;
        this.content = content;
        this.author = author;
    }

    @Override
    public String toString() { //여기는 public 붙여야함
        return id + " / " + author + " / " + content;
    }
}
