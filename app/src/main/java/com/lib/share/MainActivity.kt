package com.lib.share

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lib.share.channel.ShareChannel
import com.lib.share.client.ShareClient
import com.lib.share.data.ProgramType
import com.lib.share.data.ShareEntity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val client: ShareClient = ShareClient.Companion.Builder(this)
            .setProgramType(ProgramType.RELEASE)
            .addShareStrategy(ShareChannel.WE_CHAT)
            .addShareStrategy(ShareChannel.WE_CHAT_FRIEND)
            .addShareStrategy(ShareChannel.WE_CHAT_CIRCLE)
            .initWeChatConfig("")
            .addShareData(ShareEntity())
            .build()
        client.share(ShareChannel.WE_CHAT) {
            onSuccess {

            }
            onCancel {

            }
            onFailed { code, errorMessage, error ->

            }
        }

    }
}