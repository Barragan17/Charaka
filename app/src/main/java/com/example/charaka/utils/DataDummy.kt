package com.example.charaka.utils

import com.example.charaka.data.local.entity.Book
import com.example.charaka.data.local.entity.Post
import com.example.charaka.data.local.entity.User
import com.example.charaka.data.remote.ApiResponse

object DataDummy {

    fun generateBooks(): List<Book>{
        val books = ArrayList<Book>()

        val books1 = Book(
            "1",
            "Ready Player One",
            "https://coverart.oclc.org/ImageWebSvc/oclc/+-+1807922466_140.jpg?SearchOrder=+-+OT,OS,TN,GO,FA",
            "Ernest Cline",
            9,
            0,
            0,
            "The story, set in a dystopia in 2045, follows protagonist Wade Watts on his search for an Easter egg in a worldwide virtual reality game, the discovery of which would lead him to inherit the game creator's fortune."
        )
        books.add(books1)

        val books2 = Book(
            "2",
            "Ready Player One",
            "https://coverart.oclc.org/ImageWebSvc/oclc/+-+1807922466_140.jpg?SearchOrder=+-+OT,OS,TN,GO,FA",
            "Ernest Cline",
            9,
            0,
            0,
            "The story, set in a dystopia in 2045, follows protagonist Wade Watts on his search for an Easter egg in a worldwide virtual reality game, the discovery of which would lead him to inherit the game creator's fortune."
        )
        books.add(books2)

        val books3 = Book(
            "3",
            "Ready Player One",
            "https://coverart.oclc.org/ImageWebSvc/oclc/+-+1807922466_140.jpg?SearchOrder=+-+OT,OS,TN,GO,FA",
            "Ernest Cline",
            9,
            0,
            0,
            "The story, set in a dystopia in 2045, follows protagonist Wade Watts on his search for an Easter egg in a worldwide virtual reality game, the discovery of which would lead him to inherit the game creator's fortune."
        )
        books.add(books3)

        val books4 = Book(
            "4",
            "Ready Player One",
            "https://coverart.oclc.org/ImageWebSvc/oclc/+-+1807922466_140.jpg?SearchOrder=+-+OT,OS,TN,GO,FA",
            "Ernest Cline",
            9,
            0,
            0,
            "The story, set in a dystopia in 2045, follows protagonist Wade Watts on his search for an Easter egg in a worldwide virtual reality game, the discovery of which would lead him to inherit the game creator's fortune."
        )
        books.add(books4)

        val books5 = Book(
            "5",
            "Ready Player One",
            "https://coverart.oclc.org/ImageWebSvc/oclc/+-+1807922466_140.jpg?SearchOrder=+-+OT,OS,TN,GO,FA",
            "Ernest Cline",
            9,
            0,
            0,
            "The story, set in a dystopia in 2045, follows protagonist Wade Watts on his search for an Easter egg in a worldwide virtual reality game, the discovery of which would lead him to inherit the game creator's fortune."
        )
        books.add(books5)

        val books6 = Book(
            "6",
            "Ready Player One",
            "https://coverart.oclc.org/ImageWebSvc/oclc/+-+1807922466_140.jpg?SearchOrder=+-+OT,OS,TN,GO,FA",
            "Ernest Cline",
            9,
            0,
            0,
            "The story, set in a dystopia in 2045, follows protagonist Wade Watts on his search for an Easter egg in a worldwide virtual reality game, the discovery of which would lead him to inherit the game creator's fortune."
        )
        books.add(books6)

        val books7 = Book(
            "7",
            "Ready Player One",
            "https://coverart.oclc.org/ImageWebSvc/oclc/+-+1807922466_140.jpg?SearchOrder=+-+OT,OS,TN,GO,FA",
            "Ernest Cline",
            9,
            0,
            0,
            "The story, set in a dystopia in 2045, follows protagonist Wade Watts on his search for an Easter egg in a worldwide virtual reality game, the discovery of which would lead him to inherit the game creator's fortune."
        )
        books.add(books7)

        val books8 = Book(
            "8",
            "Ready Player One",
            "https://coverart.oclc.org/ImageWebSvc/oclc/+-+1807922466_140.jpg?SearchOrder=+-+OT,OS,TN,GO,FA",
            "Ernest Cline",
            9,
            0,
            0,
            "The story, set in a dystopia in 2045, follows protagonist Wade Watts on his search for an Easter egg in a worldwide virtual reality game, the discovery of which would lead him to inherit the game creator's fortune."
        )
        books.add(books8)

        val books9 = Book(
            "9",
            "Ready Player One",
            "https://coverart.oclc.org/ImageWebSvc/oclc/+-+1807922466_140.jpg?SearchOrder=+-+OT,OS,TN,GO,FA",
            "Ernest Cline",
            9,
            0,
            0,
            "The story, set in a dystopia in 2045, follows protagonist Wade Watts on his search for an Easter egg in a worldwide virtual reality game, the discovery of which would lead him to inherit the game creator's fortune."
        )
        books.add(books9)

        val books10 = Book(
            "10",
            "Ready Player One",
            "https://coverart.oclc.org/ImageWebSvc/oclc/+-+1807922466_140.jpg?SearchOrder=+-+OT,OS,TN,GO,FA",
            "Ernest Cline",
            9,
            0,
            0,
            "The story, set in a dystopia in 2045, follows protagonist Wade Watts on his search for an Easter egg in a worldwide virtual reality game, the discovery of which would lead him to inherit the game creator's fortune."
        )
        books.add(books10)

        return books
    }

    fun generatePosts(): ArrayList<Post>{
        val posts = ArrayList<Post>()

        val post1 = Post(
                1,
                "Ragil",
                "Mantap Sekali Bukunyaaaa",
        "https://coverart.oclc.org/ImageWebSvc/oclc/+-+1807922466_140.jpg?SearchOrder=+-+OT,OS,TN,GO,FA",
                "Ready Player One",
                "Ernest Cline",
                4,
                20,
                20)

        posts.add(post1)

        val post2 = Post(
                2,
                "Ragil",
                "Mantap Sekali Bukunyaaaa",
                "https://coverart.oclc.org/ImageWebSvc/oclc/+-+1807922466_140.jpg?SearchOrder=+-+OT,OS,TN,GO,FA",
                "Ready Player One",
                "Ernest Cline",
                4,
                20,
                20)
        posts.add(post2)

        val post3 = Post(
                3,
                "Ragil",
                "Mantap Sekali Bukunyaaaa",
                "https://coverart.oclc.org/ImageWebSvc/oclc/+-+1807922466_140.jpg?SearchOrder=+-+OT,OS,TN,GO,FA",
                "Ready Player One",
                "Ernest Cline",
                4,
                20,
                20)
        posts.add(post3)

        val post4 = Post(
                4,
                "Ragil",
                "Mantap Sekali Bukunyaaaa",
                "https://coverart.oclc.org/ImageWebSvc/oclc/+-+1807922466_140.jpg?SearchOrder=+-+OT,OS,TN,GO,FA",
                "Ready Player One",
                "Ernest Cline",
                4,
                20,
                20)
        posts.add(post4)

        val post5 = Post(
                5,
                "Ragil",
                "Mantap Sekali Bukunyaaaa",
                "https://coverart.oclc.org/ImageWebSvc/oclc/+-+1807922466_140.jpg?SearchOrder=+-+OT,OS,TN,GO,FA",
                "Ready Player One",
                "Ernest Cline",
                4,
                20,
                20)
        posts.add(post5)

        val post6 = Post(
                6,
                "Ragil",
                "Mantap Sekali Bukunyaaaa",
                "https://coverart.oclc.org/ImageWebSvc/oclc/+-+1807922466_140.jpg?SearchOrder=+-+OT,OS,TN,GO,FA",
                "Ready Player One",
                "Ernest Cline",
                4,
                20,
                20)
        posts.add(post6)

        val post7 = Post(
                7,
                "Ragil",
                "Mantap Sekali Bukunyaaaa",
                "https://coverart.oclc.org/ImageWebSvc/oclc/+-+1807922466_140.jpg?SearchOrder=+-+OT,OS,TN,GO,FA",
                "Ready Player One",
                "Ernest Cline",
                4,
                20,
                20)
        posts.add(post7)

        val post8 = Post(
                8,
                "Ragil",
                "Mantap Sekali Bukunyaaaa",
                "https://coverart.oclc.org/ImageWebSvc/oclc/+-+1807922466_140.jpg?SearchOrder=+-+OT,OS,TN,GO,FA",
                "Ready Player One",
                "Ernest Cline",
                4,
                20,
                20)
        posts.add(post8)

        val post9 = Post(
                9,
                "Ragil",
                "Mantap Sekali Bukunyaaaa",
                "https://coverart.oclc.org/ImageWebSvc/oclc/+-+1807922466_140.jpg?SearchOrder=+-+OT,OS,TN,GO,FA",
                "Ready Player One",
                "Ernest Cline",
                4,
                20,
                20)
        posts.add(post9)

        val post10 = Post(
                10,
                "Ragil",
                "Mantap Sekali Bukunyaaaa",
                "https://coverart.oclc.org/ImageWebSvc/oclc/+-+1807922466_140.jpg?SearchOrder=+-+OT,OS,TN,GO,FA",
                "Ready Player One",
                "Ernest Cline",
                4,
                20,
                20)
        posts.add(post10)

        return posts
    }

    fun generateUsers(): ArrayList<User>{
        val users = ArrayList<User>()

        val users1 = User(
                "1",
                "Ragil",
                "ragil_mantul"
        )
        users.add(users1)

        val users2 = User(
                "1",
                "Ragil",
                "ragil_mantul"
        )
        users.add(users2)

        val users3 = User(
                "1",
                "Ragil",
                "ragil_mantul"
        )
        users.add(users3)

        val users4 = User(
                "1",
                "Ragil",
                "ragil_mantul"
        )
        users.add(users4)

        val users5 = User(
                "1",
                "Ragil",
                "ragil_mantul"
        )
        users.add(users5)

        val users6 = User(
                "1",
                "Ragil",
                "ragil_mantul"
        )
        users.add(users6)

        val users7 = User(
                "1",
                "Ragil",
                "ragil_mantul"
        )
        users.add(users7)

        val users8 = User(
                "1",
                "Ragil",
                "ragil_mantul"
        )
        users.add(users8)

        val users9 = User(
                "1",
                "Ragil",
                "ragil_mantul"
        )
        users.add(users9)

        val users10 = User(
                "1",
                "Ragil",
                "ragil_mantul"
        )
        users.add(users10)

        return users
    }
}