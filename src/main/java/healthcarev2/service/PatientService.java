package healthcarev2.service;

import healthcarev2.model.Patient;
import healthcarev2.repository.PatientRepository;
import java.util.List;

public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public void createPatient(Patient patient) {
        patientRepository.create(patient);
    }

    public Patient getPatientById(int id) {
        return patientRepository.findById(id);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public void updatePatient(Patient patient) {
        patientRepository.update(patient);
    }

    public void deletePatient(int id) {
        patientRepository.delete(id);
    }
}