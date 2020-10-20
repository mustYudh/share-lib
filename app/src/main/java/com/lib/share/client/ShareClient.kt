package com.lib.share.client

import android.content.Context
import com.lib.share.channel.ShareChannel
import com.lib.share.call.ShareCallback
import com.lib.share.channel.ChannelFactory
import com.lib.share.data.ProgramType
import com.lib.share.data.ShareEntityAdapter
import com.lib.share.strategy.impl.StrategyOptions

/**
 * @author yudenghao
 * @date 2020/10/20
 */
class ShareClient(
    private var context: Context?,
    private var shareContext: HashMap<ShareChannel, StrategyOptions>,
    private var shareEntity: ShareEntityAdapter?,
    private var wechatAppid: String,
    private var programType: ProgramType = ProgramType.RELEASE) {

    /**
     * 执行策略
     */
    fun share(channel: ShareChannel, shareCallback: ShareCallback.() -> Unit): ShareClient {
        if (shareContext.containsKey(channel) && shareContext[channel] != null) {
            val share = shareContext[channel]!!
            share.getShareFactory().share(context,shareEntity, shareCallback)
        }
        return this
    }

    fun newBuilder(): Builder {
        return Builder(context)
    }


    companion object {


        class Builder(private var context: Context?) {
            private var shareContext = HashMap<ShareChannel, StrategyOptions>()
            private var shareEntity: ShareEntityAdapter? = null
            private var wechatAppid: String = ""
            private var programType: ProgramType = ProgramType.RELEASE


            fun setProgramType(programType: ProgramType): Builder {
                this.programType = programType
                return this
            }

            /**
             * 添加策略
             */

            fun addShareStrategy(channel: ShareChannel): Builder {
                if (!this.shareContext.containsKey(channel) || this.shareContext[channel] != null) {
                    this.shareContext[channel] = ChannelFactory.get(channel)
                }
                return this
            }


            fun addShareStrategy(shareContext: HashMap<ShareChannel, StrategyOptions>): Builder {
                this.shareContext = shareContext
                return this
            }

            fun addShareData(shareEntity: ShareEntityAdapter): Builder {
                this.shareEntity = shareEntity
                return this
            }


            fun build(): ShareClient {
                return ShareClient(context, shareContext, shareEntity, wechatAppid, programType)
            }

            fun initWeChatConfig(appId: String): Builder {
                this.wechatAppid = appId
                return this
            }
        }
    }
}