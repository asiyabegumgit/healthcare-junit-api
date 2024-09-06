package healthcarev2.repository;

import healthcarev2.model.Office;
import java.util.List;

public interface OfficeRepository {
    void create(Office office);
    Office findById(int id);
    List<Office> findAll();
    void update(Office office);
    void delete(int id);
}