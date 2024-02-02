package ar.com.lifeinsurtech.certificate.repositories;

import ar.com.lifeinsurtech.certificate.model.CryptoCurrency;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Configuration
@Repository
public interface CertificateRepository extends CrudRepository<CryptoCurrency,String> { }
