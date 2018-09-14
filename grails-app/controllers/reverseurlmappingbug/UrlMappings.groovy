package reverseurlmappingbug

class UrlMappings {
    static String CASE_ID = /^\d{2}-\d{2}$/

    static mappings = {
        // Rule 0
        "/"(controller: 'home', action: 'index')

        // Rule 1
        "/$controller/$action?/$id?(.$format)?" {
            constraints {
                // apply constraints here
            }
        }

        // Rule 2
        "/$caseId" {
            controller = "home"
            action = "open"
            constraints {
                caseId(matches: CASE_ID)
            }
        }


        // Rule 3
        "/goto/$caseId" {
            controller = "case"
            constraints {
                caseId(matches: CASE_ID)
            }
        }

        // Rule 4
        "/goto/$action/$caseId" {
            controller = "case"
            constraints {
                caseId(matches: CASE_ID)
            }
        }

        // Rule 5
        "/$caseId/$controller/$action?/$id?(.$format)?" {
            constraints {
                caseId(matches: CASE_ID)

            }
        }

        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
