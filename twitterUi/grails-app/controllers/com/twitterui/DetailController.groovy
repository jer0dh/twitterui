package com.twitterui

class DetailController {

    def index() { 
		if (params.max == null) {params.max = 20}
		def detail = ImportDetail.list(params)
		def fields = [
			new FieldItem(field: 'id', displayName: 'id'),
			new FieldItem(field: 'billedQuantity', displayName: 'Billed Quantity'),
			new FieldItem(field: 'bolNumber', displayName: 'Bol Number'),
			new FieldItem(field: 'buyerName', displayName: 'Buyer Name'),
			new FieldItem(field: 'consignorName', displayName: 'Consignor Name'),
			new FieldItem(field: 'destinationState', displayName: 'Destination State')
			]

			
			//			 'billedQuantity', 'bolNumber','buyerName','consignorName','destinationState']
		return ['detail' : detail, 'fields' : fields, 'detailCount' : ImportDetail.count(), 'params' : params ]
	}
}


class FieldItem {
	String field
	String displayName
	String type
	String error
}