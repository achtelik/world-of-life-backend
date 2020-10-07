package it.achtelik.worldoflife.usecases.world.entrypoints.rest;

import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.DirectProcessor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxProcessor;
import reactor.core.publisher.FluxSink;

@RestController
public class TestController {

    final FluxProcessor processor;
    final FluxSink sink;

    public TestController() {
        this.processor = DirectProcessor.create().serialize();
        this.sink = processor.sink();
    }

    @GetMapping(value = "/test", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<ServerSentEvent> getTest() {
        return processor.map(e -> ServerSentEvent.builder(e).build());
    }

    @GetMapping("/test2")
    void putTest() {
        sink.next((int) (Math.random() * 1000));
    }
}
