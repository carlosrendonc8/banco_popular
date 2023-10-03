package BancoPopular.Commons.domains.entity.user;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user_popular")
public class UserEntity {
    @Id
    @Column(name = "user_id")
    public Integer id;
    @Column(name = "user_name")
    public String name;
    @Column(name = "user_email")
    public String email;
    @Column(name = "user_password")
    public String password;
    @Column(name = "user_number")
    public int number;


    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
}