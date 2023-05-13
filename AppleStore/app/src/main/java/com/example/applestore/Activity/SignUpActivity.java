package com.example.applestore.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.applestore.APIService.APIService;
import com.example.applestore.Adapter.CategoryAdapter;
import com.example.applestore.R;
import com.example.applestore.Retrofit.RetrofitClient;
import com.example.applestore.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    private EditText signupEmail, signupPassword;
    private Button signupButton;
    private TextView loginRedirecText;

    APIService apiService = RetrofitClient.getRetrofit().create(APIService.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        auth = FirebaseAuth.getInstance();
        signupEmail = findViewById(R.id.signup_email);
        signupPassword = findViewById(R.id.signup_password);
        signupButton = findViewById(R.id.signup_button);
        loginRedirecText = findViewById(R.id.loginRedirectText);


        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = signupEmail.getText().toString().trim();
                String pass = signupPassword.getText().toString().trim();

                if(user.isEmpty()){
                    signupEmail.setError("Email cannot be empty");
                }
                if(pass.isEmpty()){
                    signupPassword.setError("Password cannot be empty");
                }else{
                    // Firebase
//                    auth.createUserWithEmailAndPassword(user, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                        @Override
//                        public void onComplete(@NonNull Task<AuthResult> task) {
//                            if(task.isSuccessful()){
//                                Toast.makeText(SignUpActivity.this,"SignUp Successful", Toast.LENGTH_SHORT).show();
//                                startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
//                            }else{
//                                Toast.makeText(SignUpActivity.this, "Signup Failed"+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                    });

                    //Database
                    Call<User> call = apiService.createUser(new User("a","a","a","a","a","a",1,1));
                    call.enqueue(new Callback<User>() {
                        @Override
                        public void onResponse(Call<User> call, Response<User> response) {
                            if(response.isSuccessful()){
                                   Toast.makeText(SignUpActivity.this,"Đăng ký thành công",Toast.LENGTH_LONG).show();
                            }else{
                                Toast.makeText(SignUpActivity.this,"Đăng ký thất bại",Toast.LENGTH_LONG).show();
                                Log.i("TAG","fail");
                                System.out.println("Zoo - Errors");
                            }
                        }
                        @Override
                        public void onFailure(Call<User> call, Throwable t) {
                            Log.i("TAG", t.toString());
                            System.out.println("Zoo - Errors");
                        }
                    });


                }
            }
        });

        loginRedirecText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUpActivity.this,LoginActivity.class));
            }
        });
    }
}