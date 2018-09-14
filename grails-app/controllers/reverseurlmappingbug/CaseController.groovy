package reverseurlmappingbug

class CaseController {

    def index(String caseId) {
        render "case:index:$caseId"
    }

    def open(String caseId) {
        render "case:open:$caseId"
    }
}
