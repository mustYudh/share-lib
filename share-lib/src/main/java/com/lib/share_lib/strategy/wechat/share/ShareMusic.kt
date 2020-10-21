package com.lib.share_lib.strategy.wechat.share

import android.content.Context
import com.lib.share_lib.channel.ShareChannel
import com.lib.share_lib.data.ConstKey
import com.lib.share_lib.data.ShareEntityAdapter
import com.lib.share_lib.strategy.wechat.share.strategy.ShareActionContext
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage
import com.tencent.mm.opensdk.modelmsg.WXMusicObject
import com.tencent.mm.opensdk.openapi.IWXAPI


/**
 * @author yudenghao
 * @date 2020/10/21
 */
class ShareMusic : ShareActionContext() {

    override fun doAction(context: Context?, wxApi: IWXAPI?, shareEntity: ShareEntityAdapter?, vararg args: Any?) {
        val music = WXMusicObject()
        music.musicUrl = shareEntity?.getShareUrl()
        val msg = WXMediaMessage()
        msg.mediaObject = music
        msg.title = shareEntity?.getShareTitle()
        msg.description = shareEntity?.getShareDescription()
        msg.thumbData = shareEntity?.getShareThumb()
        val req = SendMessageToWX.Req()
        val scene = getExtensionData(ConstKey.WE_CHAT_CHANNEL, shareEntity?.extensionData()) as Int
        val userOpenId =
            getExtensionData(ConstKey.WE_CHAT_USER_OPEN_ID, shareEntity?.extensionData())
        req.transaction = "${System.currentTimeMillis()}_${ShareChannel.WE_CHAT}_music"
        req.message = msg
        req.scene = scene;
        req.userOpenId = if (userOpenId != null) userOpenId as String else ""
        wxApi?.sendReq(req);
    }

}