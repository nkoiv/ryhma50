import ryhma50.*
import ryhma50.io.*

description 'User can use app to add new reference'


scenario 'user can add a book', {
    given 'app runs and command add is selected' {
        io = new StubIO("add", "book", "vilma ja sara", "paras kirja", "kumpulan kampus", "2016", "", "", "", "", "", "", "")
        ui = new UserInterface(io)
    }

    when 'books information is given correctly', {
        ui.run()
    }

    then 'book-entry is added', {
        io.getPrints().shouldHave("New entry added")
    }
}