package com.learn.example.reactive;

import com.learn.example.reactive.common.DefaultSubscriber;
import com.learn.example.reactive.common.Util;
import lombok.Data;
import lombok.ToString;
import reactor.core.publisher.Flux;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlatMapDemo {

//    use flatmap when you get a flux/mono in a pipeline while processing a flux/mono

    public static void main(String[] args) {
        UserService.getUsers()
                .filter(user -> user.getUserId() < 4) // since we have just 3 users added in userDb
                .flatMap(user -> OrderService.getOrderFluxOfaGivenUserId(user.getUserId())) // getOrderFluxOfaGivenUserId returns a Flux of orders than an order. so we need to flatten the flux with flatmap
                .filter(order -> Double.parseDouble(order.getPrice()) < 60 )
                .subscribe(new DefaultSubscriber());
    }

}

@Data
@ToString
class User {
    private int userId;
    private String name;

    public User (int userId) {

        this.userId = userId;
        this.name = Util.faker.name().firstName();
    }



}

@Data
@ToString
class Order {
    private String item;
    private String price;
    private int userId;

    public Order (int userId) {
        this.userId = userId;
        this.price = Util.faker.commerce().price();
        this.item = Util.faker.commerce().productName();

    }

}

class OrderService {

    public static Map<Integer, List<Order>> orderDb = new HashMap<>();
    static {
        orderDb.put(1, List.of(new Order(1), new Order(1), new Order(1)));
        orderDb.put(2, List.of(new Order(2), new Order(2), new Order(2)));
        orderDb.put(3, List.of(new Order(3), new Order(3), new Order(3)));

    }

    public static Flux<Order> getOrderFluxOfaGivenUserId(Integer userId) {
        return Flux.create(fluxSink -> {
            orderDb.get(userId).forEach(fluxSink::next);
            fluxSink.complete();
        });

    }

}

class UserService {

    public static Flux<User> getUsers () {
        return Flux.just(new User(1), new User(2), new User(3), new User(4));

    }

}