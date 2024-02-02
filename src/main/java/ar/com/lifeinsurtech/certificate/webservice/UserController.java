package ar.com.lifeinsurtech.certificate.webservice;

import ar.com.lifeinsurtech.certificate.model.response.AccounCreateUserDTO;
import ar.com.lifeinsurtech.certificate.model.User;
import ar.com.lifeinsurtech.certificate.model.exceptions.UserNotFoundException;
import ar.com.lifeinsurtech.certificate.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Transactional
@RequestMapping("/user")
public class UserController {

    @Autowired
    private AccountService accountService;


    @Operation(summary = "Register account")
    @PostMapping(path="/account" , consumes = "application/json", produces = "application/json")
   public AccounCreateUserDTO createUser(
                              @RequestBody User user) throws UserNotFoundException {
        return this.accountService.createUser(user);
    }

    @Operation(summary = "All Accounts")
    @GetMapping(path="/account" ,  produces = "application/json")
    public List<User> allAccounts() {
        return this.accountService.allUser();
    }
}
