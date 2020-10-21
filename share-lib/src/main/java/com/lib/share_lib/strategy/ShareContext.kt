package com.lib.share_lib.strategy

import com.lib.share_lib.ShareFactory
import com.lib.share_lib.call.ShareCallback
import com.lib.share_lib.call.ShareResult
import com.lib.share_lib.channel.ShareChannel
import com.lib.share_lib.strategy.impl.StrategyOptions


/**
 * @author yudenghao
 * @date 2020/10/20
 */

abstract class ShareContext : StrategyOptions, ShareFactory {

    lateinit var mListener: ShareCallback

    fun register(shareCallback: ShareCallback.() -> Unit) {
        mListener = ShareCallback().also(shareCallback)
    }

    fun setResult(result: ShareResult) {
        if (::mListener.isInitialized) {
            when (result.resultState()) {
                ShareResult.ResultState.START -> mListener.mStart?.invoke()
                ShareResult.ResultState.CANCEL -> mListener.mCancel?.invoke()
                ShareResult.ResultState.SUCCESS -> mListener.mSuccess?.invoke()
                ShareResult.ResultState.FAIL -> mListener.mFailed?.invoke(
                    result.resultCode(),
                    result.resultMessage()
                )
            }
        }
    }



    override fun getShareFactory(): ShareFactory {
        return this
    }

}