package com.lib.share_lib.strategy.wechat.share.strategy

import com.lib.share_lib.data.ShareEntityAdapter

/**
 * @author yudenghao
 * @date 2020/10/21
 */
interface ShareActionStrategy<T> {


    fun  doAction(wxApi: T?, shareEntity: ShareEntityAdapter?, vararg args: Any?)
}