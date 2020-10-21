package com.lib.share_lib.strategy.wechat.share.strategy

import com.lib.share_lib.strategy.wechat.WeChatStrategy
import com.tencent.mm.opensdk.openapi.IWXAPI

/**
 * @author yudenghao
 * @date 2020/10/21
 */
abstract class ShareActionContext : ShareActionStrategy<IWXAPI> {

    fun onResp(code: Int, message: String?) {
        WeChatStrategy.INSTANCE.onResp(code, message)
    }

    fun getExtensionData(key: String, data: Map<Any, Any>?): Any? {
        return if (data != null && data.containsKey(key)) {
            data[key]
        } else {
            null
        }
    }
}