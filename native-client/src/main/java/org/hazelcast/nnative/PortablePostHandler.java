package org.hazelcast.nnative;

public class PortablePostHandler extends PostHandler<PortablePerson> {

    protected PortablePostHandler() {
        super("portable");
    }

    @Override
    protected PortablePerson create(String name) {
        return new PortablePerson(name);
    }
}
