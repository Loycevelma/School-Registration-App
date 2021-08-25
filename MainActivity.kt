

package com.example.registration

import android.content.Intent
import android.os.Bundle
import android.telecom.Call
import android.view.View
import android.widget.*
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import viewModel.UserViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val userViewModel: UserViewModel by viewModels()
    //    lateinit var etName:EditText
//    lateinit var etDOB:EditText
//    lateinit var spNationality:Spinner
//    lateinit var etIDNumber:EditText
//    lateinit var etPhoneNumber:EditText
//    lateinit var etEmail:EditText
//    lateinit var btnButton: Button
//    lateinit var progressBar:ProgressBar
    //    lateinit var etPassword:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        setContentView(binding.root)
        setUpSpinner()

    }
    fun setUpSpinner(){
//            ProgressBar=findViewById(R.id.ProgressBar)
//            etName=findViewById(R.id.etName)//casting views in the activity.
//            etDOB=findViewById(R.id.etDOB)
//            spNationality=findViewById(R.id.spNationality)
//            etIDNumber=findViewById(R.id.etIDNumber)
//            etPhoneNumber=findViewById(R.id.etPhoneNumber)
//            etEmail=findViewById(R.id.etEmail)
//            btnButton=findViewById(R.id.btnButton)
//            etPassword=findViewById<EditText>(R.id.etPassword)

        var Nationality= arrayOf("Kenyan","Rwandan","South Sudan","Sudanese","Ugandan")
        var nationalityAdapter=ArrayAdapter(baseContext,android.R.layout.simple_spinner_dropdown_item,Nationality)
        nationalityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spNationality.adapter=nationalityAdapter
        onClick()
    }

    fun onClick() {
        binding.btnButton.setOnClickListener {
            binding.ProgressBar.visibility=View.VISIBLE
            var name = binding.etName.text.toString()
            var dob = binding.etDOB.text.toString()
            var nationality = binding.spNationality.selectedItem.toString().uppercase()
            var password = binding.etPassword.text.toString()
            var phone = binding.etPhoneNumber.text.toString()
            var email = binding.etEmail.text.toString()
            if(name.isEmpty()||dob.isEmpty()||password.isEmpty()||phone.isEmpty()||email.isEmpty()){
                binding.etName.setError("please enter your name")
                binding.etDOB.setError("Please enter your date of birth")
                binding.etPassword.setError("You must enter you ID number")
                binding.etPhoneNumber.setError("please enter your phone number")
                binding.etEmail.setError("please enter your email")
                Toast.makeText(baseContext,"This are your details :",Toast.LENGTH_LONG).show()
            }

            var intent=Intent(baseContext, LoginActivity::class.java)
            startActivity(intent)
//            var intent=Intent(baseContext, CodeHiveRegistration::class.java)
//            startActivity(intent)
            var regRequest= RegistrationRequest(
                name=name,phoneNumber = phone,email = email,dateOfBirth = dob,nationality = nationality,password = password
            )

            userViewModel.registerStudent(regRequest)
        }
    }


//        fun clickRegister() {
//            //onclick listener for button
//            binding.btnButton.setOnClickListener {
//                var name=binding.etName.text.toString()
//                //Toast.makeText(baseContext,name,Toast.LENGTH_LONG).show()//toasting
//                var dob=binding.etDOB.text.toString()
//                var nationality=""
//                var idnumber=binding.etIDNumber.text.toString()
//                var phonenumber=binding.etPhoneNumber.text.toString()
//                var emailaddress=binding.etEmail.text.toString()
//
////                var details=Details(name,dob,nationality,idnumber,phonenumber,email)
////                var intent=Intent(baseContext,CoursesActivity::class.java)
////                startActivity(intent)
//            }
//        }
//    }


    override fun onResume(){
        super.onResume()
        userViewModel.registrationResponseLiveData.observe(this,{
                RegistrationResponse->
            binding.ProgressBar.visibility=View.GONE
            if (!RegistrationResponse.studentId.isNullOrEmpty()){
                Toast.makeText(baseContext,"Registration successful",Toast.LENGTH_LONG).show()
            }
        })
        userViewModel.regErrorLiveData.observe(this, { error->
            binding.ProgressBar.visibility=View.GONE
            Toast.makeText(baseContext,"Registration is unsuccessful",Toast.LENGTH_LONG).show()
        }
        )


    }    }

//data class to hold all data.
data class Details(var Name:String,var DOB:String,var Nationality:String,var IDNumber:String,var PhoneNumber:String,var Email:String)

