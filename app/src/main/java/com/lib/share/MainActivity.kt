package com.lib.share

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
            .initWeChatConfig("12231124")
            .addShareData(ShareEntity())
            .build()

        client.share(ShareChannel.WE_CHAT) {
            onStart {

            }
            onSuccess {

            }
            onCancel {

            }
            onFailed { code, errorMessage, error ->

            }
        }

    }
}