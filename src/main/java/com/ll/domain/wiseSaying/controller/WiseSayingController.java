package com.ll.domain.wiseSaying.controller;

import com.ll.domain.wiseSaying.entity.WiseSaying;
import com.ll.domain.wiseSaying.service.WiseSayingService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class WiseSayingController {
    private final Scanner scanner;
    private final WiseSayingService wiseSayingService;

    public WiseSayingController(Scanner scanner) {
        this.scanner = scanner;
        this.wiseSayingService = new WiseSayingService();
    }

    public void actionAdd() {
        System.out.print("명언 : ");
        String content = scanner.nextLine();
        System.out.print("작가 : ");
        String author = scanner.nextLine();

       //int id = ++lastId; //없음

        WiseSaying wiseSaying = wiseSayingService.addWiseSaying(content, author);

        System.out.println("%d번 명령이 등록되었습니다.".formatted(wiseSaying.getId()));
    }

    public void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        List<WiseSaying> wiseSayings = wiseSayingService.findAll();

        for (WiseSaying wiseSaying : wiseSayings.reversed()) {
            System.out.println("%d / %s / %s".formatted(wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getContent()));
        }

    }

    public void actionDelete(String cmd) {
        String idStr = cmd.substring(6);
        int id = Integer.parseInt(idStr);

        boolean removed = wiseSayingService.removeById(id);

        if (removed) System.out.println("%d번 명언을 삭제했습니다.".formatted(id));
        else System.out.println("%d번 명언은 존재하지 않습니다.".formatted(id));
    }

    public void actionModify(String cmd) {

        String idStr = cmd.substring(6);
        int id = Integer.parseInt(idStr);

        //WiseSaying foundWiseSaying = null; //없음

        Optional<WiseSaying> opWiseSaying = wiseSayingService.findById(id);

        //for (WiseSaying wiseSaying : wiseSayings) {
            //if (wiseSaying.getId() == id) {
                //foundWiseSaying = wiseSaying;
                //break;
            //}
        //}
        if (opWiseSaying.isEmpty()) {
            System.out.println("%d번 명언은 존재하지 않습니다.".formatted(id));
            return;
        }

        WiseSaying foundWiseSaying = opWiseSaying.get();

        System.out.println("명언(기존) : %s".formatted(foundWiseSaying.getContent()));
        System.out.print("명언 : ");
        String content = scanner.nextLine();

        System.out.println("작가(기존) : %s".formatted(foundWiseSaying.getAuthor()));
        System.out.print("작가 : ");
        String author = scanner.nextLine();

        //foundWiseSaying.setContent(content); //없음
        //foundWiseSaying.setAuthor(author); //없음

        wiseSayingService.modify(foundWiseSaying, content, author);

        System.out.println("%d번 명언이 수정되었습니다.".formatted(id));

    }



}
