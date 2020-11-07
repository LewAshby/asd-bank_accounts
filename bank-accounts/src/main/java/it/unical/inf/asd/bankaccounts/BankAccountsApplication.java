package it.unical.inf.asd.bankaccounts;

import it.unical.inf.asd.bankaccounts.data.dao.CedolaDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BankAccountsApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(BankAccountsApplication.class, args);
		context.getBean(CedolaDao.class);
	}

}
