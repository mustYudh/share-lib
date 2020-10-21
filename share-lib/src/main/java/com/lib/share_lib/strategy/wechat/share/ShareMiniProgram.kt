package com.lib.share_lib.strategy.wechat.share

import com.lib.share_lib.data.ShareEntityAdapter
import com.lib.share_lib.strategy.wechat.share.strategy.ShareActionContext
import com.lib.share_lib.strategy.wechat.share.strategy.ShareActionStrategy
import com.tencent.mm.opensdk.openapi.IWXAPI

/**
 * @author yudenghao
 * @date 2020/10/21
 */
class ShareMiniProgram: ShareActionContext() {

    override fun doAction(wxApi: IWXAPI?, shareEntity: ShareEntityAdapter?, vararg args: Any?) {

    }
}