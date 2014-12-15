package com.twitterui
import org.apache.commons.collections.ListUtils.*
import org.apache.commons.collections.Factory.*
import grails.validation.Validateable

class EditController {

    def index() { }
	
	def multiple() {
		if (params.max == null) {params.max = 20}
		def detailCommand = new DetailCommand(detail : ImportDetail.list(params));
//		detailCommand.detail = ImportDetail.list(params)
		def fields = detailFields()

		
		return ['detailCommand' : detailCommand, 'fields' : fields, 'detailCount' : ImportDetail.count(), 'params' : params ]
	}
		
	def saveDetail(DetailCommand detailCommand) {
		log.debug("in saveDetail: " + detailCommand.detail.dump())
		def fields = detailFields()
		detailCommand.detail.each() {
			it.validate()
			log.debug("in detail: each. " + it.dump())
			if (! it.hasErrors()){
				log.debug("about to save")
				it.save(flush: true)
			} else {
				log.debug(it.errors.dump())
			}
		}
		render (template:'editDetailList', model:['detailCommand':detailCommand, 'fields':fields, 'detailCount' : ImportDetail.count()] )
		
	}
	
	def detailFields() {
		return [
			new FieldItem(field: 'id', displayName: 'id'),
			new FieldItem(field: 'billedQuantity', displayName: 'Billed Quantity', type: "text", error:"Must be between 1 and 1000"),
			new FieldItem(field: 'bolNumber', displayName: 'Bol Number', type: "text", error:"Must be between 1 and 99999"),
			new FieldItem(field: 'buyerName', displayName: 'Buyer Name', type: "text", error:"Valiation error?"),
			new FieldItem(field: 'consignorName', displayName: 'Consignor Name', type: "text", error:"Validation error?"),
			new FieldItem(field: 'destinationState', displayName: 'Destination State', type: "text", error:"Must be full state name.  Ex. 'South Dakota'")
			]
	}
}

@Validateable
class DetailCommand {
	List<ImportDetail> detail //= ListUtils.lazyList([], {new ImportDetail()} as Factory)
}
