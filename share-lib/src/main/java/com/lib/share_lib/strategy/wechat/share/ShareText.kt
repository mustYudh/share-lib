package com.lib.share_lib.strategy.wechat.share

import android.content.Context
import com.lib.share_lib.channel.ShareChannel
import com.lib.share_lib.data.ConstKey
import com.lib.share_lib.data.ShareEntityAdapter
import com.lib.share_lib.strategy.wechat.share.strategy.ShareActionContext
import com.lib.share_lib.strategy.wechat.share.strategy.ShareActionStrategy
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage
import com.tencent.mm.opensdk.modelmsg.WXTextObject
import com.tencent.mm.opensdk.openapi.IWXAPI

/**
 * @author yudenghao
 * @date 2020/10/21
 */

class ShareText : ShareActionContext() {

    override fun doAction(context: Context?, wxApi: IWXAPI?, shareEntity: ShareEntityAdapter?, vararg args: Any?) {
        val textObj = WXTextObject()
        textObj.text = shareEntity?.getShareDescription()
        val msg = WXMediaMessage()
        msg.mediaObject = textObj
        msg.description = shareEntity?.getShareDescription()
        val req = SendMessageToWX.Req()
        val scene = getExtensionData(ConstKey.WE_CHAT_CHANNEL, shareEntity?.extensionData()) as Int
        req.transaction = "${System.currentTimeMillis()}_${ShareChannel.WE_CHAT}_text"
        req.message = msg
        req.scene = scene
        wxApi?.sendReq(req)
    }

}