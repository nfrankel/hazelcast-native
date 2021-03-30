package org.hazelcast.nnative;

import io.javalin.Javalin;

import java.util.Optional;

import static io.javalin.apibuilder.ApiBuilder.*;

public class Client {

    public static void main(String[] args) {
        var port = Optional.ofNullable(System.getenv("HZ_PORT"))
                .map(Integer::valueOf)
                .orElse(8080);
        Javalin.create()
                .routes(() -> path("serializable", () -> {
                    get(new GetHandler("serializable"));
                    path(":name", () -> post(new SerializablePostHandler()));
                }))
                .routes(() -> path("portable", () -> {
                    get(new GetHandler("portable"));
                    path(":name", () -> post(new PortablePostHandler()));
                }))
                .start(port);
    }
}
