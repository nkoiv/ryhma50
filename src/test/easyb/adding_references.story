import ryhma50.*
import ryhma50.io.*
import ryhma50.data_access.*
import references.*

description 'User can use app to add new references'


scenario 'user can add a book', {
    given 'app runs and command add is selected', {
        io = new StubIO("add", "book", "vilma ja sara", "paras kirja", "kumpulan kampus", "2016", "", "", "", "", "", "", "")
        dao = new FileDAO("src/test/resources/write_file_test.txt", io)
        ui = new UserInterface(io, dao)
    }

    when 'books information is given correctly', {
        ui.run()
    }

    then 'book-entry is added', {
       io.getPrints().shouldHave("New entry added")
    }
}

scenario 'user can add a book even if they leave a necessary field empty at first', {
    given 'app runs and command add is selected', {
        io = new StubIO("add", "book", "vilma ja sara", "paras kirja", "kumpulan kampus", "2016", "", "", "", "", "", "", "")
        dao = new FileDAO("src/test/resources/write_file_test.txt", io)
        ui = new UserInterface(io, dao)
    }

    when 'a necessary field is left empty at first but then books information is given correctly', {
        ui.run()
    }

    then 'book-entry is added', {
        io.getPrints().shouldHave("New entry added")
    }
}

scenario 'when adding a book, app asks all the right questions', {
    given 'app runs and command add is selected', {
        io = new StubIO("add", "book", "vilma ja sara", "paras kirja", "kumpulan kampus", "2016", "", "", "", "", "", "", "")
        dao = new FileDAO("src/test/resources/write_file_test.txt", io)
        ui = new UserInterface(io, dao)
    }

    when 'books information is given correctly', {
        ui.run()
    }

    then 'all the right questions are asked', {
        io.getPrints().shouldHave("author?")
        io.getPrints().shouldHave("title?")
        io.getPrints().shouldHave("publisher?")
        io.getPrints().shouldHave("year?")
        io.getPrints().shouldHave("volume?")
        io.getPrints().shouldHave("series?")
        io.getPrints().shouldHave("address?")
        io.getPrints().shouldHave("edition?")
        io.getPrints().shouldHave("month?")
        io.getPrints().shouldHave("note?")
        io.getPrints().shouldHave("key?")
    }
}

scenario 'when adding an article, app asks all the right questions', {
    given 'app runs and command add is selected', {
        io = new StubIO("add", "article", "vilma ja sara", "paras kirja", "kumpulan kampus", "2016", "plop", "", "", "", "", "")
        dao = new FileDAO("src/test/resources/write_file_test.txt", io)
        ui = new UserInterface(io, dao)
    }

    when 'books information is given correctly', {
        ui.run()
    }

    then 'all the right questions are asked', {
        io.getPrints().shouldHave("author?")
        io.getPrints().shouldHave("title?")
        io.getPrints().shouldHave("journal?")
        io.getPrints().shouldHave("year?")
        io.getPrints().shouldHave("volume?")
        io.getPrints().shouldHave("number?")
        io.getPrints().shouldHave("pages?")
        io.getPrints().shouldHave("month?")
        io.getPrints().shouldHave("note?")
        io.getPrints().shouldHave("key?")
    }
}
