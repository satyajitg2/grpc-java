package com.sat.protobuf;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class TodoServerFlutter {
    public static void main(String[] args) throws IOException, InterruptedException {
        int port = 8081;
        Server server = ServerBuilder.forPort(port)
                .addService(new TodoService())
                .build();

        server.start();
        System.out.println("Server Started on localhost: "+ port);
        server.awaitTermination();
    }
}
