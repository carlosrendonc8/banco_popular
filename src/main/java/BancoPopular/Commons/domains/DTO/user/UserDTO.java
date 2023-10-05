package BancoPopular.Commons.domains.DTO.user;

import lombok.*;
import java.io.Serializable;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserDTO implements Serializable {
    public Integer userId;
    public String userTypeId;
    public String userName;
    public String email;
    public String userPassword;
    public int userNumber;

    public Integer getUserId() {return userId;}
    public void setUserId(Integer userId) {this.userId = userId;}

    public String getUserTypeId() {return userTypeId;}
    public void setUserTypeId(String userTypeId) {this.userTypeId = userTypeId;}

    public String getUserName() {return userName;}
    public void setUserName(String userName) {this.userName = userName;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getUserPassword() {return userPassword;}
    public void setUserPassword(String userPassword) {this.userPassword = userPassword;}

    public int getUserNumber() {return userNumber;}
    public void setUserNumber(int userNumber) {this.userNumber = userNumber;}
}