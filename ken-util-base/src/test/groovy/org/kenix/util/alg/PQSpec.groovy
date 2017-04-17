package org.kenix.util.alg

import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author zzhao
 */
class PQSpec extends Specification {

  @Unroll
  def "#pq 's root is #root"() {
    when:
    pq.insert('G', 'T', 'P', 'A', 'S', 'N', 'H', 'R', 'O', 'E', 'I')
    then:
    pq.root().get() == root

    where:
    pq          | root
    new PqMin() | 'A'
    new PqMax() | 'T'
  }
}
