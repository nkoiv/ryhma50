import ryhma50.*
import ryhma50.io.*

description 'User can read already created references'

scenario 'user can get references to read', {
    given 'app runs'
    when 'command read references is selected'
    then 'a file containing the references is (created and) opened'
}