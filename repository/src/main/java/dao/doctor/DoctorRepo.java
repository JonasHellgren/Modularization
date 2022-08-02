package dao.doctor;

import model.doctor.Doctor;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

public class DoctorRepo implements DoctorRepoInterface<Doctor> {

    private  List<Doctor> doctors;

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
