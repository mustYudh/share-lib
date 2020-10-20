package com.lib.share_lib

import android.content.Context
import com.lib.share_lib.call.ShareCallback
import com.lib.share_lib.data.ShareEntityAdapter

/**
 * @author yudenghao
 * @date 2020/10/19
 */
 interface ShareFactory {

    fun share(context: Context?, shareEntity: ShareEntityAdapter?, shareCallback: ShareCallback.() -> Unit)

}