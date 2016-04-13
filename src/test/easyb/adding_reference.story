import ryhma50.*
import ryhma50.io.*

description 'User can use app to add new reference'

scenario 'user can use add command', {
    given 'app runs',{
        io = new StubIO("add", "book")
        ui = new UserInterface(io)
    }

    when 'add command is typed with correct information', {
        ui.run()
    }

    then 'entry is added to file', {
        io.getPrints().shouldHave("New entry added")
    }
}