package com.example.sergy.proyectointegrador;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private FirebaseAuth mAuth;

    EditText e_email;
    EditText e_password;
    Button regis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();

        e_email = (EditText) findViewById(R.id.register_email);
        e_password = (EditText) findViewById(R.id.register_pass);
        regis = (Button) findViewById(R.id.register_register);


    }

    public void registrarse(View view) {
        String email = e_email.getText().toString();
        String password = e_password.getText().toString();
        if (email.equals("") || password.equals("")) {
            Toast.makeText(Register.this, R.string.auth_failed,
                    Toast.LENGTH_SHORT).show();
        } else {
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());

                            // If sign in fails, display a message to the user. If sign in succeeds
                            // the auth state listener will be notified and logic to handle the
                            // signed in user can be handled in the listener.
                            if (!task.isSuccessful()) {
                                Toast.makeText(Register.this, R.string.auth_failed,
                                        Toast.LENGTH_SHORT).show();
                            } else {
                                finish();
                                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);
                            }

                            // ...
                        }
                    });
        }
    }
}
