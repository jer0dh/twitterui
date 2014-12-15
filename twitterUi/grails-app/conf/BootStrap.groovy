import com.twitterui.*

import java.text.SimpleDateFormat

class BootStrap {
	def grailsApplication
    def init = { servletContext ->
		
		if (User.count() == 0){
			def adminUser = new User(username:"admin", password: "password").save(failOnError:true)
			def userUser = new User(username:"joe", password: "password").save(failOnError:true, flush: true)
			def adminRole = new Role(authority: "ROLE_admin").save(failOnError: true)
			def userRole = new Role(authority: "ROLE_user").save(failOnError: true)
			new UserRole(user: adminUser, role: adminRole).save(failOnError:true)
			new UserRole(user: userUser, role: userRole).save(failOnError:true, flush:true)
		}
		
		if (ImportDetail.count() == 0 ){
			log.debug("ImportDetail.count is zero")
			
			def filePath = "resources/MOCK_DATA.csv"
			def myFile = grailsApplication.mainContext.getResource("classpath:$filePath").file
			def i = 1
			myFile.splitEachLine(',') {fields ->
				def importDetail = new ImportDetail(
					id					:		fields[0],
					billedQuantity		:		fields[1],
				//	bolDate				:		new SimpleDateFormat(fields[2].trim()),
					bolNumber			:		fields[3],
					buyerName			:		fields[4],
					consignorName		:		fields[5],
					diverted			:		fields[6],
					destinationState	:		fields[7]
					)
				importDetail.validate()
				if (importDetail.hasErrors()){
					log.debug("Could not import line ${i} due to ${importDetail.errors}")
				} else {
					log.debug("Importing line ${i}: ${importDetail.toString()}")
					importDetail.save(failOnError: true, flush: true)
				}
				++i
			}
		}
		
    }
    def destroy = {
    }
}
