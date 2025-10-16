package com.example.happybirthdaycard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthdaycard.ui.theme.GreenColor
import com.example.happybirthdaycard.ui.theme.HappyBirthdayCardTheme
import com.example.happybirthdaycard.ui.theme.ImageDarkColor

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
                    BusinessCardAp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardAp() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier.background(ImageDarkColor)
            ) {
                Image(
                    modifier = Modifier.size(150.dp),
                    painter = painterResource(R.drawable.android_logo),
                    contentDescription = null
                )
            }
            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Timz Owen",
                fontSize = 28.sp
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Android Developer Extraordinaire",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = GreenColor
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Column(
            modifier = Modifier.padding(bottom = 32.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            ContactInfoComponent(
                contactIcon = Icons.Default.Call,
                contactText = "+11 (123) 444 555 666"
            )
            ContactInfoComponent(
                contactIcon = Icons.Default.Share,
                contactText = "@AndroidDevTeam"
            )
            ContactInfoComponent(
                contactIcon = Icons.Default.Email,
                contactText = "timz@androidgoogle.com"
            )
        }
    }
}

@Composable
fun ContactInfoComponent(
    contactIcon: ImageVector,
    contactText: String
) {
    Row(
        horizontalArrangement = Arrangement.Start,
    ) {
        Icon(
            imageVector = contactIcon,
            contentDescription = null,
            tint = GreenColor,
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = contactText
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HappyBirthdayCardTheme {
        BusinessCardAp()
    }
}