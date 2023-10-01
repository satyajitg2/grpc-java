package com.sat.protobuf;

import com.sat.grpcmodels.Address;
import com.sat.grpcmodels.Car;
import com.sat.grpcmodels.Dealer;
import com.sat.grpcmodels.Person;

import java.util.ArrayList;
import java.util.List;

public class MapProto {
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
        Dealer dealer = Dealer.newBuilder()
                .putModel(1,car)
                .putModel(2, car2)
                .build();


        List<Car> carList = new ArrayList<>();
        carList.add(car);
        carList.add(car2);

        dealer.getModelCount();
        System.out.println(dealer.getModelMap());
        System.out.println(
            dealer.getModelOrThrow(1).getBodyStyle()
        );
    }
}
