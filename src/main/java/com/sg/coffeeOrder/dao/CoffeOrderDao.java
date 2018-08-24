package com.sg.coffeeOrder.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

@Component
public class CoffeOrderDao {
	// private static final String DATABASE_URL =
	// "https://<YOUR-DATABASE>.firebaseio.com/" ;

	@Value(value = "${app.serviceJsonPath}")
	private Resource serviceJson;

	CoffeOrderDao() {
		try {
			// [START initialize]

			FileInputStream serviceAccount = new FileInputStream(
					"/Users/japleenkaur/eclipse-workspace1/CoffeeOrder/src/main/resources/static/fireBaseDb/serviceAccount.json");

			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(serviceAccount))
					.setDatabaseUrl("https://assignment-aa2c7.firebaseio.com/").build();


			FirebaseApp.initializeApp(options);
			update();

			// [END initialize]
		} catch (IOException e) {
			e.getMessage();
		}

		// Shared Database reference
		// database = FirebaseDatabase.getInstance().getReference();
	}

	public void update() {

		try {
			final FirebaseDatabase database = FirebaseDatabase.getInstance();
			DatabaseReference ref = database.getReference("Users");
			System.out.println("ref" + ref);
			
			Map<String, String> users = new HashMap<>();
		    users.put("A", "abc");
		    Map<String, String> users2 = new HashMap<>();
		    users2.put("B", "abc2");
		    System.out.println(users);
		    ref.child("User1").setValueAsync(users);
		    ref.child("User2").setValueAsync(users2);
		    //ref.setValueAsync(users);

		    System.out.println(ref);
			
		} catch (Exception e) {
		}
	}

}
