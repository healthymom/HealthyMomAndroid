package kz.healthymom.data.model.response

/**
 * created by: Makhanov Madiyar
 * on: 12.04.2021
 */
sealed class NetResult<out T> {
    data class Success<out T>(val data: T) : NetResult<T>()
    data class Error(val errorMessage: String) : NetResult<Nothing>()
}