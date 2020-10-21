package com.lib.share_lib.strategy.wechat.share.factory

import com.lib.share_lib.data.ShareType
import com.lib.share_lib.strategy.wechat.share.*
import com.lib.share_lib.strategy.wechat.share.strategy.ShareActionContext

/**
 * @author yudenghao
 * @date 2020/10/21
 */
class ShareFactor {
    companion object {
        fun getShareStrategy(type: ShareType): ShareActionContext {
            return when (type) {
                ShareType.TEXT -> ShareText()
                ShareType.IMAGE -> ShareImage()
                ShareType.MUSIC -> ShareMusic()
                ShareType.VIDEO -> ShareVideo()
                ShareType.URL ->   ShareWebPage()
                ShareType.MINI_PROGRAM -> ShareMiniProgram()
                ShareType.FILE_PROVIDER -> ShareFileProvider()
            }
        }
    }
}