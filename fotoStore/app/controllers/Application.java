package controllers;

import play.*;
import play.mvc.*;
import java.util.*;
import models.*;


public class Application extends Controller {

    public static void index() {
        render();
    }

    public static void example() {
        render();
    }
	
	public static void exampleBolsas() {


		Bolsa bolsa = new Bolsa;

		bolsa
        render();
    }


}