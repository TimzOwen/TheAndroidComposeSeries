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
                    ComposeApp()
                }
                }
            }
        }
    }

    @Composable
    fun ComposeApp() {
        ComposeArticleCard(
            image = painterResource(R.drawable.bg_compose_background),
            title = stringResource(R.string.text_article_titile),
            shortText = stringResource(R.string.text_article_short),
            longText = stringResource(R.string.text_article_long)
        )
    }

    @Composable
    fun ComposeArticleCard(
        modifier: Modifier = Modifier,
        image: Painter,
        title: String,
        shortText: String,
        longText: String
    ) {
        Column(modifier = modifier.fillMaxSize()) {
            Image(
                modifier = modifier.fillMaxWidth(),
                painter = image,
                contentDescription = null
            )
            Text(
                text = title,
                fontSize = 24.sp,
                modifier = modifier.padding(16.dp)
            )
            Text(
                text = shortText,
                modifier = modifier.padding(horizontal = 16.dp),
                textAlign = TextAlign.Justify
            )
            Text(
                text = longText,
                modifier = modifier.padding(16.dp),
                textAlign = TextAlign.Justify
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        HappyBirthdayCardTheme {
            ComposeApp()
        }
    }