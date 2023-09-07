import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name= "items")
public class Item {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_items")
    private int idItems;

    @OneToMany(mappedBy = "items")
    private List<Warehouse> warehouses;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private int price;


    public void setIdItems(int idItems){
        this.idItems = idItems;
    }

    public int getIdItems(){
        return idItems;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public int getPrice(){
        return price;
    }

    public List<Warehouse> getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(List<Warehouse> warehouses) {
        this.warehouses = warehouses;
    }

    public Item(){

    }

    public Item (String title, int price){
        this.title = title;
        this.price = price;
    }

    public String toString(){
        return String.format("Item [warehouses = %d, title = '%s', price = %d]", warehouses, title, price);
    }



}
