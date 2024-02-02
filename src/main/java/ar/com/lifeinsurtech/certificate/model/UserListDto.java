package ar.com.lifeinsurtech.certificate.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserListDto {

    private String name;
    private String surname;
    private int operationsPerformed;
    private int reputation;

    public UserListDto(User user){
        this.name = user.getName();
        this.surname = user.getSurname();
        this.operationsPerformed = user.getOperationsPerformed();
        this.reputation = user.getPointsObtained();
    }

}
