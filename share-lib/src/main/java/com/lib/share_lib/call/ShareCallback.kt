package com.lib.share_lib.call

import java.lang.Exception

/**
 * @author yudenghao
 * @date 2020/10/19
 */
class ShareCallback {

     var mStart:(() -> Unit)? = null

    private var mSuccess: (() -> Unit)? = null

    private var mCancel: (() -> Unit)? = null

    private var mFailed: ((code: Int, errorMessage: String?, error: Exception) -> Unit)? = null

    fun onStart(action: () -> Unit) {
        this.mStart = action
    }

    fun onSuccess(action: () -> Unit) {
        this.mSuccess = action
    }

    fun onCancel(action: () -> Unit) {
        this.mCancel = action
    }

    fun onFailed(action: (code: Int, errorMessage: String?, error: Exception) -> Unit) {
        this.mFailed = action
    }
}