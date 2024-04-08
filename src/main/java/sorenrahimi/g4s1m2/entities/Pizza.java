package sorenrahimi.g4s1m2.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Getter
@Entity
@DiscriminatorValue("Pizza")
@NoArgsConstructor
public class Pizza extends MenuItem {
    private String name;
    @ManyToMany
    @JoinTable(name = "toppings_pizzas", joinColumns = @JoinColumn(name = "pizzas"),
    inverseJoinColumns = @JoinColumn(name = "toppings"))
    private List<Topping> toppingList;
    private boolean isXL = false;


    public Pizza(String name, List<Topping> toppingList, boolean isXL) {
        super(980, 4.5);
        this.name = name;
        this.toppingList = toppingList;
        this.isXL = isXL;
    }

    @Override
    public int getCalories() {
        return super.getCalories() +
                this.getToppingList().stream().mapToInt(Topping::getCalories).sum();
    }


    @Override
    public double getPrice() {
        return super.getPrice() +
                this.getToppingList().stream().mapToDouble(Topping::getPrice).sum();
    }



    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", toppingList=" + toppingList +
                ", isXL=" + isXL +
                ", calories=" + calories +
                ", price=" + price +
                '}';
    }
}
