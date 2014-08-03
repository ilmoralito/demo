package demo

class OwnerController {
	
	static defaultAction = "index"

    def index() {
		def owners = Owner.list()
		
		[owners:owners]
	}
	
	def show(Integer id) {
		def owner = Owner.get(id)
		
		if (!owner) {
			response.sendError 404
		}
		
		[o:owner, pets:owner.pets]
	}
	
	def create() {
		[o: new Owner(params)]
	}
	 
	def save() {
		//name:params?.name, city:params?.city, email:params?.email
		def owner = new Owner(params)
		
		if (!owner.save()) {
			response.sendError 502
		}
		
		redirect action:"create"	
	}
}
