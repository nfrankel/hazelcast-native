package org.hazelcast.nnative;

import com.hazelcast.nio.serialization.Portable;
import com.hazelcast.nio.serialization.PortableReader;
import com.hazelcast.nio.serialization.PortableWriter;

import java.io.IOException;
import java.util.UUID;

public class PortablePerson implements Portable, WithId {

    private UUID id;
    private String name;

    public PortablePerson() {}

    public PortablePerson(String name) {
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

    @Override
    public int getFactoryId() {
        return 1;
    }

    @Override
    public int getClassId() {
        return 1;
    }

    @Override
    public void writePortable(PortableWriter writer) throws IOException {
        writer.writeCharArray("uuid", id.toString().toCharArray());
        writer.writeCharArray("name", name.toCharArray());
    }

    @Override
    public void readPortable(PortableReader reader) throws IOException {
        id = UUID.fromString(new String(reader.readCharArray("uuid")));
        name = new String(reader.readCharArray("name"));
    }
}
