package com.everyday.todoserver

import grails.rest.RestfulController;

class TodoController extends RestfulController {
    static responseFormats = ['json', 'xml']
    TodoController() {
        super(Todo)
    }
	def index(String status) {
		if(!status){
			respond Todo.list()
		}
	    respond Todo.findAllWhere(status: status)
	}
}