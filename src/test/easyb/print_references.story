import ryhma50.*
import ryhma50.io.*
import ryhma50.data_access.*
import references.*

description 'User can read already created references'

scenario 'user can print references', {
    given 'app runs', {
        io = new StubIO("add", "article", "vilma ja sara", "paras kirja", "kumpulan kampus", "2016", "plop", "", "", "", "", "", "")
        dao = new FileDAO("src/test/resources/write_file_test.txt", io)
        ui = new UserInterface(io, dao)
        ui.run()
    }
    when 'command print is selected', {
        io = new StubIO("print")
        dao = new FileDAO("src/test/resources/write_file_test.txt", io)
        ui = new UserInterface(io, dao)
        ui.run()
    }
    then 'references are printed in a readable form for humans', {
        io.getPrints().shouldHave("article")
        io.getPrints().shouldHave("volume = plop")
    }
}