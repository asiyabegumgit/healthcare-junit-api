package healthcarev2.repository;


import healthcarev2.model.Appointment;
import java.util.List;

public interface AppointmentRepository {
    void create(Appointment appointment);
    Appointment findById(int id);
    List<Appointment> findAll();
    void update(Appointment appointment);
    void delete(int id);
}