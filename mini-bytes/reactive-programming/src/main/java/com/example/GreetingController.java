package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class GreetingController {

    @GetMapping("/api/greeting")
    public Mono<String> doGreeting() throws InterruptedException {
        return Mono
                .delay(Duration.ofSeconds(1))
                .map(v->{
                    return  "hello";
                });
    }

    @GetMapping(value="/api/greetings/async",produces = {"text/event-stream"})
    public Flux<String> doGreetingsAsync() throws InterruptedException {
        return  Flux
                .interval(Duration.ofSeconds(1))
                .map(i->i*i)
                .filter(i->i%2==0)
                .limitRate(10)
                .map(i->"hello-"+i);
    }

    @GetMapping(value="/api/greetings/sync",produces = {"text/event-stream"})
    public List<String> doGreetingsSync() throws InterruptedException {
        List<String> list=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            TimeUnit.SECONDS.sleep(1);
            String m="hello-"+i;
            list.add(m);
        }
        return  list;
    }

}
