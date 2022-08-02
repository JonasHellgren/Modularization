package service.doctor;

import dao.doctor.DoctorRepo;
import dao.doctor.DoctorRepoInterface;
import mailservice.EmailService;
import model.doctor.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DoctorService {

    private DoctorRepoInterface<Doctor> repo;

    @Autowired
    private EmailService emailService;

    @PostConstruct
    public void initDoctorService() {

        repo=new DoctorRepo();
        System.out.println("initDoctorService");
        repo.saveAll(Stream.of(
                new Doctor(101,"John","Specialist"),
                new Doctor(121,"Johan","Cardiac")).
                collect(Collectors.toList())
        );
    }

    public List<Doctor> getDoctors() {
        emailService.sendEmail();
        return repo.findAll();
        //return Collections.emptyList();
    }

}
