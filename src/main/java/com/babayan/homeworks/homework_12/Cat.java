package com.babayan.homeworks.homework_12;

import lombok.Value;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;

@Value
@Slf4j
public class Cat {

    String name;
    Queue<Mouse> stomach = new PriorityBlockingQueue<>(5, Comparator.comparingInt(Mouse::getKilocalories));

    public boolean eat(Mouse mouse) {
        log.debug("Call method eat(Mouse mouse) from " + this.getName());
        if (stomach.size() < 5) {
            return stomach.offer(mouse);
        } else return false;
    }

    public Queue<Mouse> getStomach() {
        log.debug("Call method getStomach() from " + this.getName());
        return new PriorityBlockingQueue<>(this.stomach);
    }

    public Mouse makePoop() {
        log.debug("Call method makePoop() from " + this.getName());
        return stomach.poll();
    }

    public Set<Mouse> acceleratePopping() {
        log.debug("Call method acceleratePopping() from " + this.getName());
        Set<Mouse> acceleratePopping = new HashSet<>(getStomach());
        stomach.clear();
        return acceleratePopping;
    }
}
