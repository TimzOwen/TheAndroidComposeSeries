package com.example.happybirthdaycard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.platform.WindowInfo
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthdaycard.affirmations.Affirmation
import com.example.happybirthdaycard.affirmations.DataSource
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
                    AffirmationApp()
                }
            }
        }
    }
}

@Composable
fun AffirmationApp(modifier: Modifier = Modifier) {
    val layoutDirection = LocalLayoutDirection.current
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(
                start = WindowInsets.safeDrawing.asPaddingValues()
                    .calculateStartPadding(layoutDirection),
                end = WindowInsets.safeDrawing.asPaddingValues()
                    .calculateEndPadding(layoutDirection)
            )
    ) {

    }
    AffirmationList(
        affirmation = DataSource().loadAffirmations()
    )
}

@Composable
fun AffirmationList(
    modifier: Modifier = Modifier,
    affirmation: List<Affirmation> = emptyList()
) {
    LazyColumn(modifier = modifier) {
        items(affirmation) { affirmation ->
            AffirmationCard(
                affirmation = affirmation,
                modifier = modifier.padding(8.dp)
            )
        }
    }

}

@Composable
fun AffirmationCard(
    affirmation: Affirmation,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier) {
        Column {
            Image(
                painter = painterResource(affirmation.affirmationImageResourceId),
                contentDescription = stringResource(affirmation.affirmationStringResourceId),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp)
            )
            Text(
                text = stringResource(affirmation.affirmationStringResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

@Preview
@Composable
fun AffirmationCardPreview(modifier: Modifier = Modifier) {
    AffirmationCard(
        Affirmation(
            affirmationImageResourceId = R.drawable.image1,
            affirmationStringResourceId = R.string.affirmation1
        )
    )
}