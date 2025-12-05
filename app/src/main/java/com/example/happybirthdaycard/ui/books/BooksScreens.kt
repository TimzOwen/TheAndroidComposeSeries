package com.example.happybirthdaycard.ui.books

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import org.koin.androidx.compose.koinViewModel
import com.example.happybirthdaycard.ui.BookUiState
import com.example.happybirthdaycard.domain.Book

@Composable
fun BooksRoute(onBookClick: (String) -> Unit, vm: BooksViewModel = koinViewModel()) {
    val state by vm.uiState.collectAsState()
    var query by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize()) {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            value = query,
            onValueChange = {
                query = it
                vm.search(query)
            },
            singleLine = true,
            label = { Text("Search books") }
        )

        when (state) {
            is BookUiState.Loading -> {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }
            is BookUiState.Error -> {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text("Something went wrong.", color = Color.Red)
                }
            }
            is BookUiState.Success -> {
                val books = (state as BookUiState.Success).books
                if (books.isEmpty()) {
                    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text("Type to search for books")
                    }
                } else {
                    BooksList(books = books, onBookClick = onBookClick)
                }
            }
        }
    }
}

@Composable
private fun BooksList(books: List<Book>, onBookClick: (String) -> Unit) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(books) { book ->
            BookRow(book = book, onClick = { onBookClick(book.id) })
            HorizontalDivider()
        }
    }
}

@Composable
private fun BookRow(book: Book, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        AsyncImage(
            model = book.thumbnailUrl,
            contentDescription = book.title,
            modifier = Modifier.size(64.dp),
            contentScale = ContentScale.Crop,
        )
        Column(modifier = Modifier.weight(1f)) {
            Text(text = book.title, style = MaterialTheme.typography.titleMedium, maxLines = 2, overflow = TextOverflow.Ellipsis)
            Text(text = book.authors.joinToString(), style = MaterialTheme.typography.bodyMedium, maxLines = 1, overflow = TextOverflow.Ellipsis)
            Text(text = book.publisher, style = MaterialTheme.typography.bodySmall, maxLines = 1, overflow = TextOverflow.Ellipsis)
        }
    }
}

@Composable
fun BookDetailRoute(bookId: String, vm: BooksViewModel = koinViewModel()) {
    var book by remember { mutableStateOf<Book?>(null) }
    LaunchedEffect(bookId) {
        vm.loadById(bookId) { book = it }
    }

    if (book == null) {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) { CircularProgressIndicator() }
    } else {
        Column(modifier = Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(text = book!!.title, style = MaterialTheme.typography.titleLarge)
            Text(text = book!!.authors.joinToString(), style = MaterialTheme.typography.bodyMedium)
            Text(text = "Published: ${book!!.publishedDate}", style = MaterialTheme.typography.bodySmall)
            Text(text = book!!.description, style = MaterialTheme.typography.bodyMedium)
        }
    }
}
