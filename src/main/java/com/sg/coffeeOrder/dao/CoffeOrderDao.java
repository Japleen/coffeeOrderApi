package com.sg.coffeeOrder.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

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
					.setDatabaseUrl("https://Assignment.firebaseio.com/").build();


			FirebaseApp.initializeApp(options);

			// [END initialize]
		} catch (IOException e) {
			e.getMessage();
		}

		// Shared Database reference
		// database = FirebaseDatabase.getInstance().getReference();
	}

//	public void update(Object value, String key) {
//
//		try {
//			DatabaseReference ref = firebaseDatabase.getReference(key);
//			final CountDownLatch latch = new CountDownLatch(1);
//			ref.setValue(value, new DatabaseReference.CompletionListener() {
//				@Override
//				public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
//					if (databaseError != null) {
//						latch.countDown();
//					} else {
//						latch.countDown();
//					}
//				}
//			});
//			latch.await();
//		} catch (InterruptedException e) {
//		}
//	}

}
