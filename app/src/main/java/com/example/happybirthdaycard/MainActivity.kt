package com.example.happybirthdaycard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthdaycard.ui.theme.HappyBirthdayCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HappyBirthdayCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeArticle()
                }
            }
        }
    }
}

@Composable
fun ComposeArticle(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        ArticleImage(
            articleImage = painterResource(R.drawable.bg_compose_background),
            modifier = Modifier.fillMaxWidth()
        )
        ArticleDetails(
            articleText = "Jetpack Compose tutorial",
            modifier = Modifier.padding(16.dp),
            articleTextStyle = TextStyle(
                fontSize = 24.sp
            )
        )
        ArticleDetails(
            articleText = stringResource(R.string.txt_article_description),
            modifier = Modifier.padding(horizontal = 16.dp),
            articleTextStyle = TextStyle(
                textAlign = TextAlign.Justify
            )
        )
        ArticleDetails(
            articleText = stringResource(R.string.txt_article_details),
            modifier = Modifier.padding(16.dp),
            articleTextStyle = TextStyle(
                textAlign = TextAlign.Justify
            )
        )
    }
}

@Composable
fun ArticleImage(
    articleImage: Painter,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier,
        painter = articleImage,
        contentDescription = null
    )
}

@Composable
fun ArticleDetails(
    articleText: String,
    modifier: Modifier = Modifier,
    articleTextStyle: TextStyle = TextStyle.Default
) {
    Text(
        modifier = modifier,
        text = articleText,
        style = articleTextStyle
    )

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HappyBirthdayCardTheme {
        ComposeArticle()
    }
}