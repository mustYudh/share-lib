package com.lib.share_lib.strategy.impl

import com.lib.share_lib.ShareFactory
import com.lib.share_lib.channel.ShareChannel


/**
 * @author yudenghao
 * @date 2020/10/20
 */
interface StrategyOptions {

    fun getShareFactory() : ShareFactory
}