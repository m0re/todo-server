import com.everyday.todoserver.Todo

class BootStrap {

    def init = { servletContext ->
		def todoOne = new Todo(
			text: "Eat",
			status: "Active"
		);
		def todoTwo = new Todo(
			text: "Develop",
			status: "Active"
		);
		def todoThree = new Todo(
			text: "Sleep",
			status: "Active"
		);
	
		todoOne.save flush:true
		todoTwo.save flush:true
		todoThree.save flush:true
    }
    def destroy = {
    }
}
