package com.twitterui
import grails.util.Environment
import org.codehaus.groovy.grails.web.context.ServletContextHolder


class UploadController {
	
	def init() {
		//used to initialize import session on first time access or when reset is pressed
		session.steps = [true, false, false]
		session.filename = "none"
		session.importInit = true
	}
	def index() {
		 if(!session.importInit) {
			 init()
		 }
	}
	def reset() {
		init()
		render(view: 'index' , model: params)
	}
	def upload() {
		def file = request.getFile('myFile')
		if (file && !file.empty && file.size < 20480 ) {
			String storagePath = ""
			if (Environment.current == Environment.PRODUCTION) {
			  storagePath = "/opt/assets"
			} else {
			  def servletContext = ServletContextHolder.servletContext
			  storagePath = servletContext.getRealPath('assets')
			}
			// Create storage path directory if it does not exist
			def storagePathDirectory = new File(storagePath)
			if (!storagePathDirectory.exists()) {
			  log.info("Creating storage path for upload: ${storagePath}: ")
			if (storagePathDirectory.mkdirs()) {
				log.info "SUCCESS"
			  } else {
				log.info "FAILED"
			  }
			}
			session.filename = file.name
			file.transferTo( new File("${storagePath}/${file.name}"))
			session.steps[1] = true
		}
		
		render(view: 'index' , model: params)
	}
}


