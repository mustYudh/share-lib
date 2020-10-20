package com.lib.share.strategy.wechat

import android.content.Context
import android.util.Log
import com.lib.share.channel.ShareChannel
import com.lib.share.ShareFactory
import com.lib.share.call.ShareCallback
import com.lib.share.data.ShareEntityAdapter
import com.lib.share.strategy.ShareContext

/**
 * @author yudenghao
 * @date 2020/10/20
 */
class WeChatStrategy(channel: ShareChannel) : ShareContext(channel) {

    

    override fun share(context: Context?, shareEntity: ShareEntityAdapter?, shareCallback: ShareCallback.() -> Unit) {

    }

}