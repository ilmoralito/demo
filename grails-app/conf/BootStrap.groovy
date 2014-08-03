//import demo.Owner
//import demo.Pet

import demo.*

class BootStrap {

    def init = { servletContext ->
		def luis = new Owner(name:"Luis", city:"Leon", email:"luis@gmail.com")
		def nami = new Pet(name:"nami", type:"Dog", age:1)
		def peluso = new Pet(name:"peluso", type:"Dog", age:4)
		
		luis.addToPets nami
		luis.addToPets peluso
		
		luis.save()
		
		def ricardo = new Owner(name:"Ricardo", city:"Leon", email:"ricardo@gmail.com")
		
		def boby = new Pet(name:"boby", type:"Dog", age:5)
		def isabel = new Pet(name:"isabel", type:"Cat", age:1)
		
		ricardo.addToPets boby
		ricardo.addToPets isabel
		
		ricardo.save()
		
		def mario = new Owner(name:"Mario", city:"Leon", email:"mario@gmail.com")
		
		def juan = new Pet(name:"juan", type:"Parrot", age:2)
		
		mario.addToPets juan
		
		mario.save()
		
		assert Owner.count() == 3
		assert Pet.count() == 5
    }
    def destroy = {
    }
}
