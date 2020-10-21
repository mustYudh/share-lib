package com.lib.share_lib.data

import com.tencent.mm.opensdk.modelmsg.SendMessageToWX

/**
 * @author yudenghao
 * @date 2020/10/21
 */
enum class WeChatSendMessageToType(private var code: Int) {

    TO_SESSION(SendMessageToWX.Req.WXSceneSession),
    TO_CIRCLE(SendMessageToWX.Req.WXSceneTimeline),
    TO_FAVORITE(SendMessageToWX.Req.WXSceneFavorite);

    fun getTypeCode():Int {
        return code
    }
}