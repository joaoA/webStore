
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.api.templates.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import com.avaje.ebean._
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object index extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(message: String):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.19*/("""

"""),_display_(Seq[Any](/*3.2*/main("Foto Store")/*3.20*/ {_display_(Seq[Any](format.raw/*3.22*/("""
    
    
    
""")))})))}
    }
    
    def render(message:String) = apply(message)
    
    def f:((String) => play.api.templates.Html) = (message) => apply(message)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Nov 17 01:28:00 WET 2012
                    SOURCE: /home/joao/ws/webStore/fotoStore/app/views/index.scala.html
                    HASH: 5543732fe003cece9fcfb5f3b58072934fc4b0dd
                    MATRIX: 755->1|849->18|886->21|912->39|951->41
                    LINES: 27->1|30->1|32->3|32->3|32->3
                    -- GENERATED --
                */
            