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
                true,
                false,
                false,
            5,
            0,
            0,
            "The story, set in a dystopia in 2045, follows protagonist Wade Watts on his search for an Easter egg in a worldwide virtual reality game, the discovery of which would lead him to inherit the game creator's fortune."
        )
        books.add(books1)

        val books2 = Book(
            "2",
            "The Da Vinci Code",
            "https://coverart.oclc.org/ImageWebSvc/oclc/+-+9154585356_140.jpg?SearchOrder=+-+OT,OS,TN,GO,FA",
            "Dan Brown",
                true,
                false,
                false,
            4,
            0,
            0,
            "A murder in Paris' Louvre Museum and cryptic clues in some of Leonardo da Vinci's most famous paintings lead to the discovery of a religious mystery. For 2,000 years a secret society closely guards information that -- should it come to light -- could rock the very foundations of Christianity."
        )
        books.add(books2)

        val books3 = Book(
            "3",
            "Angels & Demons",
            "https://coverart.oclc.org/ImageWebSvc/oclc/+-+6398181766_140.jpg?SearchOrder=+-+OT,OS,TN,GO,FA",
            "Dan Brown",
                true,
                false,
                false,
            4,
            0,
            0,
            "\t\n" +
                    "The murder of a world-famous physicist raises fears that the Illuminati are operating again after centuries of silence, and religion professor Robert Langdon is called in to assist with the case."
        )
        books.add(books3)

        val books4 = Book(
            "4",
            "Harry Potter And The Deathly Hallows",
            "https://coverart.oclc.org/ImageWebSvc/oclc/+-+503686006_140.jpg?SearchOrder=+-+OT,OS,TN,GO,FA",
            "J K Rowling",
                true,
                false,
                false,
            4,
            0,
            0,
            "\t\n" +
                    "Burdened with the dark, dangerous, and seemingly impossible task of locating and destroying Voldemort's remaining Horcruxes, Harry, feeling alone and uncertain about his future, struggles to find the inner strength he needs to follow the path set out before him."
        )
        books.add(books4)

        val books5 = Book(
            "5",
            "The Hobbit",
            "https://coverart.oclc.org/ImageWebSvc/oclc/+-+3597429966_140.jpg?SearchOrder=+-+OT,OS,TN,GO,FA",
            "J R R Tolkien",
                true,
                false,
                false,
            5,
            0,
            0,
            "The story, set in a dystopia in 2045, follows protagonist Wade Watts on his search for an Easter egg in a worldwide virtual reality game, the discovery of which would lead him to inherit the game creator's fortune."
        )
        books.add(books5)
        return books
    }

    fun generatePopularBooks(): List<Book>{
        val books = ArrayList<Book>()
        val books1 = Book(
                "6",
                "The Hunger Games",
                "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1586722975l/2767052.jpg",
                "Suzanne Collins",
                false,
                true,
                false,
                4,
                0,
                0,
                "Sixteen-year-old Katniss Everdeen, who lives alone with her mother and younger sister, regards it as a death sentence when she steps forward to take her sister's place in the Games. But Katniss has been close to dead before—and survival, for her, is second nature. Without really meaning to, she becomes a contender. But if she is to win, she will have to start making choices that weight survival against humanity and life against love."
        )
        books.add(books1)

        val books2 = Book(
                "7",
                "The Book Thief",
                "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1522157426l/19063._SY475_.jpg",
                "Markus Zusak",
                false,
                true,
                false,
                5,
                0,
                0,
                "The Book Thief tells the story of Liesel, a little girl who is taken to a new home because her mother can't afford to take care of her. The story is told by Death, who becomes a character you come to respect and even feel sorry for by the end."
        )
        books.add(books2)

        val books3 = Book(
                "8",
                "The Kite Runner",
                "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1579036753l/77203._SY475_.jpg",
                "Khaled Hosseini",
                false,
                true,
                false,
                5,
                0,
                0,
                "Ultimately, The Kite Runner is a novel about relationships — specifically the relationships between Amir and Hassan, Baba, Rahim Khan, Soraya, and Sohrab — and how the complex relationships in our lives overlap and connect to make us the people we are."
        )
        books.add(books3)

        val books4 = Book(
                "9",
                "A Thousand Splendid Suns",
                "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1345958969l/128029.jpg",
                "Khaled Hosseini",
                false,
                true,
                false,
                5,
                0,
                0,
                "A Thousand Splendid Suns, a novel by Khaled Hosseini, is a gripping tale of two young women, Mariam, an illegitimate child, and Laila, an orphan, and the difficult lives they lead after marrying the same man, Rasheed."
        )
        books.add(books4)

        val books5 = Book(
                "10",
                "Twilight",
                "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1361039443l/41865.jpg",
                "Stephenie Meyer",
                false,
                true,
                false,
                4,
                0,
                0,
                "Twilight tells the story of Bella, an average 17 year old girl who moves to Forks, WA to live with her father after her mother remarries a traveling minor league baseball player. In Forks, she meets Edward, a mysterious, gorgeous, private student, who tends to travel in a pack with his family"
        )
        books.add(books5)
        return books
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
                "2",
                "Linus",
                "Linus_Randu"
        )
        users.add(users2)

        val users3 = User(
                "3",
                "Tegar",
                "Tegar170"
        )
        users.add(users3)

        val users4 = User(
                "4",
                "rafa",
                "rafa_fara"
        )
        users.add(users4)

        val users5 = User(
                "5",
                "Adit",
                "adit_mantul"
        )
        users.add(users5)

        return users
    }
}