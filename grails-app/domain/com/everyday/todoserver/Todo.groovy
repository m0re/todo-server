package com.everyday.todoserver

import grails.rest.Resource;

@Resource(formats=["json"], uri="/todo")
class Todo {
	String text;
	String status;
	def test (){
	
	}
    static constraints = {
    }
}
