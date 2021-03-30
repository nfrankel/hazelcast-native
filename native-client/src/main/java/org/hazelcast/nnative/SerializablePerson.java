package org.hazelcast.nnative;

import java.io.Serializable;
import java.util.UUID;

public class SerializablePerson implements Serializable, WithId {

    private UUID id;
    private String name;

    public SerializablePerson(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
