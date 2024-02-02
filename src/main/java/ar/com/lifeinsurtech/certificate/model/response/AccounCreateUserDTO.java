package ar.com.lifeinsurtech.certificate.model.response;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccounCreateUserDTO {

    private String userName;
    private String password;
}
