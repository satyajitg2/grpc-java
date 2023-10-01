package com.sat.protobuf;

import com.sat.grpcmodels.Address;
import com.sat.grpcmodels.Car;
import com.sat.grpcmodels.Person;

import java.util.ArrayList;
import java.util.List;

public class CompositeClass {
    public static void main(String[] args) {
        Address address = Address.newBuilder()
                .setCity("Kolkata")
                .setStreet("RusselStreet")
                .setPostbox(712233)
                .build();
        Car car = Car.newBuilder()
                .setMake("Toyota")
                .setModel("Yaris")
                .setYear(2005)
                .build();
        Car car2 = Car.newBuilder()
                .setMake("Toyota")
                .setModel("Camry")
                .setYear(2023)
                .build();
        List<Car> carList = new ArrayList<>();
        carList.add(car);
        carList.add(car2);

        Person person = Person.newBuilder()
                .setAddress(address)
                //.addAllCar(carList) //or set a list
                .addCar(car)
                .addCar(car2)
                .setName("Rohan")
                .setAge(34)
                .build();

        System.out.println(person);
    }
}
