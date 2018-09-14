package reverseurlmappingbug

class ShowController {

    def index() {
        render "show:index"
    }

    def open(String caseId) {
        render "show:open:$caseId"
    }
}
