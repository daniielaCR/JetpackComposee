package co.edu.sena.listasmensajesdani

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.clickable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.edu.sena.listasmensajesdani.ui.theme.ListasMensajesDaniTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListasMensajesDaniTheme() {
                Conversation(SampleData.conversationSample)
                Surface(modifier = Modifier.fillMaxSize(),color=MaterialTheme.colorScheme.error) {

                    MessageCard(Message (author = "Dani", body = "supersayyayinDani "))
                }

            }
        }
    }
}

data class Message(val author: String,val body:String)

@Composable
fun MessageCard(msg: Message) {

    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(id = R.drawable.goku),
            contentDescription = "contact profile picture",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colorScheme.scrim, CircleShape)
        )




            Spacer(modifier = Modifier.height(4.dp))
            var isExpanded by remember { mutableStateOf(false) }
            Surface(shape = MaterialTheme.shapes.medium, shadowElevation = 1.dp) {



                Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
                Text(
                    text = msg.body,
                    modifier = Modifier.padding(all = 4.dp),
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }

    }
}

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) { message ->
            MessageCard(message)
        }
    }
}

@Preview
@Composable
fun PreviewConversation() {
    ListasMensajesDaniTheme() {
        Surface(color=MaterialTheme.colorScheme.error) {
            Conversation(SampleData.conversationSample)
        
    }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewMessageCard() {
    ListasMensajesDaniTheme() {
        Surface() {
            MessageCard(Message("Daniela"," Hello, I am SuperSayayinn "))

        }

    }
}