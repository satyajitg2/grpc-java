package com.sat.protobuf;

import com.sat.grpcmodels.Person;

public class PersonDemo {
    public static void main(String[] args) {

        Person anand = Person.newBuilder()
                .setName("Anand")
                .setAge(45)
                .build();
        System.out.println(anand.toString());

    }
}
