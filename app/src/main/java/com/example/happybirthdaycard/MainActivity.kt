package com.example.happybirthdaycard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
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
                    ArtSpaceMain()
                }
            }
        }
    }
}


@Composable
fun ArtWithTitle(
    modifier: Modifier = Modifier,
    artPicture: Int,
    artTitle: String,
    artistName: String,
    yearOfRelease: String = ""
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {

        Image(
            painter = painterResource(artPicture),
            contentDescription = null,
            modifier = Modifier
                .padding(20.dp)
                .height(300.dp)
                .width(300.dp)
                .border(border = BorderStroke(2.dp, Color.Gray), shape = RectangleShape)
                .shadow(elevation = 4.dp)
                .padding(10.dp)
        )
        Card(
            modifier = Modifier
                .padding(horizontal = 45.dp, vertical = 90.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = artTitle,
                    fontSize = 25.sp,
                    textAlign = TextAlign.Start,
                    lineHeight = 30.sp
                )
                Text(
                    text = buildAnnotatedString {
                        append(artistName)
                        append(" ")
                        withStyle(
                            style = SpanStyle(color = Color.Gray, fontSize = 16.sp)
                        ) {
                            append("($yearOfRelease)")
                        }
                    },
                    fontSize = 16.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}


@Composable
fun ArtSpaceMain() {
    var result by remember { mutableStateOf(1) }

    when (result) {
        1 -> {
            ArtWithTitle(
                artPicture = R.drawable.art_1,
                artTitle = "The Ninja Boy",
                artistName = "Timz Owen",
                yearOfRelease = "2021"
            )
        }

        2 -> {
            ArtWithTitle(
                artPicture = R.drawable.art_2,
                artTitle = "The Elephant",
                artistName = "Wild Life",
                yearOfRelease = "2019"
            )
        }

        3 -> {
            ArtWithTitle(
                artPicture = R.drawable.art_3,
                artTitle = "The Flower Girl",
                artistName = "mrs flower",
                yearOfRelease = "2020"
            )
        }

        4 -> {
            ArtWithTitle(
                artPicture = R.drawable.art_4,
                artTitle = "The Pot ",
                artistName = "The Potter",
                yearOfRelease = "2018"
            )
        }

        5 -> {
            ArtWithTitle(
                artPicture = R.drawable.art_5,
                artTitle = "The Artist",
                artistName = "Kelvin arts",
                yearOfRelease = "2022"
            )
        }

        else -> {
            ArtWithTitle(
                artPicture = R.drawable.art_5,
                artTitle = "The Artist",
                artistName = "Kelvin arts",
                yearOfRelease = "2029"
            )
        }
    }
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 700.dp)
    ) {
        Button(
            onClick = { result-- },
            shape = RoundedCornerShape(50.dp),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 20.dp
            ),
            border = BorderStroke(2.dp, Color.Gray)
        ) {
            Text("Back")
        }

        Button(
            onClick = { result++ },
            shape = RoundedCornerShape(50.dp),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 20.dp
            ),
            border = BorderStroke(2.dp, Color.Gray)
        ) {
            Text(stringResource(R.string.next))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        HappyBirthdayCardTheme {
            ArtSpaceMain()
        }
    }
}