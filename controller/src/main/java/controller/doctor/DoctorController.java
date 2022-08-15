package controller.doctor;

import model.doctor.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import service.doctor.DoctorService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DoctorController implements ErrorController {

    @Autowired
    private DoctorService service;

    @GetMapping ("/doctors")
    public List<Doctor> getDoctors() {
        System.out.println("doctors");


        List<String> doctorList= service.getDoctors().stream().
                map(d -> d.toString()).collect(Collectors.toList());


        return service.getDoctors();
    }

   // private final static String PATH = "/error";
   // @Override
   // @RequestMapping(PATH)
   // @ResponseBody
    public String getErrorPath() {
        return "No Mapping Found";
    }
}
