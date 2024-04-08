package sorenrahimi.g4s1m2.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sorenrahimi.g4s1m2.entities.Table;

public interface TablesDAO extends JpaRepository<Table, Long> {
}
