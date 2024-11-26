package com.ll.domain.wiseSaying.repository;

import com.ll.domain.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WiseSayingMemoryRepository extends WiseSayingRepository {
    private int lastId;
    private final List<WiseSaying> wiseSayings;

    public WiseSayingMemoryRepository() {
        this.wiseSayings = new ArrayList<>();
        this.lastId = 0;
    }

    public void add(WiseSaying wiseSaying) {
        wiseSaying.setId(++lastId);
        wiseSayings.add(wiseSaying);
    }

    public List<WiseSaying> findAll() {
        return wiseSayings;
    }

    public boolean removeById(int id) {
        return wiseSayings.removeIf(e -> e.getId() == id);
    }

    public Optional<WiseSaying> findById(int id) {
        return wiseSayings.stream()
                .filter(e -> e.getId() == id)
                .findFirst();
    }

    public void modify(WiseSaying wiseSaying) {

    }

}
