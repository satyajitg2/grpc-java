package com.sat.protobuf;

import com.sat.grpcmodels.GetTodoByIdRequest;
import com.sat.grpcmodels.Todo;
import com.sat.grpcmodels.TodoOrBuilder;
import com.sat.grpcmodels.TodoServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.util.Random;

public class TodoService extends TodoServiceGrpc.TodoServiceImplBase {
    @Override
    public void getTodo(GetTodoByIdRequest request, StreamObserver<Todo> responseObserver) {
        //super.getTodo(request, responseObserver); TODO: Find why this is for.

    }

    @Override
    public void getTodoStream(GetTodoByIdRequest request, StreamObserver<Todo> responseObserver) {
        //super.getTodoStream(request, responseObserver);
        Random rand = new Random();
        int id = rand.nextInt(100);
        while(id != -1) {
            Todo rohanIsGeneratingInJava = Todo.newBuilder()
                    .setId(id)
                    .setTitle("Rohan is generating in java")
                    .setCompleted(false)
                    .build();
            id = rand.nextInt(100);
            responseObserver.onNext(rohanIsGeneratingInJava);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
        responseObserver.onCompleted();
    }
}
