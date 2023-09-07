import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
    public static void main(String[] args){
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernateFile.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).addAnnotatedClass(Item.class).addAnnotatedClass(Warehouse.class).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();

//        // === CREATE ===
//        session = sessionFactory.getCurrentSession();
//        session.beginTransaction();
//        Item item = new Item("Milk", 100);
//        System.out.println(item);
//        session.save(item);
//        System.out.println(item);
//        session.getTransaction().commit();

//        // === READ ===
//        session = sessionFactory.getCurrentSession();
//        session.beginTransaction();
//        Item itemFromDb = session.get(Item.class, 1);
//        System.out.println(itemFromDb);
//        session.getTransaction().commit();

//        //   === READ var.2 ===
//        session = sessionFactory.getCurrentSession();
//        session.beginTransaction();
//        Item itemFromDb = session.createQuery("SELECT i FROM Item i WHERE i.id = 4", Item.class)
//                .getSingleResult();
//        System.out.println(itemFromDb);
//        session.getTransaction().commit();

          //  === READ var.3 ===
//        session = sessionFactory.getCurrentSession();
//        session.beginTransaction();
//        Item itemFromDb = session.createQuery("SELECT i FROM Item i WHERE i.id = :id", Item.class)
//                .setParameter("id",4)
//                .getSingleResult();
//        System.out.println(itemFromDb);
//        session.getTransaction().commit();

//        //  === READ var.4 ===
//        session = sessionFactory.getCurrentSession();
//        session.beginTransaction();
//        List <Item> items = session.createQuery("SELECT i FROM Item i",Item.class).getResultList();
//        System.out.println(items);
//        session.getTransaction().commit();

//        // === UPDATE ===
//        session = sessionFactory.getCurrentSession();
//        session.beginTransaction();
//        Item itemFromDb = session.get(Item.class,2);
//        System.out.println(itemFromDb);
//        itemFromDb.setTitle("Cookies");
//        itemFromDb.setPrice(56);
//        session.getTransaction().commit();

        // === DELETE ===
//        session = sessionFactory.getCurrentSession();
//        session.beginTransaction();
//        Item itemFromDb = session.get(Item.class,3);
//        session.remove(itemFromDb);
//        session.getTransaction().commit();

//          session = sessionFactory.getCurrentSession();
//          session.beginTransaction();
//          User user = session.get(User.class,1);
//          System.out.println(user);
//          System.out.println(user.getUserDetails());
//
//          session.getTransaction().commit();

        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Item item = session.get(Item.class,2);  // товары с айдишником 2 (печеньки) хранятся на 2-х складах
        for (Warehouse i : item.getWarehouses()) {
            System.out.println(i.getNameWarehouse());
        }
        session.getTransaction().commit();


        sessionFactory.close();

    }
}
