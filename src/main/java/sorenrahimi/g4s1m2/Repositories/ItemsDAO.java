package sorenrahimi.g4s1m2.Repositories;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sorenrahimi.g4s1m2.entities.Beverage;
import sorenrahimi.g4s1m2.entities.MenuItem;
import sorenrahimi.g4s1m2.entities.Pizza;
import sorenrahimi.g4s1m2.entities.Topping;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemsDAO extends JpaRepository<MenuItem, Long> {
    @Query("SELECT p FROM Pizza p")
    List<Pizza> findPizzas();
    @Query("SELECT d FROM Beverage d")
    List<Beverage> findBeverages();
    @Query("SELECT t FROM Toppping t")
    List<Topping> findToppings();


}
