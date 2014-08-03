package demo

class PetController {

    def index() {
		
	}
	
	def create() {
		[pet:new Pet(params)]
	}
	
	
	def show(Integer id) {
		def pet = Owner.get(id)
		
		if (!pet) {
			response.sendError 404
		}
		
		[p:pet]
	}
	

	def save(Integer ownerId) {
		def owner = Owner.get(ownerId)
		
		if (!owner) {
			response.sendError(404)
		}
		
		def pet = new Pet(params)
		
		owner.addToPets pet
		
		pet.save()
		
		redirect controller:"owner", action:"show", id:ownerId
	}	
	

	def delete(Integer petId, Integer ownerId)
	{
		def pet = Pet.get(petId)
		pet.delete(flush: true)
		
		if (!pet) {
			response.sendError 404
		}
		
		redirect controller:"owner", action:"show", id:ownerId
		
	}
}
