package com.lib.share_lib.strategy.wechat

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.tencent.mm.opensdk.constants.ConstantsAPI
import com.tencent.mm.opensdk.modelbase.BaseReq
import com.tencent.mm.opensdk.modelbase.BaseResp
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler

/**
 * @author yudenghao
 * @date 2020/10/21
 */
open class WXEntryActivity : Activity(), IWXAPIEventHandler {

    override fun onResp(p0: BaseResp?) {
        if (p0?.type == ConstantsAPI.COMMAND_SENDMESSAGE_TO_WX) {
            WeChatStrategy.INSTANCE.onResp(p0.errCode, p0.errStr)
            finish()
        }
    }


    override fun onReq(p0: BaseReq?) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WeChatStrategy.INSTANCE.wxApi?.handleIntent(intent, this)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        WeChatStrategy.INSTANCE.wxApi?.handleIntent(intent, this)
    }
}