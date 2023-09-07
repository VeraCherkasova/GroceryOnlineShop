import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_users")
    private int idUsers;

    @Column(name = "name")
    private String name;

    @OneToOne
    @JoinColumn(name = "id_user_details")
    private UserDetails userDetails;

    public void setIdUsers (int idUsers){
        this.idUsers=idUsers;
    }

    public int getIdUsers(){
        return idUsers;
    }

    public void setName (String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }

    public void setUserDetails (UserDetails userDetails){
        this.userDetails=userDetails;
    }

    public UserDetails getUserDetails(){
        return userDetails;
    }

    public User(){

    }

    public String toString(){
        return String.format("User [idUsers = %d, name = '%s']", idUsers, name);
    }


}
