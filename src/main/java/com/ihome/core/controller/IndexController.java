package com.ihome.core.controller;

import com.jfinal.core.Controller;

/**
 * IndexController
 */
public class IndexController extends Controller {
	public void index() {
		render("index.html");
	}

	public void login(){
        render("login.html");
    }

}





