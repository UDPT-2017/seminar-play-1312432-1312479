package controllers

import javax.inject._
import play.api._
import play.api.mvc._

@Singleton
class HomeController @Inject() extends Controller {



  def index = Action { implicit request =>
    Redirect("/")
  }

  def about = Action { implicit request =>
    Ok(views.html.about())
  }
}
