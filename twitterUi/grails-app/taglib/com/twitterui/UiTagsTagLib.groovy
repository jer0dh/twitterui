package com.twitterui

class UiTagsTagLib {
    static defaultEncodeAs = [taglib:'html']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]
	static namespace = "exa"
	
	//Used to create a list of css classes from a comma delimited list of className:booleanValue.  If the booleanValue is true, then the className is listed
	// ex. <li class="${exa.classList(disabled:!session.step1)}">
	//  if session.step1 is false then boolean expression evaluates to true thus including the css class name of "disabled" 
	def classList = { attr ->
		attr.each {k,v ->
			if(v) {
				out << k + " "
			}
		}
	}
}
