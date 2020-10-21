package com.lib.share_lib.strategy.wechat.share

import android.R
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.lib.share_lib.channel.ShareChannel
import com.lib.share_lib.data.ConstKey
import com.lib.share_lib.data.ShareEntityAdapter
import com.lib.share_lib.strategy.wechat.share.strategy.ShareActionContext
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX
import com.tencent.mm.opensdk.modelmsg.WXImageObject
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage
import com.tencent.mm.opensdk.openapi.IWXAPI


/**
 * @author yudenghao
 * @date 2020/10/21
 */
class ShareImage : ShareActionContext() {

    override fun doAction(context: Context?, wxApi: IWXAPI?, shareEntity: ShareEntityAdapter?, vararg args: Any?) {
        val bmp = getExtensionData(ConstKey.IMG_RESOURCES, shareEntity?.extensionData()) as Bitmap
        val imgObj = WXImageObject(bmp)
        val msg = WXMediaMessage()
        msg.mediaObject = imgObj
        bmp.recycle()
        msg.thumbData = shareEntity?.getShareThumb()
        val scene = getExtensionData(ConstKey.WE_CHAT_CHANNEL, shareEntity?.extensionData()) as Int
        val userOpenId =
            getExtensionData(ConstKey.WE_CHAT_USER_OPEN_ID, shareEntity?.extensionData())
        val req = SendMessageToWX.Req()
        req.transaction = "${System.currentTimeMillis()}_${ShareChannel.WE_CHAT}_img"
        req.message = msg
        req.scene = scene
        req.userOpenId = if (userOpenId != null) userOpenId as String else ""
        wxApi?.sendReq(req)
    }

}