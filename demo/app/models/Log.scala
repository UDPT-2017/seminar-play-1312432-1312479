package models

case class Log(Id: Long, Title: String, Users: Long)

object Log {
  var log = Log(
    Id = 1,
    Title = "1" ,
    Users = 1
  )


}
