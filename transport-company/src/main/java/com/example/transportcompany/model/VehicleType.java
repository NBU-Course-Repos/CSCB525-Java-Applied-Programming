package com.example.transportcompany.model;

public enum VehicleType {
    BUS(Specialisation.COMMERCIAL),
    TRUCK(Specialisation.DEFAULT),
    TANKER(Specialisation.FLAMMABLE),
    VAN(Specialisation.DEFAULT),
    OVERSIZE_TRUCK(Specialisation.OVERSIZE_LOAD);

    VehicleType(Specialisation requirement) {

    }
}
