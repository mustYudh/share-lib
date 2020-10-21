package com.lib.share_lib.strategy.wechat.share

import android.content.Context
import com.lib.share_lib.channel.ShareChannel
import com.lib.share_lib.client.ShareClient
import com.lib.share_lib.data.ConstKey
import com.lib.share_lib.data.ShareEntityAdapter
import com.lib.share_lib.strategy.wechat.share.strategy.ShareActionContext
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject
import com.tencent.mm.opensdk.openapi.IWXAPI


/**
 * @author yudenghao
 * @date 2020/10/21
 */
class ShareMiniProgram : ShareActionContext() {

    override fun doAction(context: Context?, wxApi: IWXAPI?, shareEntity: ShareEntityAdapter?, vararg args: Any?) {
        val miniProgramObj = WXMiniProgramObject()
        miniProgramObj.webpageUrl = shareEntity?.getShareUrl()
        miniProgramObj.miniprogramType = ShareClient.PROGRAM_TYPE.type
        val userName = getExtensionData(ConstKey.MINI_PROGRAM_USER_NAME, shareEntity?.extensionData()) as String
        val path = getExtensionData(ConstKey.MINI_PROGRAM_PATH, shareEntity?.extensionData()) as String
        miniProgramObj.userName = userName     // 小程序原始id
        miniProgramObj.path = path            //小程序页面路径；对于小游戏，可以只传入 query 部分，来实现传参效果，如：传入 "?foo=bar"
        val msg = WXMediaMessage(miniProgramObj)
        msg.title = shareEntity?.getShareTitle()
        msg.description = shareEntity?.getShareDescription()
        msg.thumbData = shareEntity?.getShareThumb()
        val req = SendMessageToWX.Req()
        req.transaction = "${System.currentTimeMillis()}_${ShareChannel.WE_CHAT}_miniProgram"
        req.message = msg;
        req.scene = SendMessageToWX.Req.WXSceneSession;  // 目前只支持会话
        wxApi?.sendReq(req);
    }
}