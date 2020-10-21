package com.lib.share_lib.strategy.wechat

import android.content.Context
import com.lib.share_lib.call.ShareCallback
import com.lib.share_lib.client.ShareClient
import com.lib.share_lib.data.ShareEntityAdapter
import com.lib.share_lib.data.ShareType
import com.lib.share_lib.strategy.ShareContext
import com.lib.share_lib.strategy.wechat.WeChatShareResult.Companion.START_CODE
import com.lib.share_lib.strategy.wechat.share.factory.ShareFactor
import com.tencent.mm.opensdk.modelbase.BaseResp
import com.tencent.mm.opensdk.openapi.IWXAPI
import com.tencent.mm.opensdk.openapi.WXAPIFactory

/**
 * @author yudenghao
 * @date 2020/10/20
 */
class WeChatStrategy : ShareContext() {

    private var wxApi: IWXAPI? = null

    companion object {
        const val SHARE_TYPE = "share_type"
        val INSTANCE: WeChatStrategy by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            WeChatStrategy()
        }
    }


    override fun share(context: Context?, shareEntity: ShareEntityAdapter?, shareCallback: ShareCallback.() -> Unit) {
        register(shareCallback)
        onResp(START_CODE, "")
        if (wxApi == null) {
            wxApi =
                WXAPIFactory.createWXAPI(context?.applicationContext, ShareClient.WE_CHAT_APP_ID)
            wxApi?.registerApp(ShareClient.WE_CHAT_APP_ID)
        }
        wxApi?.let {
            if (!it.isWXAppInstalled) {
                onResp(BaseResp.ErrCode.ERR_SENT_FAILED, "app not installed")
                return
            }
        }
        val extension: Map<Any, Any>? = shareEntity?.extensionData()
        if (extension != null && extension.containsKey(SHARE_TYPE) && extension[SHARE_TYPE] != null) {
            ShareFactor.getShareStrategy(extension[SHARE_TYPE] as ShareType)
                .doAction(wxApi, shareEntity)
        }
    }

    private fun onResp(code: Int, message: String?) {
        setResult(WeChatShareResult(code, message))
    }
}