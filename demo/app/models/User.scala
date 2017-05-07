package models

case class User(Id: Long, Username: String, Password: String)

object User {
  var user = User(
    Id = 1,
    Username = "1",
    Password = "1"
  )


}
