package com.lib.share_lib.channel

import com.lib.share_lib.strategy.impl.StrategyOptions
import com.lib.share_lib.strategy.wechat.WeChatStrategy


/**
 * @author yudenghao
 * @date 2020/10/20
 */
 class ChannelStrategyFactory {

    companion object {
        fun get(channel: ShareChannel): StrategyOptions {
           return when(channel) {
                ShareChannel.WE_CHAT -> WeChatStrategy(channel)
           }
        }
    }
}