package BancoPopular.Commons.domains.entity.user;

import jakarta.persistence.*;
import lombok.*;
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
    @Column(name = "user_type_id")
    public String userTypeId;
    @Column(name = "user_name")
    public String userName;
    @Column(name = "user_email")
    public String userEmail;
    @Column(name = "user_password")
    public String userPassword;
    @Column(name = "user_number")
    public int userNumber;

    public String getUserPassword() {return userPassword;}
    public void setUserPassword(String userPassword) {this.userPassword = userPassword;}
}