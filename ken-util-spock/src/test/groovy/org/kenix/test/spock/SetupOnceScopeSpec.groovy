package org.kenix.test.spock

import groovy.util.logging.Slf4j
import spock.lang.Specification

/**
 * @author zzhao
 */
@Slf4j
class SetupOnceScopeSpec extends Specification {
    def setupSpec() {
        log.info("<setupSpec> ");
    }

    def cleanupSpec() {
        log.info("<cleanupSpec> ");
    }

    def setup() {
        log.info("<setup> ");
    }

    def cleanup() {
        log.info("<cleanup> ");
    }

    @SetupOnceExtensionAnnotation(setupMethodName = 'setupOnceMethod', cleanupMethodName = 'cleanupOnceMethod')
    def 'feature one'() {
        setup:
        log.info("<feature one> setup");

        expect:
        true
        log.info("<feature one> performing assertions $x");


        cleanup:
        log.info("<feature one> cleanup");

        where:
        x << [1, 2, 3]
    }

    @SetupOnceExtensionAnnotation(setupMethodName = 'setupOnceMethod')
    def 'feature two'() {
        expect:
        true
        log.info("<feature two> ");
    }

    void setupOnceMethod() {
        log.info("<setupOnceMethod> ");
    }

    void cleanupOnceMethod() {
        log.info("<cleanupOnceMethod> ");
    }
}
