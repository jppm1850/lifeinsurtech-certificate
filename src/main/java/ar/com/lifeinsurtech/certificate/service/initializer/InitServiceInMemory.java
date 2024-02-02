package ar.com.lifeinsurtech.certificate.service.initializer;


import ar.com.lifeinsurtech.certificate.model.Role;
import ar.com.lifeinsurtech.certificate.model.User;
import ar.com.lifeinsurtech.certificate.repositories.RoleRepository;
import ar.com.lifeinsurtech.certificate.repositories.UserRepository;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;


@Service
@Transactional
public class InitServiceInMemory {

    protected final Log logger = LogFactory.getLog(getClass());

    @Value("${spring.datasource.driverClassName:NONE}")
    private String className;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;



//    @Autowired
//    private AccountService userService;

    @PostConstruct
    public void initialize()  {
        if (className.equals("org.h2.Driver")) {
            logger.info("Init Data Using H2 DB");
            fireInitialData();
        }
    }

    private void fireInitialData() {
        Role roleAdmin = new Role("ADMIN");
        Role roleOperator = new Role("USER");
        roleAdmin = roleRepository.save(roleAdmin);
        roleOperator = roleRepository.save(roleOperator);
        User user = new User("pepe@gmail.com", "Pepa","Pepa" , "San Martin 185", "unaPassw123??", "123456", "12345678",roleAdmin);
        userRepository.save(user);
        user = new User("pedro@gmail.com", "Pedro","Pedro" , "San Martin 185", "unaPassw123??", "123456", "12345678",roleOperator);
        userRepository.save(user);
    }
}
