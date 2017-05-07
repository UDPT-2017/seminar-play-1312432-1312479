  package controllers

  import play.api._
  import play.api.mvc._
  import models.User



  class Application extends Controller {

    def hello(name: String) = Action {
      Ok("Hello " + name + "!")
    }

    // Redirect to /hello/Bob
    def helloBob = Action {
      Ok("Bye").withNewSession

    }

    def addSession = Action {
      Ok("Welcome!").withSession(
    "connected" -> "user@gmail.com")
    }

    def removeSession = Action {
      Ok("Bye").withNewSession
    }

    def testSession = Action { request =>
      request.session.get("connected").map { user =>
        Ok("Hello " + user)
      }.getOrElse {
        Unauthorized("Oops, you are not connected")
      }
    }

    def index = Action { implicit request =>
      Ok(views.html.view())

    }

    def login = Action {
      Ok(views.html.login())
    }

    def session() = Action {
      Redirect("/").withSession("userlogin" -> "user@gmail.com")

    }

    def exit = Action {
      Redirect("/login").withNewSession
    }

    def register = Action {
      Ok(views.html.register())
    }
  }
