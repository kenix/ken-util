package org.kenix.util.alg

import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author zzhao
 */
class DutchNationalFlagSpec extends Specification {

  @Unroll
  def '#flags to #sortedFlags'() {
    given:
    def dnf = new DutchNationalFlag(t0, t1, t2)

    when:
    dnf.sort(flags)
    then:
    flags == sortedFlags

    where:
    t0  | t1  | t2  | flags                                       | sortedFlags
    0   | 1   | 2   | [2, 0, 0, 1, 2, 1] as ArrayList             | [0, 0, 1, 1, 2, 2] as ArrayList
    0   | 1   | 2   | [2, 0, 0, 1, 2, 1] as Integer[]             | [0, 0, 1, 1, 2, 2] as Integer[]
    'a' | 'b' | 'c' | ['b', 'c', 'a', 'a', 'b', 'c'] as ArrayList | ['a', 'a', 'b', 'b', 'c', 'c'] as ArrayList
    'a' | 'b' | 'c' | ['b', 'c', 'a', 'a', 'b', 'c'] as String[]  | ['a', 'a', 'b', 'b', 'c', 'c'] as String[]
  }
}
