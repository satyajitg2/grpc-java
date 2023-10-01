package com.sat.protobuf;

import com.sat.postgresdb.PostGresDb;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.sql.Connection;

public class TodoServerFlutter {
    private static final String ASTRA_DB_ID      = "a285da74-1e6a-4021-a1d1-d528f311464d";
    private static final String ASTRA_DB_REGION  = "asia-south1";
    private static final String ASTRA_DB_TOKEN      = "AstraCS:CTgOJmbvxwzCYfDsizsNAAWk:f6f119df118dbd306698ecda04f722d6a169df68682d2babd15b326778fe945c";
    private static final String ASTRA_KEYSPACE   = "stargate"; //stargate, y_keyspace

    public static void main(String[] args) throws IOException, InterruptedException {
        int port = 8081;

        PostGresDb app = new PostGresDb();
        app.getAllUsers();

        Server server = ServerBuilder.forPort(port)
                .addService(new TodoService())
                .build();

        server.start();
        System.out.println("Server Started on localhost: "+ port);
        server.awaitTermination();
    }

}
