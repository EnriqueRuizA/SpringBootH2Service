package com.crud.h2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SpringBootH2ServiceApplication implements CommandLineRunner {

	@Autowired
	private JdbcTemplate template;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootH2ServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		resetTable();
		initialInserts();
	}

	private void initialInserts() {
		String user1 = "'user1'";
		insertSql(1, "'2020-06-14 00:00:00'", "'2020-12-31 23:59:59'", 1, 35455, 0, 35.50f, "'EUR'",
				"'2020-03-26 14:49:07'", user1);
		insertSql(1, "'2020-06-14 15:00:00'", "'2020-06-14 18:30:00'", 2, 35455, 1, 25.45f, "'EUR'",
				"'2020-05-26 15:38:22'", user1);
		insertSql(1, "'2020-06-15 00:00:00'", "'2020-06-15 11:00:00'", 3, 35455, 1, 30.50f, "'EUR'",
				"'2020-05-26 15:39:22'", "'user2'");
		insertSql(1, "'2020-06-15 16:00:00'", "'2020-12-31 23:59:59'", 4, 35455, 1, 38.95f, "'EUR'",
				"'2020-06-02 10:14:00'", user1);
	}
	
	private void insertSql(int brandId, String startDate, String endDate, int priceList, int productId, int priority,
			float price, String currency, String lastUpdate, String lastUpdateBy) {

		String coma = ", ";

		StringBuilder insert = new StringBuilder("INSERT INTO PRICE (");
		insert.append("brandId");
		insert.append(coma);
		insert.append("startDate");
		insert.append(coma);
		insert.append("endDate");
		insert.append(coma);
		insert.append("priceList");
		insert.append(coma);
		insert.append("productId");
		insert.append(coma);
		insert.append("priority");
		insert.append(coma);
		insert.append("price");
		insert.append(coma);
		insert.append("currency");
		insert.append(coma);
		insert.append("lastUpdate");
		insert.append(coma);
		insert.append("lastUpdateBy");

		insert.append(") VALUES (");
		insert.append(brandId);
		insert.append(coma);
		insert.append(startDate);
		insert.append(coma);
		insert.append(endDate);
		insert.append(coma);
		insert.append(priceList);
		insert.append(coma);
		insert.append(productId);
		insert.append(coma);
		insert.append(priority);
		insert.append(coma);
		insert.append(price);
		insert.append(coma);
		insert.append(currency);
		insert.append(coma);
		insert.append(lastUpdate);
		insert.append(coma);
		insert.append(lastUpdateBy);
		insert.append(")");

		template.update(insert.toString());
	}

	private void resetTable() {
		String drop = "DROP TABLE PRICE IF EXISTS";
		StringBuilder create = new StringBuilder("CREATE TABLE PRICE(");

		create.append("id INTEGER(10) PRIMARY KEY auto_increment,");
		create.append("brandId INTEGER(10),");
		create.append("startDate DATETIME ,");
		create.append("endDate DATETIME,");
		create.append("priceList INTEGER(10),");
		create.append("productId INTEGER(10),");
		create.append("priority INTEGER(10),");
		create.append("price DECIMAL,");
		create.append("currency VARCHAR(32),");
		create.append("lastUpdate DATETIME ,");
		create.append("lastUpdateBy VARCHAR(32)");
		create.append(")");

		template.execute(drop);
		template.execute(create.toString());

	}
}
