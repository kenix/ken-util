package org.kenix.util.base

import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author zzhao
 */
class CollectionUtilSpec extends Specification {

  @Unroll
  def '#ein heap sort: #aus'() {
    when:
    def items = ein as Integer[]
    CollectionUtil.heapSort(items)
    then:
    items == aus as Integer[]

    where:
    ein                            | aus
    [0, 2, 1]                      | [0, 1, 2]
    [1, 3, 5, 2, 4, 6]             | [1, 2, 3, 4, 5, 6]
    [1, 5, 0, 3, 6, 4, 2]          | [0, 1, 2, 3, 4, 5, 6]
    [9, 3, 4, 5, 0, 8, 2, 1, 7, 6] | [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
  }
}
