package org.hazelcast.nnative;

import com.hazelcast.core.Hazelcast;

public class Server {

    public static void main(String[] args) {
        Hazelcast.newHazelcastInstance();
    }
}
