package com.HUMMMM.yopido.pantallas;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.HUMMMM.yopido.R;
import com.HUMMMM.yopido.datos.FireBase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.quickstart.database.databinding.ActivitySignInBinding;
import com.google.firebase.*;
import io.realm.mongodb.User;

public abstract class BaseActivity extends AppCompatActivity {
    FireBase fb;
    private static final String TAG = "Pedo";
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;

    //private ActivitySignInBinding binding;

    @Override
    public void setContentView(int layoutResID) {
        DrawerLayout fullView = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_base, null);
        FrameLayout activityContainer = (FrameLayout) fullView.findViewById(R.id.activity_content);
        getLayoutInflater().inflate(layoutResID, activityContainer, true);
        super.setContentView(fullView);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("RestaVid");
        getSupportActionBar().setIcon(R.drawable.hdpi);
        //Instancia de la bbdd
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();

    }

    @Override
    public void onStart() {
        super.onStart();

        // Check auth on Activity start
//        if (mAuth.getCurrentUser() != null) {
//            onAuthSuccess(mAuth.getCurrentUser());
//        }
    }

    public void initToolbar() {
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

    }
}
//
//    private void signIn() {
//        Log.d(TAG, "signIn");
//        if (!validateForm()) {
//            return;
//        }
//
//        showProgressBar();
//        String email = binding.fieldEmail.getText().toString();
//        String password = binding.fieldPassword.getText().toString();
//
//        mAuth.signInWithEmailAndPassword(email, password)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        Log.d(TAG, "signIn:onComplete:" + task.isSuccessful());
//                        hideProgressBar();
//
//                        if (task.isSuccessful()) {
//                            onAuthSuccess(task.getResult().getUser());
//                        } else {
//                            Toast.makeText(SignInActivity.this, "Sign In Failed",
//                                    Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//    }
//
//    private void signUp() {
//        Log.d(TAG, "signUp");
//        if (!validateForm()) {
//            return;
//        }
//
//        showProgressBar();
//        String email = binding.fieldEmail.getText().toString();
//        String password = binding.fieldPassword.getText().toString();
//
//        mAuth.createUserWithEmailAndPassword(email, password)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        Log.d(TAG, "createUser:onComplete:" + task.isSuccessful());
//                        hideProgressBar();
//
//                        if (task.isSuccessful()) {
//                            onAuthSuccess(task.getResult().getUser());
//                        } else {
//                            Toast.makeText(SignInActivity.this, "Sign Up Failed",
//                                    Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//    }
//
//    private void onAuthSuccess(FirebaseUser user) {
//        String username = usernameFromEmail(user.getEmail());
//
//        // Write new user
//        writeNewUser(user.getUid(), username, user.getEmail());
//
//        // Go to MainActivity
//        startActivity(new Intent(SignInActivity.this, MainActivity.class));
//        finish();
//    }
//
//    private String usernameFromEmail(String email) {
//        if (email.contains("@")) {
//            return email.split("@")[0];
//        } else {
//            return email;
//        }
//    }
//
//    private boolean validateForm() {
//        boolean result = true;
//        if (TextUtils.isEmpty(binding.fieldEmail.getText().toString())) {
//            binding.fieldEmail.setError("Required");
//            result = false;
//        } else {
//            binding.fieldEmail.setError(null);
//        }
//
//        if (TextUtils.isEmpty(binding.fieldPassword.getText().toString())) {
//            binding.fieldPassword.setError("Required");
//            result = false;
//        } else {
//            binding.fieldPassword.setError(null);
//        }
//
//        return result;
//    }
//
//    // [START basic_write]
//    private void writeNewUser(String userId, String name, String email) {
//        User user = new User(name, email);
//
//        mDatabase.child("users").child(userId).setValue(user);
//    }
//    // [END basic_write]
//
//    @Override
//    public void onClick(View v) {
//        int i = v.getId();
//        if (i == R.id.buttonSignIn) {
//            signIn();
//        } else if (i == R.id.buttonSignUp) {
//            signUp();
//        }
//    }
//}
