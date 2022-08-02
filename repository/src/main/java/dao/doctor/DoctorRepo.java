package dao.doctor;

import model.doctor.Doctor;
import java.util.ArrayList;
import java.util.List;

public class DoctorRepo implements DoctorRepoInterface<Doctor> {

    private final List<Doctor> doctors;

    public DoctorRepo() {
        this.doctors = new ArrayList<>();
    }

    @Override
    public void saveAll(List<Doctor> doctors) {
        this.doctors.addAll(doctors);
    }

    @Override
    public List<Doctor> findAll() {
        return doctors;
    }
}
