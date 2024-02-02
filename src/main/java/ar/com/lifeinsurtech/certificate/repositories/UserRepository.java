package ar.com.lifeinsurtech.certificate.repositories;


import ar.com.lifeinsurtech.certificate.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User findAllByEmail(String email);
}
