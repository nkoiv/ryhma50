import ryhma50.*
import ryhma50.io.*

description 'User can edit and delete references'

scenario 'user can edit a reference', {
    given 'app runs and command edit a reference is selected'
    when 'reference and changes are given'
    then 'the reference is changed and saved'
}

scenario 'user can't edit a reference that doesn't exist', {
    given 'app runs and command edit a reference is selected'
    when 'a non-existing reference is given'
    then 'an error-message is printed'
}

scenario 'user can delete a reference', {
    given 'app runs and command delete a reference is selected'
    when 'reference is given'
    then 'the reference is deleted'
}

scenario 'user can't delete a reference that doen't exist', {
    given 'app runs and command delete a reference is selected'
    when 'a non-existing reference is given'
    then 'an error-message is printed'
}