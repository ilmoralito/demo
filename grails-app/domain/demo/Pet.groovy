package demo

class Pet {
	
	String name
	String type
	Integer age

    static constraints = {
		name blank:false
		type inList:["Dog", "Cat", "Parrot"], maxSize:255
		age nullable:false, min:0
    }
	
	static belongsTo = [owner:Owner]
	
	String toString() {
		name
	}
}
