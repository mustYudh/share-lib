package com.lib.share.data

import com.lib.share.channel.ShareChannel

/**
 * @author yudenghao
 * @date 2020/10/20
 */
interface ShareEntityAdapter {
    fun getShareTitle(): String?
    fun getShareDescription(): String?
    fun getShareThumb(): ByteArray?
    fun getShareUrl(): String?
}