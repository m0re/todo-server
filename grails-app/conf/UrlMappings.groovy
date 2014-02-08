class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.${format})?"{
            constraints {
                // apply constraints here
            }
        }
		"/todo"(resources: "todo")
		"/todo/$id?"(resource:"todo")
        "/"(view:"/index")
        "500"(view:'/error')
	}
}
