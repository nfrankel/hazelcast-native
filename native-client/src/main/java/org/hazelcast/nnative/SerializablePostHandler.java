package org.hazelcast.nnative;

public class SerializablePostHandler extends PostHandler<SerializablePerson> {

    protected SerializablePostHandler() {
        super("serializable");
    }

    @Override
    protected SerializablePerson create(String name) {
        return new SerializablePerson(name);
    }
}
