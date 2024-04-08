package sorenrahimi.g4s1m2.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sorenrahimi.g4s1m2.Exceptions.NotFoundException;
import sorenrahimi.g4s1m2.Repositories.ItemsDAO;
import sorenrahimi.g4s1m2.entities.Beverage;
import sorenrahimi.g4s1m2.entities.MenuItem;
import sorenrahimi.g4s1m2.entities.Pizza;
import sorenrahimi.g4s1m2.entities.Topping;

import java.util.List;

@Service
public class ItemsService {
    @Autowired
    ItemsDAO itemsDAO;
    public List<MenuItem> getAll(){
        return itemsDAO.findAll();
    }
    public List<Pizza> getPizzas(){
        return itemsDAO.findPizzas();
    }
    public List<Beverage> getDrinks(){
        return itemsDAO.findBeverages();
    }
    public List<Topping> getToppings(){
        return itemsDAO.findToppings();
    }
    public MenuItem findById(long id){
        return itemsDAO.findById(id).orElseThrow(()->
                new NotFoundException(id));
    }
    public void save(MenuItem menuItem){
        itemsDAO.save(menuItem);
    }
    public void findByIdAndDelete(long id){
        MenuItem order = this.findById(id);
        itemsDAO.delete(order);
    }
}
