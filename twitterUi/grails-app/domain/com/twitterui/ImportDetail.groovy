package com.twitterui

class ImportDetail {

	Integer billedQuantity
	Date bolDate
	Integer bolNumber
	String buyerName
	String consignorName
	Boolean diverted
	String destinationState
	
    static constraints = {
		billedQuantity max:1000, min: 1
		bolDate nullable:true
		bolNumber max:99999, min:1
		buyerName nullable:false
		consignorName nullable: false
		destinationState inList: ['Alabama', 'Alaska', 'Arizona', 'Arkansas', 'California', 'Colorado', 'Connecticut', 'Delaware', 'Florida', 'Georgia', 'Hawaii', 'Idaho', 'Illinois', 'Indiana', 'Iowa', 'Kansas', 'Kentucky', 'Louisiana', 'Maine', 'Maryland', 'Massachusetts', 'Michigan', 'Minnesota', 'Mississippi', 'Missouri', 'Montana', 'Nebraska', 'Nevada', 'New Hampshire', 'New Jersey', 'New Mexico', 'New York', 'North Carolina', 'North Dakota', 'Ohio', 'Oklahoma', 'Oregon', 'Pennsylvania', 'Rhode Island', 'South Carolina', 'South Dakota', 'Tennessee', 'Texas', 'Utah', 'Vermont', 'Virginia', 'Washington', 'West Virginia', 'Wisconsin', 'Wyoming']
    }
}
