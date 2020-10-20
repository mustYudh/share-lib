package com.lib.share_lib.strategy.wechat

import android.content.Context
import android.util.Log
import com.lib.share_lib.call.ShareCallback
import com.lib.share_lib.channel.ShareChannel
import com.lib.share_lib.client.ShareClient
import com.lib.share_lib.data.ShareEntityAdapter
import com.lib.share_lib.strategy.ShareContext

/**
 * @author yudenghao
 * @date 2020/10/20
 */
class WeChatStrategy(channel: ShareChannel) : ShareContext(channel) {

    override fun share(context: Context?, shareEntity: ShareEntityAdapter?, shareCallback: ShareCallback.() -> Unit) {
        register(shareCallback)
    }

}