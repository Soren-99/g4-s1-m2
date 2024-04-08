package sorenrahimi.g4s1m2.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sorenrahimi.g4s1m2.Exceptions.NotFoundException;
import sorenrahimi.g4s1m2.Repositories.MenusDAO;
import sorenrahimi.g4s1m2.entities.Menu;
import sorenrahimi.g4s1m2.entities.MenuItem;

import java.util.List;

@Service
public class MenusService {
    @Autowired
    MenusDAO menusDAO;

    public List<Menu> getAll() {
        return menusDAO.findAll();
    }
    public Menu findById(long id) {
        return menusDAO.findById(id).orElseThrow(
                ()-> new NotFoundException(id));
    }
    public void save(Menu menu){
        menusDAO.save(menu);
    }
    public void findByIdAndDelete(long id){
        Menu order = this.findById(id);
        menusDAO.delete(order);
    }
}
