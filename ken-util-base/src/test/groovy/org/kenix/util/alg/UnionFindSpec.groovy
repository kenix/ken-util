package org.kenix.util.alg

import groovy.util.logging.Slf4j
import spock.lang.Shared
import spock.lang.Specification

/**
 * @author zzhao
 */
@Slf4j
class UnionFindSpec extends Specification {

    @Shared
    WUF wuf = new WUF(10)

    @Shared
    WUFWPC wufwpc = new WUFWPC(10)

    @Shared
    UFWPC ufwpc = new UFWPC(10)

    def 'WUF0~9 u(#p, #q), c(#a, #b): #result'() {
        when:
        wuf.union(p, q)
        log.info("u({}, {}) id {}", p, q, wuf.id)
        log.info("   weight: {}", wuf.weight)
        then:
        wuf.connected(a, b) == result

        where:
        p | q | a | b | result
        4 | 3 | 3 | 4 | true
        3 | 8 | 4 | 4 | true
        6 | 5 | 5 | 4 | false
        9 | 4 | 3 | 9 | true
        2 | 1 | 1 | 9 | false
        5 | 0 | 6 | 0 | true
        7 | 2 | 7 | 1 | true
        6 | 1 | 5 | 2 | true
        7 | 3 | 0 | 9 | true
        7 | 3 | 0 | 9 | true
    }

    def 'WUFWPC0~9 u(#p, #q), c(#a, #b): #result'() {
        when:
        wufwpc.union(p, q)
        log.info("u({}, {}) id {}", p, q, wufwpc.id)
        log.info("   weight: {}", wufwpc.weight)
        then:
        wufwpc.connected(a, b) == result

        where:
        p | q | a | b | result
        4 | 3 | 3 | 4 | true
        3 | 8 | 4 | 4 | true
        6 | 5 | 5 | 4 | false
        9 | 4 | 3 | 9 | true
        2 | 1 | 1 | 9 | false
        5 | 0 | 6 | 0 | true
        7 | 2 | 7 | 1 | true
        6 | 1 | 5 | 2 | true
        7 | 3 | 0 | 9 | true
    }

    def 'UFWPC0~9 u(#p, #q), c(#a, #b): #result'() {
        when:
        ufwpc.union(p, q)
        log.info("u({}, {}) id {}", p, q, ufwpc.id)
        then:
        ufwpc.connected(a, b) == result

        where:
        p | q | a | b | result
        4 | 3 | 3 | 4 | true
        3 | 8 | 4 | 4 | true
        6 | 5 | 5 | 4 | false
        9 | 4 | 3 | 9 | true
        2 | 1 | 1 | 9 | false
        5 | 0 | 6 | 0 | true
        7 | 2 | 7 | 1 | true
        6 | 1 | 5 | 2 | true
        7 | 3 | 0 | 9 | true
    }
}
