package com.lib.share_lib.call


/**
 * @author yudenghao
 * @date 2020/10/20
 */
 interface ShareResult {

    fun resultCode(): Int

    fun resultState(): ResultState

    fun resultMessage(): String?


    enum class ResultState(val state: Int) {
        START(0),
        SUCCESS(1),
        CANCEL(2),
        FAIL(3)
    }
}