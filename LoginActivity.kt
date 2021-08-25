package com.example.registration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.example.registration.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding:Activit
    val userViewModel: UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        logInStudent()
    }

    fun logInStudent(){
        var etEmail=binding.tilusername.text.toString()
        var etPassword=binding.tilpassword.text.toString()
        binding.btnlogin.setOnClickListener {
            if (etEmail.isEmpty()){
                binding.tilusername.setError("This field is compulsory")
            }
            if (etPassword.isEmpty()){
                binding.tilpassword.setError("This field is compulsory")
            }

            var intent= Intent(baseContext, Registration::class.java)
            startActivity(intent)
        }
        val loginRequest=LoginRequest(
            email=etEmail,password = etPassword
        )
        userViewModel.loginStudent(loginRequest)

//        var retrofit=ApiClient.buildApiClient(ApiInterface::class.java)
//        var request=retrofit.logInStudent(loginRequest)
//        request.enqueue(object : Callback<LoginResponse> {
//            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
//                if (response.isSuccessful) {
//                    Toast.makeText(baseContext, "your login was succesful!", Toast.LENGTH_LONG)
//                        .show()
//                } else {
//                    try {
//                        val error = JSONObject(response.errorBody()!!.string())
//                        Toast.makeText(baseContext, error.toString(), Toast.LENGTH_LONG).show()
//                    }
//                    catch (e:Exception){
//                        Toast.makeText(baseContext, e.message, Toast.LENGTH_LONG).show()
//
//                    }
//                }
//            }
//
//            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
//                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
//
//            }
//        })

    }

    override fun onResume(){
        super.onResume()
        userViewModel.registrationResponseLiveData.observe(this,{
                RegistrationResponse-> binding.ProgressBar.visibility= View.GONE
            if (!RegistrationResponse.studentId.isNullOrEmpty()){
                Toast.makeText(baseContext,"Registration successful",Toast.LENGTH_LONG).show()
            }
        })
        userViewModel.regErrorLiveData.observe(this, { error->
            binding.progressBar3.visibility= View.GONE
            Toast.makeText(baseContext,"Registration is unsuccessful", Toast.LENGTH_LONG).show()
        }
        )


    }
}

