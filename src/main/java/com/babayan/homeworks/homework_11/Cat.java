package com.babayan.homeworks.homework_11;

import lombok.Value;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

@Value
@Slf4j
public class Cat {

    String name;
    BlockingDeque<Mouse> stomach = new LinkedBlockingDeque<>(5);

    public boolean eat(Mouse mouse) {
        log.info("Call method eat(Mouse mouse) from " + this.getName());
        return stomach.offer(mouse);
    }

    public BlockingDeque<Mouse> getStomach() {
        log.info("Call method getStomach() from " + this.getName());
        return new LinkedBlockingDeque<>(this.stomach);
    }

    public Mouse makePoop() {
        log.info("Call method makePoop() from " + this.getName());
        return stomach.poll();
    }

    public HashSet<Mouse> acceleratePopping() {
        log.info("Call method acceleratePopping() from " + this.getName());
        BlockingDeque<Mouse> tempStomach = getStomach();
        stomach.clear();
        return new HashSet<>(tempStomach);
    }
}
