package com.example.happybirthdaycard.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.happybirthdaycard.R

@Composable
fun FormattedPrice(subTotal: String, modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.subtotal_price, subTotal),
        modifier = modifier,
        style = MaterialTheme.typography.headlineSmall
    )
}

@Composable
@Preview(showBackground = true)
fun FormattedPricePreview(modifier: Modifier = Modifier) {
    FormattedPrice(
        "400"
    )
}