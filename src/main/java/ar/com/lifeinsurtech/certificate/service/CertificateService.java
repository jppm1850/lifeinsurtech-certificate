package ar.com.lifeinsurtech.certificate.service;


import ar.com.lifeinsurtech.certificate.helpers.CurrentDateTime;
import ar.com.lifeinsurtech.certificate.model.CryptoCurrency;

import ar.com.lifeinsurtech.certificate.model.CryptoCurrencyEnum;
import ar.com.lifeinsurtech.certificate.model.CryptoCurrencyList;
import ar.com.lifeinsurtech.certificate.repositories.CertificateRepository;
import ar.com.lifeinsurtech.certificate.service.integration.BinanceProxyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class CertificateService {
	
    @Autowired
	CertificateRepository cryptoRepository;

	@Autowired
    BinanceProxyService binanceProxyService;

 
	public CryptoCurrencyList getAllCryptoCurrencyPrices() {
		CryptoCurrencyList list = new CryptoCurrencyList();
		for (CryptoCurrencyEnum crypto : CryptoCurrencyEnum.values()) {
			CryptoCurrency entity = binanceProxyService.getCryptoCurrencyValue(crypto.name());
			
			if (entity != null) {
				entity.setLastUpdateDateAndTime(CurrentDateTime.getNewDateString());
			}
			list.addCrypto(entity);

		}
		return list;
	}
    
    
	@Cacheable(value = "cryptoCache", key = "#symbol")
    public CryptoCurrency getCryptoCurrencyValue(
			String symbol) {
		CryptoCurrency entity = binanceProxyService.getCryptoCurrencyValue(symbol);

		SimpleDateFormat formatter = CurrentDateTime.getNewDateFormatter();
		if (entity != null) {
			entity.setLastUpdateDateAndTime(formatter.format(new Date()));
		}
		return entity;
	}
}
