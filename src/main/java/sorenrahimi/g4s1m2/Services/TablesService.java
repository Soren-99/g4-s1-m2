package sorenrahimi.g4s1m2.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sorenrahimi.g4s1m2.Exceptions.NotFoundException;
import sorenrahimi.g4s1m2.Repositories.TablesDAO;
import sorenrahimi.g4s1m2.entities.MenuItem;
import sorenrahimi.g4s1m2.entities.Table;

import java.util.List;

@Service
public class TablesService {
    @Autowired
    TablesDAO tablesDAO;

    public List<Table> getAll() {
        return tablesDAO.findAll();
    }
    public Table findById(long id){
        return tablesDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
    }
    public void save(Table table){
        tablesDAO.save(table);
    }
    public void findByIdAndDelete(long id){
        Table order = this.findById(id);
        tablesDAO.delete(order);
    }
}
