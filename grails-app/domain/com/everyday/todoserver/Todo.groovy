package com.everyday.todoserver

import grails.rest.Resource;

class Todo {
	String text;
	String status;

    static constraints = {
		text size: 1..10, blank: false, unique: true
    }
}
