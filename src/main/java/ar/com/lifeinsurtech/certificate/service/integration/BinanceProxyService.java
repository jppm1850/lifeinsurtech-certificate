package ar.com.lifeinsurtech.certificate.service.integration;

import ar.com.lifeinsurtech.certificate.model.CryptoCurrency;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BinanceProxyService {

	
	private RestTemplate restTemplate = new RestTemplate();
	
	@Value("${integration.binance.api.url:NONE}")
	private String binanceApiURL;
	
	public CryptoCurrency getCryptoCurrencyValue(String symbol) {
	CryptoCurrency entity = restTemplate.getForObject(binanceApiURL + "ticker/price?symbol=" + symbol, CryptoCurrency.class);
	return entity;
	}


}
