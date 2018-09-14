package reverseurlmappingbug

import grails.testing.web.UrlMappingsUnitTest
import spock.lang.Specification

class UrlMappingsSpec extends Specification implements UrlMappingsUnitTest<UrlMappings> {
    Class[] getControllersToMock() {
        [HomeController, CaseController, ShowController]
    }

     def "test url mappings rule 0"() {
        expect:
            assertUrlMapping('/', controller: 'home', action: 'index')
    }

    def "test reverse url mappings rule 0"() {
        expect:
            assertReverseUrlMapping('/', controller: 'home', action: 'index')
    }

    def "test url mappings rule 1"() {
        expect:
            assertUrlMapping('/home', controller: 'home', action: 'index')
    }

    def "test url mappings rule 1.1"() {
        expect:
            assertUrlMapping('/show', controller: 'show', action: 'index')
    }

    def "test url mappings rule 1.2"() {
        expect:
            assertUrlMapping('/show/index', controller: 'show', action: 'index')
    }

    def "test url mappings rule 1.3"() {
        expect:
            assertUrlMapping('/show/index/abc', controller: 'show', action: 'index') { id = 'abc'}
    }

    def "test reverse url mappings rule 1"() {
        expect:
            assertReverseUrlMapping('/show/index', controller: 'show', action: 'index') { caseId = null }
    }
    def "test reverse url mappings rule 1.1"() {
        expect:
            assertReverseUrlMapping('/show/index', controller: 'show', action: 'index')
    }

    def "test url mappings rule 2"() {
        expect:
            assertUrlMapping('/10-10', controller: 'home', action: 'open') { caseId = '10-10' }
    }

    def "test url mappings rule 3"() {
        expect:
            assertUrlMapping('/goto/10-10', controller: 'case') { caseId = '10-10' }
    }

    def "test url mappings rule 4"() {
        expect:
            assertUrlMapping('/goto/open/10-10', controller: 'case', action: 'open') { caseId = '10-10' }
    }

    def "test url mappings rule 5.1"() {
        expect:
            assertUrlMapping('/10-10/show', controller: 'show', action: 'index') { caseId = '10-10' }
    }

    def "test url mappings rule 5.2"() {
        expect:
            assertUrlMapping('/10-10/show/index', controller: 'show', action: 'index') { caseId = '10-10' }
    }
    def "test url mappings rule 5.3"() {
        expect:
            assertUrlMapping( '/10-10/show/open', controller: 'show', action: 'open') { caseId = '10-10' }
    }

    def "test url mappings rule 5.4"() {
        expect:
            assertUrlMapping('/10-10/show/index/abc', controller: 'show', action: 'index', { caseId = '10-10'; id = 'abc' })
    }

    def "test url mappings rule 5.5"() {
        expect:
            assertUrlMapping('/10-10/show/open/abc', controller: 'show', action: 'open', { caseId = '10-10'; id = 'abc' })
    }

    def "test forward mappings"() {
    }

}
