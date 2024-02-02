package ar.com.lifeinsurtech.certificate.webservice;

import ar.com.lifeinsurtech.certificate.model.CryptoCurrency;
import ar.com.lifeinsurtech.certificate.model.CryptoCurrencyList;
import ar.com.lifeinsurtech.certificate.service.CertificateService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Lifeinsurtech services")
@Tag(name = "Lifeinsurtech services", description = "Manage Lifeinsurtech")
@RestController
@Transactional
@RequestMapping("/api/certificate")
public class CertificateController {
	
	@Autowired
	CertificateService cryptoService;

	@Operation(summary = "Get a Lifeinsurtech price")
	@GetMapping("/{symbol}")
	public ResponseEntity<CryptoCurrency> getCryptoCurrencyValue(
			@Parameter(description = "The Lifeinsurtech symbol that needs to be fetched", required = true) @PathVariable String symbol) {
		CryptoCurrency entity = cryptoService.getCryptoCurrencyValue(symbol);
		return ResponseEntity.ok().body(entity);
	}

	@Operation(summary = "Get all Lifeinsurtech prices")
	@GetMapping("/all")
	public ResponseEntity<CryptoCurrencyList> getAllCryptoCurrencyPrices() {
		CryptoCurrencyList list = cryptoService.getAllCryptoCurrencyPrices();
		return ResponseEntity.ok().body(list);
	}

//    @Operation(summary = "Register account")
//    @PostMapping(path="/addAccount" , consumes = "application/json", produces = "application/json")
//    public AccounCreateUserDTO createUser(@Parameter(description = "The account to be registered", required = true)
//                               @RequestBody User user) throws UserNotFoundException{
//        return this.accountService.createUser(user);
//    }
//
//    @Operation(summary = "Delete Account")
//    @DeleteMapping("/deleteAccount /{id}")
//    public void deleteUser(@Parameter(description = "The account ID to be deleted", required = true)
//                               @PathVariable Long id){
//        List<Transaction> transactionsByID = this.transactionService.getTransactionsByUserId(id);
//        if(!transactionsByID.isEmpty()) {
//            transactionsByID.forEach(transaction -> this.transactionService.deleteTransaction(transaction.getId()));
//        }else{
//            this.accountService.deleteUser(id);
//        }
 //   }
}
