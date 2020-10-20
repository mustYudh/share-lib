package com.lib.share.strategy.impl

import com.lib.share.channel.ShareChannel
import com.lib.share.ShareFactory

/**
 * @author yudenghao
 * @date 2020/10/20
 */
interface StrategyOptions {

    fun shareTypeOptions(type: ShareChannel): Boolean

    fun getShareFactory() : ShareFactory
}