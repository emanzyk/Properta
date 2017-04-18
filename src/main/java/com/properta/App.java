package com.properta;

import static spark.Spark.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.properta.controller.IndexController;
import com.properta.util.Path;

import spark.template.handlebars.HandlebarsTemplateEngine;

public class App {
	
	Logger logger = LoggerFactory.getLogger(App.class);
	
	public App() {
		staticFileLocation("/public"); 
		
		logger.info("app was started.");
		
		get("/hello", (req, res) -> "Hello World3");
		
		get(Path.Web.ADD, (req, res) -> IndexController.serveHomePage(req, res), new HandlebarsTemplateEngine());
	}
	
	public static void main(String[] args) {
        new App();
    }
}