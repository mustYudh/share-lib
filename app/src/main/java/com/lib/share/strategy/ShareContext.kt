package com.lib.share.strategy

import com.lib.share.ShareFactory
import com.lib.share.channel.ShareChannel
import com.lib.share.strategy.impl.StrategyOptions

/**
 * @author yudenghao
 * @date 2020/10/20
 */

 abstract class ShareContext(channel: ShareChannel): StrategyOptions ,ShareFactory {

    private var mType: ShareChannel = channel

    override fun shareTypeOptions(type: ShareChannel): Boolean {
        return type == mType
    }

    override fun getShareFactory(): ShareFactory {
        return this
    }

}