package com.lib.share_lib.data


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

}