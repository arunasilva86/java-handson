package com.learn.example.reactive;

import com.learn.example.reactive.common.DefaultSubscriber;
import lombok.AllArgsConstructor;
import lombok.Data;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class SlackRoomAssignmentDemo {

//    private static AtomicInteger atomicInteger = new AtomicInteger(0);
//    private static Sinks.Many<Message> messageSink = Sinks.many().replay().all();

    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger(0);
        SlackRoom slackRoom = new SlackRoom("Reactive Discussions");

        List<SlackUser> slackUsers = List.of(new SlackUser(0 ,"Aruna"), new SlackUser(1, "Ishara"), new SlackUser(2, "Sanjaya"));
        slackUsers.stream().forEach(slackRoom::subscribeTOSlackRoom); // log in to slack room to receive messages
        List.of(1, 2, 3, 4, 5, 6, 7, 8, 9).stream()
                .map(integer -> integer % 3)
                .forEach(integer ->  {
                    SlackUser slackUser = slackUsers.get(integer);
                    slackRoom.sendMessage(new Message(" message sent by " + slackUser.getName() + " - " + atomicInteger.getAndIncrement()));
                });
    }


}
@Data
class SlackRoom  {

    private String name;
    private static Sinks.Many<Message> messageSink = Sinks.many().replay().all();

    public void subscribeTOSlackRoom (SlackUser slackUser) {
        messageSink.asFlux().subscribe(new DefaultSubscriber(slackUser.getName()));

    }

    public void sendMessage (Message message) {
        messageSink.emitNext(message, (signalType, emitResult) -> true);

    }

    public SlackRoom(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

@Data @AllArgsConstructor
class Message {
    private String content;

    @Override
    public String toString() {
        return content;
    }
}


@Data @AllArgsConstructor
class SlackUser {

    private int id;
    private String name;


}
