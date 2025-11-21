package com.example.happybirthdaycard.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.happybirthdaycard.R
import com.example.happybirthdaycard.domain.model.Amphibian
import com.example.happybirthdaycard.ui.theme.HappyBirthdayCardTheme

@Composable
fun AmphibianCardComponent(
    amphibian: Amphibian,
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors((Color(0xFFB3C2C0)).copy(0.5f)),
        modifier = Modifier.padding(horizontal = 12.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontSize = 16.sp
                        ).toSpanStyle()
                    ) {
                        append(amphibian.name)
                    }
                    append(" [")
                    withStyle(style = SpanStyle(Color.Gray, fontSize = 14.sp)) {
                        append(amphibian.type)
                    }
                    append("]")
                }
            )
            AsyncImage(
                model = amphibian.imageUrl,
                contentScale = ContentScale.Crop,
                contentDescription = amphibian.name,
                placeholder = painterResource(R.drawable.frog_res),
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .sizeIn(maxHeight = 250.dp),
            )
            Text(
                text = amphibian.description,
                style = MaterialTheme.typography.labelSmall
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun AmphibianCardComponentPreview() {
    HappyBirthdayCardTheme {
        AmphibianCardComponent(
            Amphibian(
                name = "Great Basin Spadefoot",
                type = "Toad",
                imageUrl = "https://developer.android.com/codelabs/basic-android-kotlin-compose-amphibians-app/img/great-basin-spadefoot.png",
                description = "This toad spends most of its life underground due to the arid desert" +
                        " conditions in which it lives. Spadefoot toads earn the name because of " +
                        "their hind legs which are wedged to aid in digging. They are typically" +
                        " grey, green, or brown with dark spots.",
            )
        )
    }
}