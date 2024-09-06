package healthcarev2.service;

import healthcarev2.impl.DoctorRepositoryImpl;
import healthcarev2.impl.OfficeRepositoryImpl;
import healthcarev2.model.Doctor;
import healthcarev2.model.Office;
import healthcarev2.repository.DoctorRepository;
import healthcarev2.repository.OfficeRepository;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;



class OfficeServiceTest {
    private OfficeService officeService;
    private DoctorService doctorService;
    private SessionFactory sessionFactory;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        sessionFactory = new Configuration().configure("hibernate-test.cfg.xml").buildSessionFactory();
        OfficeRepository officeRepository=new OfficeRepositoryImpl(sessionFactory);
        officeService=new OfficeService(officeRepository);

        DoctorRepository doctorRepository=new DoctorRepositoryImpl(sessionFactory);
        doctorService=new DoctorService(doctorRepository);

    }
    @Test
    void testCreateOffice() {
        Office office=new Office();
        Doctor doctor=new Doctor();
        doctor.setFirstName("Katrina");
        doctor.setLastName("Harris");
        doctor.setSpecialty("cardiology");
        doctor.setEmail("katrina.harris@gmail.com");
        doctorService.createDoctor(doctor);
        office.setDoctor(doctor);
        officeService.createOffice(office);
        assertNotNull(office.getOfficeId());
    }
    @Test
    void testUpdateOffice()
    {
        Office office=new Office();
        Doctor doctor=new Doctor();
        doctor.setFirstName("Katrina");
        doctor.setLastName("Harris");
        doctor.setSpecialty("cardiology");
        doctor.setEmail("katrina.harris@gmail.com");
        doctorService.createDoctor(doctor);
        office.setDoctor(doctor);
        officeService.createOffice(office);
        office.setLocation("Texas");
        officeService.updateOffice(office);
        Office updatedOffice=officeService.getOfficeById(office.getOfficeId());
        assertEquals("Texas",updatedOffice.getLocation());

    }
    @Test
    void testDeleteOffice()
    {

        Doctor doctor=new Doctor();
        doctor.setFirstName("Katrina");
        doctor.setLastName("Harris");
        doctor.setSpecialty("cardiology");
        doctor.setEmail("katrina.harris@gmail.com");
        doctorService.createDoctor(doctor);

        Office office=new Office();
        office.setDoctor(doctor);
        office.setLocation("Charlotte");
        office.setPhone("1234567896");
        officeService.createOffice(office);


        assertNotNull(office.getOfficeId());
        int id = doctor.getDoctorId();
        doctorService.deleteDoctor(id);
        int id1=office.getOfficeId();
        officeService.deleteOffice(id1);

        assertNull(officeService.getOfficeById(id1));

    }
    @Test
    void testGetOfficeById() {
        Office office=officeService.getOfficeById(1);
        assertNull(office);
    }
@ParameterizedTest
@CsvSource("office_location.csv")
void testCreateOfficeWithDifferentLocation(String officeName)
{
    Office office=new Office();
    Doctor doctor=new Doctor();
    doctor.setFirstName("Katrina");
    doctor.setLastName("Harris");
    doctor.setSpecialty("cardiology");
    doctor.setEmail("katrina.harris@gmail.com");
    doctorService.createDoctor(doctor);
    office.setDoctor(doctor);
    office.setLocation(officeName);
    officeService.createOffice(office);

   assertNotNull(office.getOfficeId());
   assertEquals(officeName,officeService.getOfficeById(office.getOfficeId()).getLocation());
}
    @AfterEach
    public void tearDown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}