package com.lib.share_lib.client

import android.content.Context
import com.lib.share_lib.call.ShareCallback
import com.lib.share_lib.channel.ChannelStrategyFactory
import com.lib.share_lib.channel.ShareChannel
import com.lib.share_lib.data.ProgramType
import com.lib.share_lib.data.ShareEntityAdapter
import com.lib.share_lib.strategy.ShareContext
import com.lib.share_lib.strategy.impl.StrategyOptions

/**
 * @author yudenghao
 * @date 2020/10/20
 */
class ShareClient(
    private var context: Context?,
    private var shareContext: HashMap<ShareChannel, StrategyOptions>,
    private var shareEntity: ShareEntityAdapter?,
    weChatAppId: String,
    weChatAppKey: String,
    programType: ProgramType = ProgramType.RELEASE
) {


    init {
        WE_CHAT_APP_ID = weChatAppId
        WE_CHAT_APP_KEY = weChatAppKey
        PROGRAM_TYPE = programType
    }

    /**
     * 执行策略
     */
    fun share(channel: ShareChannel, shareCallback: ShareCallback.() -> Unit): ShareClient {
        if (shareContext.containsKey(channel) && shareContext[channel] != null) {
            val share = shareContext[channel]!!
            share.getShareFactory().share(context, shareEntity, shareCallback)
        }
        return this
    }

    fun newBuilder(): Builder {
        return Builder(context)
    }


    companion object {
        var WE_CHAT_APP_ID: String = ""
        var WE_CHAT_APP_KEY: String = ""
        var PROGRAM_TYPE: ProgramType = ProgramType.RELEASE

        class Builder(private var context: Context?) {
            private var shareContext = HashMap<ShareChannel, StrategyOptions>()
            private var shareEntity: ShareEntityAdapter? = null
            private var weChatAppId: String = ""
            private var weChatAppKey: String = ""
            private var programType: ProgramType = ProgramType.RELEASE


            fun setProgramType(programType: ProgramType): Builder {
                this.programType = programType
                return this
            }

            fun initWeChatConfig(appId: String, appKey: String): Builder {
                this.weChatAppId = appId
                this.weChatAppKey = appKey
                return this
            }

            fun addShareData(shareEntity: ShareEntityAdapter): Builder {
                this.shareEntity = shareEntity
                return this
            }

            /**
             * 根据渠道添加现有策略
             */
            fun addShareStrategy(channel: ShareChannel): Builder {
                if (!this.shareContext.containsKey(channel) || this.shareContext[channel] != null) {
                    this.shareContext[channel] = ChannelStrategyFactory.get(channel)
                }
                return this
            }

            /**
             * 自定义策略
             */
            fun addShareStrategy(channel: ShareChannel, strategy: ShareContext) {
                shareContext[channel] = strategy
            }

            fun addShareStrategy(shareContext: HashMap<ShareChannel, StrategyOptions>): Builder {
                this.shareContext = shareContext
                return this
            }

            fun build(): ShareClient {
                return ShareClient(context, shareContext, shareEntity, weChatAppId,weChatAppKey, programType)
            }

        }
    }
}