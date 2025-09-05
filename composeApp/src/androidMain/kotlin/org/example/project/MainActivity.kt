package org.example.project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import learn_app.composeapp.generated.resources.Res
import learn_app.composeapp.generated.resources.lexend_bold
import learn_app.composeapp.generated.resources.lexend_extra_bold
import learn_app.composeapp.generated.resources.lexend_extra_light
import learn_app.composeapp.generated.resources.lexend_light
import learn_app.composeapp.generated.resources.lexend_medium
import learn_app.composeapp.generated.resources.lexend_regular
import learn_app.composeapp.generated.resources.lexend_semi_bold
import learn_app.composeapp.generated.resources.lexend_thin
import org.jetbrains.compose.resources.Font


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            val fontFamily = FontFamily(
                Font( Res.font.lexend_bold, weight = FontWeight.Bold),
                Font(Res.font.lexend_extra_bold, weight = FontWeight.ExtraBold),
                Font(Res.font.lexend_extra_light, weight = FontWeight.ExtraLight),
                Font(Res.font.lexend_light, weight = FontWeight.Light),
                Font(Res.font.lexend_medium, weight = FontWeight.Medium),
                Font(Res.font.lexend_regular, weight = FontWeight.Normal),
                Font(Res.font.lexend_semi_bold, weight = FontWeight.SemiBold),
                Font(Res.font.lexend_thin, weight = FontWeight.Thin),
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 40.dp)
                    .background(Color(0xFF101010))
            ) {
                Text(
                    text= buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = Color.Green,
                                fontSize = 50.sp
                            )
                        ){
                            append("H")
                        }
                        append("ello ")
                        withStyle(
                            style = SpanStyle(
                                color = Color.Green,
                                fontSize = 50.sp
                            )
                        ){
                            append("W")
                        }
                        append("orld!")
                    },
                    color = Color.White,
                    fontSize = 30.sp,
                    fontFamily = fontFamily,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                    textAlign = TextAlign.Center,
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