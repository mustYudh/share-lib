package com.lib.share_lib.strategy

import com.lib.share_lib.ShareFactory
import com.lib.share_lib.call.ShareCallback
import com.lib.share_lib.channel.ShareChannel
import com.lib.share_lib.strategy.impl.StrategyOptions


/**
 * @author yudenghao
 * @date 2020/10/20
 */

 abstract class ShareContext(channel: ShareChannel): StrategyOptions, ShareFactory {

    lateinit var mListener: ShareCallback

    fun register(shareCallback: ShareCallback.() -> Unit) {
//        mListener = ShareCallback().also(shareCallback)
    }

    fun setResult() {
        if (::mListener.isInitialized)
    }

    private var mType: ShareChannel = channel

    override fun shareTypeOptions(type: ShareChannel): Boolean {
        return type == mType
    }

    override fun getShareFactory(): ShareFactory {
        return this
    }

}