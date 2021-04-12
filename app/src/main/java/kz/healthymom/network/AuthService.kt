package kz.healthymom.network

import kz.healthymom.data.model.response.BaseResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * created by: Makhanov Madiyar
 * on: 12.04.2021
 */
interface AuthService {
    @POST("signIn")
    suspend fun login(@Body body: MutableMap<String, Any>): Response<BaseResponse<Any>>
}