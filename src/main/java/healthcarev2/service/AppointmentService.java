package healthcarev2.service;

import healthcarev2.model.Appointment;
import healthcarev2.repository.AppointmentRepository;
import java.util.List;

public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public void createAppointment(Appointment appointment) {
        appointmentRepository.create(appointment);
    }

    public Appointment getAppointmentById(int id) {
        return appointmentRepository.findById(id);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public void updateAppointment(Appointment appointment) {
        appointmentRepository.update(appointment);
    }

    public void deleteAppointment(int id) {
        appointmentRepository.delete(id);
    }
}