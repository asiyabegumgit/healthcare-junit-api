package healthcarev2.repository;


import healthcarev2.model.Patient;
import java.util.List;

public interface PatientRepository {
    void create(Patient patient);
    Patient findById(int id);
    List<Patient> findAll();
    void update(Patient patient);
    void delete(int id);
}