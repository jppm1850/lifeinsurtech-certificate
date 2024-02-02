package ar.com.lifeinsurtech.certificate;

import ar.com.lifeinsurtech.certificate.webservice.CertificateController;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserControllerEndToEndTest {

	private static final String HTTP_LOCALHOST = "http://localhost:";

	
	//@Value("${server.port:8090}")
	@LocalServerPort
	private int port;
	
	@Autowired
	private CertificateController controller;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Autowired
    private WebTestClient webClient;

	//@Test
	public void contextLoads() throws Exception {
		//assertThat(controller).isNotNull();
	}
	
	//@Test
	public void getCrypoValueTest() throws Exception {
		//webClient.get().uri("/api/crypto/crypto/all");
		//assertThat(this.restTemplate.getForObject(HTTP_LOCALHOST + port + "/api/crypto/crypto/all", String.class)).contains("cryptos");
	}

}
