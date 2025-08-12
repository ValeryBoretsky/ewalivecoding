package com.ewa.ewalivecoding.presentation.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.ewa.api.Book
import com.ewa.ewalivecoding.domain.BookTime
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(
    books: List<BookTime>,
    onBookClick: (BookTime) -> Unit,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(top = 48.dp, bottom = 48.dp)
    ) {
        items(books) { bookTime ->
            ListItem(
                bookTime = bookTime,
                onClick = { onBookClick(bookTime) }
            )
        }
    }
}

@Composable
fun ListItem(
    bookTime: BookTime,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Book Image
            AsyncImage(
                model = bookTime.book.image,
                contentDescription = "Book cover",
                modifier = Modifier
                    .size(70.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.width(16.dp))

            // Book Info
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = bookTime.book.title,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                bookTime.book.author?.let { author ->
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = author,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Gray
                    )
                }

                if (bookTime.openTime >= 0) {
                    val date = java.text.SimpleDateFormat(
                        "MMM dd, yyyy HH:mm",
                        java.util.Locale.getDefault()
                    ).format(Date(bookTime.openTime))

                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Last opened: $date",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ItemPreview() {
    val testBook = Book(
        id = "1",
        title = "The Great Gatsby",
        author = "F. Scott Fitzgerald",
        text = "Sample text...",
        image = null
    )
    val testBookTime = BookTime(
        book = testBook,
        openTime = System.currentTimeMillis() - 3600000 // 1 hour ago
    )

    ListItem(
        bookTime = testBookTime,
        onClick = {}
    )
}

@Preview(showBackground = true)
@Composable
fun ListScreenPreview() {
    val testBooks = listOf(
        BookTime(
            book = Book(
                id = "1",
                title = "The Great Gatsby",
                author = "F. Scott Fitzgerald",
                text = "Sample text...",
                image = null
            ),
            openTime = System.currentTimeMillis() - 3600000
        ),
        BookTime(
            book = Book(
                id = "2",
                title = "To Kill a Mockingbird",
                author = "Harper Lee",
                text = "Sample text...",
                image = null
            ),
            openTime = -1L
        ),
        BookTime(
            book = Book(
                id = "3",
                title = "1984",
                author = "George Orwell",
                text = "Sample text...",
                image = null
            ),
            openTime = System.currentTimeMillis() - 7200000
        )
    )

    ListScreen(
        books = testBooks,
        onBookClick = {}
    )
} 