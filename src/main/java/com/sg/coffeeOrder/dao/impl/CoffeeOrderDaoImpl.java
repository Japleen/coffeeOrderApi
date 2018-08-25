package com.sg.coffeeOrder.dao.impl;

import java.io.FileInputStream;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.sg.coffeeOrder.dao.CoffeeOrderDao;
import com.sg.coffeeOrder.model.StaffRegister;

@Component
public class CoffeeOrderDaoImpl implements CoffeeOrderDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(CoffeeOrderDao.class);

	// @Value(value = "${app.serviceJsonPath}")
	// private Resource serviceJson;

	static int userCount = 0;

	CoffeeOrderDaoImpl() {
		try {
			// [START initialize]

			FileInputStream serviceAccount = new FileInputStream(
					"/Users/japleenkaur/eclipse-workspace1/CoffeeOrder/src/main/resources/static/fireBaseDb/serviceAccount.json");

			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(serviceAccount))
					.setDatabaseUrl("https://assignment-aa2c7.firebaseio.com/").build();

			FirebaseApp.initializeApp(options);

			// [END initialize]
		} catch (IOException e) {
			LOGGER.debug(e.getMessage());
		}

	}

	@Override
	public void createUser(StaffRegister staff) {
		try {
			final FirebaseDatabase database = FirebaseDatabase.getInstance();
			DatabaseReference ref = database.getReference("Users");
			ref.child("User" + ++userCount).setValueAsync(staff);
			// ref.child("User2").setValueAsync(users2);

		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
		}
	}

}
