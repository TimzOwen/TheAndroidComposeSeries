package com.example.happybirthdaycard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.happybirthdaycard.ui.theme.HappyBirthdayCardTheme
import com.example.happybirthdaycard.ui.theme.Lavender_mist
import com.example.happybirthdaycard.ui.theme.Lavender_pink
import com.example.happybirthdaycard.ui.theme.Lavender_purple
import com.example.happybirthdaycard.ui.theme.Light_purple

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
                    QuadrantApp()
                }
            }
        }
    }
}


@Composable
fun QuadrantApp() {
    Column(modifier = Modifier.fillMaxSize()) {
        Row(Modifier.weight(1f)) {
            QuadrantCard(
                title = stringResource(R.string.txt_text_composable),
                description = stringResource(R.string.txt_text_composable_desc),
                bgColor = Light_purple,
                modifier = Modifier.weight(1f)
            )
            QuadrantCard(
                title = stringResource(R.string.txt_image_composable),
                description = stringResource(R.string.txt_image_composable_desc),
                bgColor = Lavender_mist,
                modifier = Modifier.weight(1f)
            )
        }
        Row(Modifier.weight(1f)) {
            QuadrantCard(
                title = stringResource(R.string.txt_text_composable),
                description = stringResource(R.string.txt_text_composable_desc),
                bgColor = Lavender_purple,
                modifier = Modifier.weight(1f)
            )
            QuadrantCard(
                title = stringResource(R.string.txt_image_composable),
                description = stringResource(R.string.txt_image_composable_desc),
                bgColor = Lavender_pink,
                modifier = Modifier.weight(1f)
            )
        }
    }
}


@Composable
fun QuadrantCard(
    title: String,
    description: String,
    bgColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(bgColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            modifier = Modifier.padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HappyBirthdayCardTheme {
        QuadrantApp()
    }
}