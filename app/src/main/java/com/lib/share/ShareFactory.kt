package com.lib.share

import android.content.Context
import com.lib.share.call.ShareCallback
import com.lib.share.data.ShareEntityAdapter

/**
 * @author yudenghao
 * @date 2020/10/19
 */
 interface ShareFactory {

    fun share(context: Context?, shareEntity: ShareEntityAdapter?,shareCallback: ShareCallback.() -> Unit)

}