package com.twitterui

class MainController {
	def springSecurityService
	
    def index() {
		log.debug "Entered MainController in index()"
		if ( ! springSecurityService.isLoggedIn()){
			log.debug "MainController, index(): not logged in, redirect to welcome"
			redirect (controller: "welcome")
		}
		
	}
}
