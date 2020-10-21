package com.lib.share_lib.call

import java.lang.Exception

/**
 * @author yudenghao
 * @date 2020/10/19
 */
class ShareCallback {

     var mStart:(() -> Unit)? = null

     var mSuccess: (() -> Unit)? = null

     var mCancel: (() -> Unit)? = null

     var mFailed: ((code: Int, errorMessage: String?) -> Unit)? = null

    fun onStart(action: () -> Unit) {
        this.mStart = action
    }

    fun onSuccess(action: () -> Unit) {
        this.mSuccess = action
    }

    fun onCancel(action: () -> Unit) {
        this.mCancel = action
    }

    fun onFailed(action: (code: Int, errorMessage: String?) -> Unit) {
        this.mFailed = action
    }
}