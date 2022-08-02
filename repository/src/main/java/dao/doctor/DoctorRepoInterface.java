package dao.doctor;
import java.util.List;

public interface DoctorRepoInterface<T> {
    void saveAll(List<T> list);
    List<T> findAll();
}
