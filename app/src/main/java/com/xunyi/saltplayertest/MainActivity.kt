package com.xunyi.saltplayertest

import SampleData
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.xunyi.saltplayertest.ui.theme.ComposeTutorialTheme
import com.xunyi.saltplayertest.ui.theme.SaltPlayerTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            /*         SaltPlayerTestTheme {
                         // A surface container using the 'background' color from the theme
                         Surface(
                             modifier = Modifier.fillMaxSize(),
                             color = MaterialTheme.colorScheme.background
                         ) {
                             Greeting("Android")
                         }
                     }*/
            ComposeTutorialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    MyMessageCard(Message("lilei", "wanghua"))
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) { message ->
            MyMessageCard(message)
        }
    }
}

@Preview
@Composable
fun PreviewConversation() {
    ComposeTutorialTheme {
        Surface {
            Conversation(SampleData.conversationSample)
        }
    }
}

data class Message(val author: String, val body: String)

@Composable
fun MyMessageCard(msg: Message) {
    Row(modifier = Modifier.padding(all = 8.dp)) {//横
        Image(
            painter = painterResource(id = R.drawable.smartcat),
            contentDescription = "hello",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column() {
            Text(
                text = msg.author, color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(modifier = Modifier.height(4.dp)) //注意还有个属性呢

            Surface(shape = MaterialTheme.shapes.medium, shadowElevation = 1.dp) {
                Text(
                    text = msg.body,
                    modifier = Modifier.padding(all = 4.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
            }

        }
    }


}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true,
    name = "Dark Mode"
)
@Composable
fun GreetingPreview() {
    SaltPlayerTestTheme {
        Surface {
            MyMessageCard(msg = Message("lilei", "wanghua"))
        }
    }
    /*     SaltPlayerTestTheme {
             Greeting("Android")
         }*/
    /*   MyMessageCard(
           msg = Message("lilei", "wanghuas")
       )*/
}