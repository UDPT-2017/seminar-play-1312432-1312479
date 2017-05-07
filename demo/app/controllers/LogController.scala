package scalaguide.sql

import javax.inject.Inject

import play.api.Play.current
import play.api.mvc._
import play.api.db._
import scala.collection.mutable.ListBuffer
import models.User


class LogController @Inject()(db: Database) extends Controller {

  def index = Action {
    val conn = db.getConnection()
    var list = ""

    try {
      val stmt = conn.createStatement
      val rs = stmt.executeQuery("SELECT id, title, users from logs")

      while (rs.next()) {
        var string = rs.getString("id") + "/"
        string += rs.getString("title") + "/"
        string += rs.getString("users") + "--"
        list += string
      }
    } finally {
      conn.close()
    }
    Ok(views.html.log(list))
  }
}
