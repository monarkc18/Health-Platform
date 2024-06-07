package com.Lattice.Task.Entity;

public enum Symptom {
    ARTHRITIS(Speciality.ORTHOPEDIC),
    BACKPAIN(Speciality.ORTHOPEDIC),
    TISSUEINJURIES(Speciality.ORTHOPEDIC),
    DYSMENORRHEA(Speciality.GYNECOLOGY),
    SKININFECTION(Speciality.DERMATOLOGY),
    SKINBURN(Speciality.DERMATOLOGY),
    EARPAIN(Speciality.ENT);

    private final Speciality speciality;

    Symptom(Speciality speciality) {
        this.speciality = speciality;
    }

    public Speciality getSpeciality() {
        return this.speciality;
    }


}
