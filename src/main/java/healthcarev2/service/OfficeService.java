package healthcarev2.service;

import healthcarev2.model.Office;
import healthcarev2.repository.OfficeRepository;
import java.util.List;

public class OfficeService {

    private final OfficeRepository officeRepository;

    public OfficeService(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    public void createOffice(Office office) {
        officeRepository.create(office);
    }

    public Office getOfficeById(int id) {
        return officeRepository.findById(id);
    }

    public List<Office> getAllOffices() {
        return officeRepository.findAll();
    }

    public void updateOffice(Office office) {
        officeRepository.update(office);
    }

    public void deleteOffice(int id) {
        officeRepository.delete(id);
    }
}