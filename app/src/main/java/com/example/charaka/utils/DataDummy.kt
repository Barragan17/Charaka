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
                false,
                false,
                true,
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
                false,
                false,
                true,
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
                false,
                false,
                true,
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
                false,
                false,
                true,
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
                false,
                false,
                true,
            5,
            0,
            0,
            "The story, set in a dystopia in 2045, follows protagonist Wade Watts on his search for an Easter egg in a worldwide virtual reality game, the discovery of which would lead him to inherit the game creator's fortune."
        )
        books.add(books5)

        val books6 = Book(
                "6",
                "Ready Player Two",
                "https://images-na.ssl-images-amazon.com/images/I/811W9hHXiwL.jpg",
                "Ernest Cline",
                false,
                false,
                true,
                3,
                0,
                0,
                "After the events of the first novel, the High Five have scattered across the globe: Aech is on a vacation in Senegal, Shoto has taken over operations at GSS's Hokkaido division and Samantha has flown back to Vancouver to pack up her belongings and say bye to her grandmother. To keep himself busy, Wade decides to test out his new superuser abilities. Wade finds an inscription on Halliday's Easter egg and after following directions, he finds the first operational ONI (OASIS Neural Interface) headset"
        )
        books.add(books6)

        val books7 = Book(
                "7",
                "To Kill A Mockingbird",
                "https://cdn.britannica.com/s:800x1000/21/182021-050-666DB6B1/book-cover-To-Kill-a-Mockingbird-many-1961.jpg",
                "Harper Lee",
                false,
                false,
                true,
                5,
                0,
                0,
                "To Kill a Mockingbird takes place in the fictional town of Maycomb, Alabama, during the Great Depression. The protagonist is Jean Louise (“Scout”) Finch, an intelligent though unconventional girl who ages from six to nine years old during the course of the novel."
        )
        books.add(books7)

        val books8 = Book(
                "8",
                "The Great Gatsby",
                "https://coverart.oclc.org/ImageWebSvc/oclc/+-+0846769366_140.jpg?SearchOrder=+-+OT,OS,TN,GO,FA",
                "F Scott Fitzgerald",
                false,
                false,
                true,
                5,
                0,
                0,
                "For Gatsby--young, handsome, fabulously rich--always seems alone in the crowd, watching and waiting, though no one knows what for. Beneath the shimmering surface of his life he is hiding a secret: a silent longing that can never be fulfilled. And soon this destructive obsession will force his world to unravel"
        )
        books.add(books8)

        val books9 = Book(
                "9",
                "The Maze Runner",
                "https://images-na.ssl-images-amazon.com/images/I/51UU0FLH1wL._SX330_BO1,204,203,200_.jpg",
                "James Dashner",
                false,
                false,
                true,
                4,
                0,
                0,
                "Thomas (Dylan O'Brien), a teenager, arrives in a glade at the center of a giant labyrinth. Like the other youths dumped there before him, he has no memory of his previous life. Thomas quickly becomes part of the group and soon after demonstrates a unique perspective that scores him a promotion to Runner status -- those who patrol the always-changing maze to find an escape route. Together with Teresa (Kaya Scodelario), the only female, Thomas tries to convince his cohorts that he knows a way out."
        )
        books.add(books9)

        val books10 = Book(
                "10",
                "Moby Dick",
                "https://images-na.ssl-images-amazon.com/images/I/41WMBltiqdL._SX320_BO1,204,203,200_.jpg",
                "Herman Melville",
                false,
                false,
                true,
                5,
                0,
                0,
                "Moby Dick is the story of Captain Ahab's quest to avenge the whale that 'reaped' his leg. The quest is an obsession and the novel is a diabolical study of how a man becomes a fanatic."
        )
        books.add(books10)

        val books11 = Book(
                "11",
                "War and Peace",
                "https://d3i5mgdwi2ze58.cloudfront.net/swd3lfscp8lshlhuwfjng9s92o8q",
                "Leo Tolstoy",
                false,
                false,
                true,
                5,
                0,
                0,
                "Epic in scale, War and Peace delineates in graphic detail events leading up to Napoleon's invasion of Russia, and the impact of the Napoleonic era on Tsarist society, as seen through the eyes of five Russian aristocratic families."
        )
        books.add(books11)

        val books12 = Book(
                "12",
                "Hamlet",
                "https://d3i5mgdwi2ze58.cloudfront.net/bn18q459ejqgr04pnx4uj3ezw1sm",
                "William Shakespeare",
                false,
                false,
                true,
                5,
                0,
                0,
                "The Tragedy of Hamlet, Prince of Denmark, or more simply Hamlet, is a tragedy by William Shakespeare, believed to have been written between 1599 and 1601. "
        )
        books.add(books12)

        val books13 = Book(
                "13",
                "Invisible Man",
                "https://d3i5mgdwi2ze58.cloudfront.net/fmu24nzcnb7irz7o3mpl7ons3ay5",
                "Ralph Ellison",
                false,
                false,
                true,
                4,
                0,
                0,
                "The novel addresses many of the social and intellectual issues facing African-Americans in the early twentieth century, including black nationalism, the relationship between black identity and Marxism, and the reformist racial policies of Booker T. Washington, as well as issues of individuality and personal identity."
        )
        books.add(books13)

        val books14 = Book(
                "14",
                "Ulysses",
                "https://d3i5mgdwi2ze58.cloudfront.net/usuab7s8yuwlcmadwx9woy746lvi",
                "James Joyce",
                false,
                false,
                true,
                5,
                0,
                0,
                "Ulysses chronicles the passage of Leopold Bloom through Dublin during an ordinary day, June 16, 1904. The title parallels and alludes to Odysseus (Latinised into Ulysses), the hero of Homer's Odyssey (e.g., the correspondences between Leopold Bloom and Odysseus, Molly Bloom and Penelope, and Stephen Dedalus and Telemachus). Joyce fans worldwide now celebrate June 16 as Bloomsday."
        )
        books.add(books14)

        val books15 = Book(
                "15",
                "The Iliad",
                "https://d3i5mgdwi2ze58.cloudfront.net/0eesig0qqfy1ajg3evtlcxryw3je",
                "Homer",
                false,
                false,
                true,
                5,
                0,
                0,
                "The Iliad is an epic poem in dactylic hexameters, traditionally attributed to Homer. Set in the Trojan War, the ten-year siege of Ilium by a coalition of Greek states, it tells of the battles and events during the weeks of a quarrel between King Agamemnon and the warrior Achilles."
        )
        books.add(books15)


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