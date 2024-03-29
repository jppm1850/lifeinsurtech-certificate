package ar.com.lifeinsurtech.certificate;

import ar.com.lifeinsurtech.certificate.model.CryptoCurrency;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

class UserControllerMockTest {

    @Mock
    RestTemplate restTemplate = Mockito.mock(RestTemplate.class);

    private CryptoCurrency crypto;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        crypto = new CryptoCurrency("BTCUSDT", 10f, "today");
    }

    @Test
    void getBTCUSDTCrypto() {
        ResponseEntity<CryptoCurrency> cryptoResponse = new ResponseEntity<>(crypto, HttpStatus.OK);

        Mockito
                .when(restTemplate.getForEntity(ArgumentMatchers.anyString(), ArgumentMatchers.eq(CryptoCurrency.class)))
                .thenReturn(cryptoResponse);

        Assertions.assertEquals(HttpStatus.OK, cryptoResponse.getStatusCode());
        Assertions.assertEquals(cryptoResponse.getBody().getPrice(), crypto.getPrice());
        Assertions.assertEquals(cryptoResponse.getBody().getSymbol(), crypto.getSymbol());
        Assertions.assertEquals(cryptoResponse.getBody().getLastUpdateDateAndTime(), crypto.getLastUpdateDateAndTime());
    }

}
