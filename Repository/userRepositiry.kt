package Repository

import com.example.registration.*
import com.google.rpc.context.AttributeContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class userRepositiry {


    val retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
    suspend fun registerUser(registrationRequest: RegistrationRequest):
            Response<RegistrationResponse> =
        withContext(Dispatchers.IO) {
            var response = retrofit.registerStudent(registrationRequest)
            return@withContext response
        }

    suspend fun loginUser(loginRequest: LoginRequest):
            Response<LoginResponse> = withContext(Dispatchers.IO) {
        var response = retrofit.studentLogin(loginRequest)
        return@withContext response
    }
}