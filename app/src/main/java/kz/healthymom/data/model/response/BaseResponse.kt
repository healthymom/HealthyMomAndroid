package kz.healthymom.data.model.response

/**
 * created by: Makhanov Madiyar
 * on: 12.04.2021
 */
class BaseResponse<T>(
    private val success: Boolean = false,
    private val msg: String? = null,
    private val msgType: String? = null,
    private val data: T? = null
) {
    fun getResult(): NetResult<T> {
        return if (success) {
            if (data == null) NetResult.Error("data is null")
            else NetResult.Success(data)
        } else {
            NetResult.Error("$msgType: $msg")
        }
    }
}