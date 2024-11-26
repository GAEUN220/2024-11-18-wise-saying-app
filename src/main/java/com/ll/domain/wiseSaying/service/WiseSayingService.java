package com.ll.domain.wiseSaying.service;

import com.ll.domain.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class WiseSayingService {
    private int lastId;
    private final List<WiseSaying> wiseSayings;


    public WiseSayingService() {
        this.lastId = 0;
        this.wiseSayings = new ArrayList<>();
    }

    public WiseSaying addWiseSaying(String content, String author) {
        int id = ++lastId;

        WiseSaying wiseSaying = new WiseSaying(id, content, author);

        wiseSayings.add(wiseSaying);

        return wiseSaying;
    }

    public List<WiseSaying> findAll() {
        return wiseSayings;
    }

    public boolean removeById(int id) {
        return wiseSayings.removeIf(wiseSaying -> wiseSaying.getId() == id);
    }

    public Optional<WiseSaying> findById(int id) {
        return wiseSayings.stream()
                .filter(e -> e.getId() == id)
                .findFirst();
    }

    public void modify(WiseSaying foundWiseSaying, String content, String author) {
        foundWiseSaying.setContent(content);
        foundWiseSaying.setAuthor(author);
    }

}
