package com.HUMMMM.yopido.datos;

import android.util.Log;

import java.util.concurrent.atomic.AtomicReference;

import io.realm.mongodb.App;
import io.realm.mongodb.AppConfiguration;
import io.realm.mongodb.Credentials;
import io.realm.mongodb.User;

public class RealmDB {
    private static final String YOUR_APP_ID = "restavidbbdd-djyny";

    public void InciarSesion(String email, String contrasena) {
        String appID = YOUR_APP_ID; // replace this with your App ID
        App app = new App(new AppConfiguration.Builder(appID)
                .build());
        Credentials emailPasswordCredentials = Credentials.emailPassword(email, contrasena);
        AtomicReference<User> user = new AtomicReference<User>();
        app.loginAsync(emailPasswordCredentials, it -> {
            if (it.isSuccess()) {
                Log.v("AUTH", "Successfully authenticated using an email and password.");
                user.set(app.currentUser());
            } else {
                Log.e("AUTH", it.getError().toString());
            }
        });
    }
}
