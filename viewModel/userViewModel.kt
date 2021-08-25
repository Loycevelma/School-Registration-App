package viewModel

import Repository.userRepositiry
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.registration.LoginRequest
import com.example.registration.LoginResponse
import com.example.registration.RegistrationRequest
import com.example.registration.RegistrationResponse
import kotlinx.coroutines.launch

class UserViewModel : ViewModel(){
    var userRepository= userRepositiry()
    var registrationResponseLiveData= MutableLiveData<RegistrationResponse>()
    var regErrorLiveData=MutableLiveData<String>()
    var loginResponseLiveData=MutableLiveData<LoginResponse>()
    var logErrorLiveData=MutableLiveData<String>()



    fun registerStudent(registrationRequest: RegistrationRequest){
        viewModelScope.launch {
            var response=userRepository.registerUser(registrationRequest)
            if (response.isSuccessful){
                registrationResponseLiveData.postValue(response.body())
            }
            else{
                regErrorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
    fun loginStudent(loginRequest: LoginRequest){
        viewModelScope.launch {
            var response=userRepository.loginUser(loginRequest)
            if (response.isSuccessful){
                loginResponseLiveData.postValue(response.body())
            }
            else{
                logErrorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}

