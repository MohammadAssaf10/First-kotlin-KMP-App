package org.example.project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import learn_app.composeapp.generated.resources.Res
import learn_app.composeapp.generated.resources.image
import learn_app.composeapp.generated.resources.photo
import org.jetbrains.compose.resources.painterResource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            val painter = painterResource(Res.drawable.image)
            val painter1 = painterResource(Res.drawable.photo)

            Row(
                modifier = Modifier
                    .padding(vertical = 30.dp, horizontal = 10.dp)
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                ImageCard(
                    painter = painter,
                    contentDescription = "Hello World!",
                    title = "Hello World!",
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f)
                )
                Spacer(modifier = Modifier.width(10.dp))
                ImageCard(
                    painter = painter1,
                    contentDescription = "Hitman",
                    title = "Hitman",
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f)
                )
            }


        }
    }
}

@Composable
fun ImageCard(
    painter: Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(disabledElevation = 5.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 300f
                        )
                    )
            )
            Text(
                title,
                style = TextStyle(color = Color.White, fontSize = 16.sp),
                modifier = Modifier
                    .align(alignment = Alignment.BottomStart)
                    .padding(12.dp)
            )
        }

    }

}