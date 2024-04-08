package sorenrahimi.g4s1m2.entities;


import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "item_type")
@Table(name = "items")
public abstract class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;
    protected int calories;
    protected double price;
    @ManyToOne
    @JoinColumn(name = "menu_id")
    protected Menu menu;
    @ManyToMany(mappedBy = "orderProducts")
    private List<Order> orders;

    public MenuItem(int calories, double price){
        this.calories = calories;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public long getId() {
        return id;
    }

    public int getCalories() {
        return calories;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
    }
}