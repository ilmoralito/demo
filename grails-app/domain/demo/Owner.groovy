package demo

class Owner {
	
	String name
	String city
	String email

    static constraints = {
		name blank:false
		city blank:false, inList:["Leon", "Esteli", "Managua"]
		email blank:false, unique:true, email:true
    }
	
	List pets
	
	static hasMany = [pets:Pet]
	
	String toString() { name } 
}
