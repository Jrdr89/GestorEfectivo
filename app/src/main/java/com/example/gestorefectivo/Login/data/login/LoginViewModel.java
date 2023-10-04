package com.example.gestorefectivo.Login.data.login;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.util.Patterns;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.gestorefectivo.Conexion.ApiService;
import com.example.gestorefectivo.Conexion.Constants;
import com.example.gestorefectivo.R;
import com.example.gestorefectivo.Login.data.data.LoginRepository;
import com.example.gestorefectivo.Login.data.data.Result;
import com.example.gestorefectivo.Login.data.data.LoggedInUser;
import com.example.gestorefectivo.Vistas.MainActivity;
import com.example.gestorefectivo.Vistas.ProyectoActivity;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class LoginViewModel extends ViewModel{

    private MutableLiveData<LoginFormState> loginFormState = new MutableLiveData<>();
    private MutableLiveData<LoginResult> loginResult = new MutableLiveData<>();
    private LoginRepository loginRepository;

    private Context context;
    LoginViewModel(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    LiveData<LoginFormState> getLoginFormState() {
        return loginFormState;
    }

    LiveData<LoginResult> getLoginResult() {
        return loginResult;
    }

    public void login(String username, String password) {
    // El servidor respondió exitosamente, puedes continuar con el inicio de sesión
        Result<LoggedInUser> result = loginRepository.login(username, password);
        Retrofit retrofit;
        // Configura Retrofit
           retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        // Crea una instancia de la interfaz ApiService
        ApiService apiService = retrofit.create(ApiService.class);
        // Realiza la solicitud al servidor PHP
        Call<Void> call = apiService.checkConnection();
        try{
            call.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    if (response.isSuccessful()) {
                        Call<Boolean> callVC = apiService.verificarCredenciales(username, password);
                        callVC.enqueue(new Callback<Boolean>() {
                            @Override
                            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                                if (response.isSuccessful() && response.body() != null) {
                                    Boolean credencialesCorrectas = response.body();
                                    if (credencialesCorrectas != null && credencialesCorrectas) {
                                        if (result instanceof Result.Success) {
                                            LoggedInUser data = ((Result.Success<LoggedInUser>) result).getData();
                                            loginResult.setValue(new LoginResult(new LoggedInUserView(data.getDisplayName())));
                                            Intent intent = new Intent(context, ProyectoActivity.class);
                                            context.startActivity(intent);
                                        }
                                    } else {
                                        loginResult.setValue(new LoginResult(R.string.login_failed));
                                        Intent intent = new Intent(context, LoginActivity.class);
                                        Toast.makeText(context, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
                                        context.startActivity(intent);
                                    }
                                } else {
                                    int httpStatusCode = response.code(); // Obtiene el código de respuesta HTTP
                                    String errorMessage = "Error en la solicitud HTTP. Código: " + httpStatusCode;
                                    Log.e("HTTP Error", errorMessage);
                                    try {
                                        String errorBody = response.errorBody().string(); // Obtiene el cuerpo de la respuesta de error
                                        Log.e("Error Body", errorBody);
                                        // Puedes analizar errorBody si esperas que sea un JSON y contiene detalles de error estructurados
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    loginResult.setValue(new LoginResult(R.string.login_failed));
                                    Intent intent = new Intent(context, LoginActivity.class);
                                    Toast.makeText(context, "Fallo de conexión", Toast.LENGTH_SHORT).show();
                                    context.startActivity(intent);
                                }
                            }

                            @Override
                            public void onFailure(Call<Boolean> call, Throwable t) {
                                // Error en la solicitud, como problemas de red o conexión al servidor
                                Log.e("Network Error", t.getMessage(), t);
                                loginResult.setValue(new LoginResult(R.string.login_failed));
                                Intent intent = new Intent(context, LoginActivity.class);
                                Toast.makeText(context, "Fallo en comprobación de credenciales", Toast.LENGTH_SHORT).show();
                                context.startActivity(intent);
                            }
                        });
                    } else {
                        // Maneja el error aquí si es necesario
                        loginResult.setValue(new LoginResult(R.string.login_failed));
                        Intent intent = new Intent(context, LoginActivity.class);
                        Toast.makeText(context, "Error de conexión", Toast.LENGTH_SHORT).show();
                        context.startActivity(intent);
                    }
                }


                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    Log.e("Network Error", t.getMessage(), t);
                    loginResult.setValue(new LoginResult(R.string.login_failed));
                }
            });
        }catch (Exception ex){
            ex.getMessage();
        }

    }

    public void loginDataChanged(String username, String password) {
        if (!isUserNameValid(username)) {
            loginFormState.setValue(new LoginFormState(R.string.invalid_username, null));
        } else if (!isPasswordValid(password)) {
            loginFormState.setValue(new LoginFormState(null, R.string.invalid_password));
        } else {
            loginFormState.setValue(new LoginFormState(true));
        }
    }

    // A placeholder username validation check
    private boolean isUserNameValid(String username) {
        if (username == null) {
            return false;
        }
        if (username.contains("@")) {
            return Patterns.EMAIL_ADDRESS.matcher(username).matches();
        } else {
            return !username.trim().isEmpty();
        }
    }

    // A placeholder password validation check
    private boolean isPasswordValid(String password) {
        return password != null && password.trim().length() > 5;
    }
}