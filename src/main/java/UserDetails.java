import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "user_details")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    @Column (name = "id_user_details")
    private int idUserDetails;

    @Column (name = "email")
    private String email;

    @Column (name = "city")
    private String city;

    @OneToOne(mappedBy = "userDetails")
    private User user;

    public void setIdUserDetails (int idUserDetails){
        this.idUserDetails=idUserDetails;
    }

    public int getIdUserDetails(){
        return idUserDetails;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public String getEmail(){
        return email;
    }

    public void setCity(String city){
        this.city=city;
    }

    public String getCity(){
        return city;
    }

    public UserDetails(){

    }

    public String toString(){
        return String.format("UserDetails [idUserDetails = %d, email = '%s', city = '%s']",idUserDetails, email, city);
    }


}
