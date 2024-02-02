package ar.com.lifeinsurtech.certificate.service;

import ar.com.lifeinsurtech.certificate.model.response.AccounCreateUserDTO;
import ar.com.lifeinsurtech.certificate.model.User;
import ar.com.lifeinsurtech.certificate.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AccountService {

    @Autowired
    private UserRepository userRepository;


    public AccounCreateUserDTO createUser(User user) {
        AccounCreateUserDTO accounCreate = new AccounCreateUserDTO();
        userRepository.save(user);
        accounCreate.setUserName(user.getEmail());

        return accounCreate;
    }

    public List<User> allUser() {
        return userRepository.findAll();
    }
}
