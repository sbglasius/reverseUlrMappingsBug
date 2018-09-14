# reverseUlrMappingsBug
Shows the behavior of reverse urlMappings

*UrlMappings* question: When having an `UrlMapping` like this (simplified):
```
class UrlMappings {
  static mappings = {
        "/$controller/$action?/$id?(.$format)?"() 
        "/$caseId/$controller/$action?/$id?(.$format)?" {
            constraints {
                caseId(matches: CASE_ID)

            }
        }
  }
}
```
and a `<g:link controller: 'home', action: 'index', params: [caseId: null]/>` Grails matches the later url mapping and throws
```
Condition failed with Exception:

assertReverseUrlMapping('/show/index', controller: 'show', action: 'index') { caseId = null }
|
grails.web.mapping.exceptions.UrlMappingException: Unable to create URL for mapping [/(*)/(*)/(*)?/(*)?(.(*))?] and parameters [{caseId=null, controller=show, action=index}]. Parameter [caseId] is required, but was not specified!

Condition failed with Exception:

assertReverseUrlMapping('/show/index', controller: 'show', action: 'index') { caseId = null }
|
grails.web.mapping.exceptions.UrlMappingException: Unable to create URL for mapping [/(*)/(*)/(*)?/(*)?(.(*))?] and parameters [{caseId=null, controller=show, action=index}]. Parameter [caseId] is required, but was not specified!
```

I would have expected it to match the first url mapping, since the constraint for `caseId` is not met. Am I missing a point? This used to work in Grails 2.x, but is not in Grails 3.3.x
