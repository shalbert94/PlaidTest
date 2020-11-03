package app.pennyworth.core

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.plaid.link.Plaid
import com.plaid.link.configuration.LinkLogLevel
import com.plaid.link.linkTokenConfiguration
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    companion object {
        //Todo (1/1): Replace link token
        const val PLAID_LINK_TOKEN = "link-sandbox-0e1b014c-b0e8-47e6-bece-e22e56f217c7"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.openPlaidLinkButton).setOnClickListener { onClickOpenPlaidLinkButton() }
    }

    private fun onClickOpenPlaidLinkButton() {
        val linkTokenConfiguration = linkTokenConfiguration {
            token = PLAID_LINK_TOKEN
            logLevel = LinkLogLevel.VERBOSE
        }

        val plaidHandler = Plaid.create(application, linkTokenConfiguration)

        plaidHandler.open(this)
    }
}