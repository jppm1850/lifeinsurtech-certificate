package ar.com.lifeinsurtech.certificate.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
@Builder
public class CryptoCurrency implements Serializable
{
    private static final long serialVersionUID = 1L;
    
	@Id
    private String symbol;
    private Float price;
    private String lastUpdateDateAndTime;

    public CryptoCurrency() {
    }
    

    public CryptoCurrency(String symbol, Float price, String lastUpdateDateAndTime) {
        this.symbol = symbol;
        this.price = price;
        this.lastUpdateDateAndTime = lastUpdateDateAndTime;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getLastUpdateDateAndTime() {
        return lastUpdateDateAndTime;
    }

    public void setLastUpdateDateAndTime(String lastUpdateDateAndTime) {
        this.lastUpdateDateAndTime = lastUpdateDateAndTime;
    }


	@Override
	public String toString() {
		return "CryptoCurrency [symbol=" + symbol + ", price=" + price + ", lastUpdateDateAndTime="
				+ lastUpdateDateAndTime + "]";
	}
    
    
}
