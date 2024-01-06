package com.example.transportcompany.persistence.model;

/**
 * Enum, the available vehicle types and the {@link Specialisation} required for each
 */
public enum VehicleType {
    BUS(Specialisation.COMMERCIAL),
    TRUCK(Specialisation.DEFAULT),
    TANKER(Specialisation.FLAMMABLE),
    VAN(Specialisation.DEFAULT),
    OVERSIZE_TRUCK(Specialisation.OVERSIZE_LOAD);

    VehicleType(Specialisation requirement) {

    }
}
