import jakarta.persistence.*;
@Entity
@Table(name = "warehouse")
public class Warehouse {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column (name = "id_warehouse")
        private int idWarehouse;

        @Column(name = "name_warehouse")
        private String nameWarehouse;

        @ManyToOne
        @JoinColumn(name = "id_items")
        private Item items;

        public void setIdWarehouse (int idWarehouse){
            this.idWarehouse=idWarehouse;
        }

        public int getIdWarehouse(){
            return idWarehouse;
        }

        public void setNameWarehouse (String nameWarehouse){
            this.nameWarehouse=nameWarehouse;
        }

        public String getNameWarehouse(){
            return nameWarehouse;
        }

        public void setIdItems (Item items){
            this.items=items;
        }

        public Item getIdItems(){
            return items;
        }

        public Warehouse(){

        }

        public String toString(){
            return String.format("Warehouse [idWarehouse = %d, nameWarehouse = '%s', items = %d]", idWarehouse, nameWarehouse,items);
        }




    }
