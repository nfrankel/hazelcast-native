package org.hazelcast.nnative;

import com.hazelcast.client.HazelcastClient;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class GetHandler implements Handler {

    private final String mapName;

    protected GetHandler(String mapName) {
        this.mapName = mapName;
    }

    @Override
    public void handle(@NotNull Context context) {
        var client = HazelcastClient.getOrCreateHazelcastClient();
        var map = client.getMap(mapName);
        var entries = map.entrySet();
        context.json(entries);
    }
}
