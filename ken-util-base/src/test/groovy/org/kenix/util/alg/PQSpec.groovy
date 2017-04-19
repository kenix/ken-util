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

  @Unroll
  def '#pq remove root'() {
    when:
    pq.insert(9, 3, 4, 5, 0, 8, 2, 1, 7, 6)
    then:
    pq.removeRoot() == result[0]
    pq.removeRoot() == result[1]
    pq.removeRoot() == result[2]
    pq.removeRoot() == result[3]
    pq.removeRoot() == result[4]
    pq.removeRoot() == result[5]
    pq.removeRoot() == result[6]
    pq.removeRoot() == result[7]
    pq.removeRoot() == result[8]
    pq.removeRoot() == result[9]
    pq.isEmpty()

    where:
    pq                   | result
    new PqMin<Integer>() | 0..9
    new PqMax<Integer>() | 9..0
  }
}
