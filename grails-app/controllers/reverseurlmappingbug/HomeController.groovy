package reverseurlmappingbug

class HomeController {
    static defaultAction = "index"
    def index() {
        render "home:index"
    }

    def open(String caseId) {
        render "home:open:$caseId"
    }
}
