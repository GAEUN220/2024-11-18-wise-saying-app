package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private final Scanner scanner;
    private int lastId;
    private final List<WiseSaying> wiseSayings;
    private int wiseSayingsSize;

    public App () {
        scanner = new Scanner(System.in);
        lastId = 0;
        wiseSayings = new ArrayList<>();
    }

    public void run() {
        System.out.println("== 명언 ==");


        while ( true ) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine();

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                actionAdd();

            } else if (cmd.equals("목록")) {
                actionList();

            } else if (cmd.startsWith("삭제")) {
                String idStr = cmd.substring(6);
                int id = Integer.parseInt(idStr);

                actionDelete(id);
            }

        }

        scanner.close();

    }

    private void actionAdd() {
        System.out.print("명언 : ");
        String content = scanner.nextLine();
        System.out.print("작가 : ");
        String author = scanner.nextLine();

        int id = ++lastId;

        WiseSaying wiseSaying = new WiseSaying(id, content, author);

        wiseSayings.add(wiseSaying);

        System.out.println("%d번 명령이 등록되었습니다.".formatted(id));
    }

    private void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        for (WiseSaying wiseSaying : wiseSayings.reversed()) {
            System.out.println("%d / %s / %s".formatted(wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getContent()));
        }

    }

    private void actionDelete(int id) {
        boolean removed = wiseSayings.removeIf(wiseSaying -> wiseSaying.getId() == id);

        if (removed) {
            System.out.println("%d번 명언을 삭제했습니다.".formatted(id));
        }
    }
}
