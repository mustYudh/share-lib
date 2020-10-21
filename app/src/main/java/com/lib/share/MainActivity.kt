package com.lib.share

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.lib.share_lib.channel.ShareChannel
import com.lib.share_lib.client.ShareClient
import com.lib.share_lib.data.ProgramType
import com.lib.share_lib.data.ShareEntity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val client: ShareClient = ShareClient.Companion.Builder(this)
            .setProgramType(ProgramType.RELEASE)
            .addShareStrategy(ShareChannel.WE_CHAT)
            .initWeChatConfig("wxf8e46bdb8c126c11", "3fc21957263e18f19d6636072fed3187")
            .addShareData(ShareEntity())
            .build()

        client.share(ShareChannel.WE_CHAT) {
            onStart {
                Log.e("========>", "开始")
            }
            onSuccess {

            }
            onCancel {

            }
            onFailed { code, errorMessage ->

            }
        }

    }
}