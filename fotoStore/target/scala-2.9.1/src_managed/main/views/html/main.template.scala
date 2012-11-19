
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
object main extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,Html,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(title: String)(content: Html):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.32*/("""

<!DOCTYPE html>

<html>
    <head>
        <title>"""),_display_(Seq[Any](/*7.17*/title)),format.raw/*7.22*/("""</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    	<meta name="description" content="">
    	<meta name="author" content="">
        
        
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*13.59*/routes/*13.65*/.Assets.at("images/favicon.png"))),format.raw/*13.97*/("""">
       

	   
		<style type="text/css">
		      body """),format.raw("""{"""),format.raw/*18.15*/("""
		        padding-top: 20px;
		        padding-bottom: 40px;
		      """),format.raw("""}"""),format.raw/*21.10*/("""
		
		      /* Custom container */
		      .container-narrow """),format.raw("""{"""),format.raw/*24.28*/("""
		        margin: 0 auto;
		        max-width: 700px;
		      """),format.raw("""}"""),format.raw/*27.10*/("""
		      .container-narrow > hr """),format.raw("""{"""),format.raw/*28.33*/("""
		        margin: 30px 0;
		      """),format.raw("""}"""),format.raw/*30.10*/("""
		
		      /* Main marketing message and sign up button */
		      .jumbotron """),format.raw("""{"""),format.raw/*33.21*/("""
		        margin: 60px 0;
		        text-align: center;
		      """),format.raw("""}"""),format.raw/*36.10*/("""
		      .jumbotron h1 """),format.raw("""{"""),format.raw/*37.24*/("""
		        font-size: 72px;
		        line-height: 1;
		      """),format.raw("""}"""),format.raw/*40.10*/("""
		      .jumbotron .btn """),format.raw("""{"""),format.raw/*41.26*/("""
		        font-size: 21px;
		        padding: 14px 24px;
		      """),format.raw("""}"""),format.raw/*44.10*/("""

		</style>
		
			  
	  
    	
    </head>
    <body>
	    <div class="container-narrow">

	        <h3 class="muted">As melhores maquinas do mundo</h3>
	        <h5 class="muted">(em contrução)</h5>
	      </div>
	
	      <hr>
	
	      <div class="jumbotron">
	        <h1>Super awesome market!</h1>
	        <p class="lead">bla bla bla, isto é engraçado e tal e coiso</p>
	        <a class="btn btn-large btn-success" href="#">Até tira finos</a>
	      </div>
	
	
	
	      <div class="footer">
	        <p>&copy; FotoStore 2012</p>
	      </div>
	
	    </div> <!-- /container -->
	
	    <!-- Le javascript
	    ================================================== -->
	    <!-- Placed at the end of the document so the pages load faster -->
	    <script src=""""),_display_(Seq[Any](/*78.20*/routes/*78.26*/.Assets.at("javascripts/jquery-1.7.1.min.js"))),format.raw/*78.71*/("""" type="text/javascript">
        </script>
		<script src="http://twitter.github.com/bootstrap/assets/js/bootstrap.min.js"></script>    

  
    </body>
</html>
"""))}
    }
    
    def render(title:String,content:Html) = apply(title)(content)
    
    def f:((String) => (Html) => play.api.templates.Html) = (title) => (content) => apply(title)(content)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Nov 17 01:36:13 WET 2012
                    SOURCE: /home/joao/ws/webStore/fotoStore/app/views/main.scala.html
                    HASH: c73c2f094b32525ec65c7050f5cdef7e6ee154d7
                    MATRIX: 759->1|866->31|954->84|980->89|1259->332|1274->338|1328->370|1432->427|1550->498|1659->560|1770->624|1850->657|1933->693|2060->773|2173->839|2244->863|2354->926|2427->952|2541->1019|3338->1780|3353->1786|3420->1831
                    LINES: 27->1|30->1|36->7|36->7|42->13|42->13|42->13|47->18|50->21|53->24|56->27|57->28|59->30|62->33|65->36|66->37|69->40|70->41|73->44|107->78|107->78|107->78
                    -- GENERATED --
                */
            