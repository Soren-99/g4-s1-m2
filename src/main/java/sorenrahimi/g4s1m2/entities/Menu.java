package sorenrahimi.g4s1m2.entities;


import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "menus")
@NoArgsConstructor
public class Menu{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "menu")
    @Autowired
    private List<Pizza> pizzaList;
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "menu")
    @Autowired
    private List<Beverage> beverageList;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "menu")
    @Autowired
    private List<Topping> toppingList;

    public Menu(String name){
        this.name = name;
    }


    public void printMenu() {
        System.out.println("- MENU -");
        System.out.println("PIZZE");
        this.pizzaList.forEach(System.out::println);
        System.out.println();
        System.out.println("TOPPINGS");
        this.toppingList.forEach(System.out::println);
        System.out.println();
        System.out.println("BEVERAGES");
        this.beverageList.forEach(System.out::println);
        System.out.println();
    }
}
