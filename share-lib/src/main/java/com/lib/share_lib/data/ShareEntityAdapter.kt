package com.lib.share_lib.data


/**
 * @author yudenghao
 * @date 2020/10/20
 */
interface ShareEntityAdapter {
    fun getShareTitle(): String?
    fun getShareDescription(): String?
    fun getShareThumb(): ByteArray?
    fun getShareUrl(): String?
    //自定义扩展
    fun extensionData(): Map<Any,Any> = HashMap()
}