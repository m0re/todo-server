
package com.everyday.todoserver
import com.budjb.requestbuilder.*;

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Todo)
class TodoSpec extends Specification {
	
	def apiClient 
	
    def setup() {
	}

    def cleanup() {
    }

    void "create a Todo"() {
		when:
		def testData = new Todo(text: "test", status: "Active")
		testData.save(failOnError: true)
		
		then:
		testData.id > 0
		
		cleanup:
		testData.delete();
    }
	
	void "Edit Todo text"() {
		setup:
		def testData = new Todo(text: "test", status: "Active")
		testData.save(failOnError: true)
		when:
		testData.text = "new String"
		testData.save(failOnError: true)
		def id = testData.id
		
		then:
		def edited = Todo.findById(id)
		edited.text.equals("new String")
		
		cleanup:
		testData.delete();
	}
	
	void "Edit Todo status"() {
		setup:
		def testData = new Todo(text: "test", status: "Active")
		testData.save(failOnError: true)
		when:
		testData.status = "Completed"
		testData.save(failOnError: true)
		def id = testData.id
		
		then:
		def edited = Todo.findById(id)
		edited.status.equals("Completed")
		
		cleanup:
		testData.delete();
	}
	
	void "Delete Todos"() {
		setup:
		def testData = new Todo(text: "test", status: "Active")
		testData.save(failOnError: true)
		when:
		testData.status = "Completed"
		testData.save(failOnError: true)
		def id = testData.id
		testData.delete();
		
		then:
		def edited = Todo.findById(id)
		edited == null
	}
}
