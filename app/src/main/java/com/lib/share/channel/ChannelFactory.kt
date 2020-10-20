package com.lib.share.channel

import com.lib.share.strategy.impl.StrategyOptions
import com.lib.share.strategy.wechat.WeChatStrategy

/**
 * @author yudenghao
 * @date 2020/10/20
 */
 class ChannelFactory {

    companion object {
        fun get(channel: ShareChannel): StrategyOptions {
           return when(channel) {
                ShareChannel.WE_CHAT -> WeChatStrategy(channel)
           }
        }
    }
}