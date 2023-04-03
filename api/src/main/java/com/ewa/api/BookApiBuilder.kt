package com.ewa.api

import com.ewa.api.mock.BookApiMock

object BookApiBuilder {

    fun build(): BookApi = BookApiMock()

}