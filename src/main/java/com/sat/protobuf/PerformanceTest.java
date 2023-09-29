package com.sat.protobuf;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.InvalidProtocolBufferException;
import com.sat.grpcmodels.Person;
import com.sat.json.JPerson;

public class PerformanceTest  {
    public static void main(String[] args) {

        JPerson person = new JPerson();
        person.setAge(45);
        person.setName("Anndn");

        ObjectMapper mapper = new ObjectMapper();



        //Json
        Runnable runnable = () -> {
            try {
                byte[] bytes = mapper.writeValueAsBytes(person);
                JPerson person1 = mapper.readValue(bytes, JPerson.class);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
        //protobuf
        Person personGrpc = Person.newBuilder()
                .setName("Anand")
                .setAge(45)
                .build();
        Runnable protoRunnable = () -> {
            try {
                byte[] bytes = personGrpc.toByteArray();
                Person person1 = personGrpc.getParserForType().parseFrom(bytes);
            } catch (InvalidProtocolBufferException e) {
                throw new RuntimeException(e);
            }
        };
        for (int i = 0; i < 5; i++) {
            runPerformanceTest(runnable, "JSON");
            runPerformanceTest(protoRunnable, "PROTO");
        }

    }

    private static void runPerformanceTest(Runnable runnable, String methodName) {
        long time = System.currentTimeMillis();
        for (int i=0; i < 5_000_000; i++){
            runnable.run();
        }
        long time1 = System.currentTimeMillis();
        System.out.println(methodName+ "    " + (time1 - time) + "ms");

    }
}
