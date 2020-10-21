package com.lib.share_lib.strategy.wechat

import com.lib.share_lib.call.ShareResult
import com.tencent.mm.opensdk.modelbase.BaseResp

/**
 * @author yudenghao
 * @date 2020/10/20
 */
class WeChatShareResult(private var code: Int, private var message: String?) : ShareResult {

    override fun resultCode() = code

    companion object {
        const val START_CODE = -100001
    }

    override fun resultState(): ShareResult.ResultState {
        return when (code) {
            START_CODE -> ShareResult.ResultState.START
            BaseResp.ErrCode.ERR_OK -> ShareResult.ResultState.SUCCESS
            BaseResp.ErrCode.ERR_USER_CANCEL -> ShareResult.ResultState.CANCEL
            else -> ShareResult.ResultState.FAIL
        }
    }

    override fun resultMessage(): String? = message

}