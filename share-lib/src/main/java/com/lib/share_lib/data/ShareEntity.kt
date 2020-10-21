package com.lib.share_lib.data

import com.lib.share_lib.strategy.wechat.WeChatStrategy


/**
 * @author yudenghao
 * @date 2020/10/20
 */
class ShareEntity : ShareEntityAdapter {

    var title: String? = null
    var description: String? = null
    var thumb: ByteArray? = null
    var url: String? = null

    override fun getShareTitle(): String? {
        return this.title
    }

    override fun getShareDescription(): String? {
        return this.description
    }

    override fun getShareThumb(): ByteArray? {
        return this.thumb
    }

    override fun getShareUrl(): String? {
        return this.url
    }

    override fun extensionData(): Map<Any, Any> {
        val map: HashMap<Any,Any> = HashMap()
        map[ConstKey.SHARE_TYPE] = ShareType.TEXT
        return map
    }
}