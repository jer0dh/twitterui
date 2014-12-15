package com.twitterui

class WelcomeController {
	def springSecurityService
	
    def index() {
		log.debug("Entered WelcomeController, index()")
		if ( springSecurityService.isLoggedIn()){
			log.debug "Welcome, index(): logged in, redirect to main"
			redirect (controller: "main")
		}
	}
}
