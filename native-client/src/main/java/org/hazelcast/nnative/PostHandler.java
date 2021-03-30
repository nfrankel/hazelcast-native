package org.hazelcast.nnative;

import com.hazelcast.client.HazelcastClient;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public abstract class PostHandler<P extends WithId> implements Handler {

    private final String mapName;

    protected PostHandler(String mapName) {
        this.mapName = mapName;
    }

    @Override
    public void handle(@NotNull Context context) throws Exception {
        var client = HazelcastClient.getOrCreateHazelcastClient();
        var map = client.getMap(mapName);
        var name = context.pathParam("name");
        var person = create(name);
        map.put(person.getId(), person);
        context.json(person);
    }

    protected abstract P create(String name);
}
