package healthcarev2.repository;

import healthcarev2.model.Doctor;
import java.util.List;

public interface DoctorRepository {
    void create(Doctor doctor);
    Doctor findById(int id);
    List<Doctor> findAll();
    void update(Doctor doctor);
    void delete(int id);
}