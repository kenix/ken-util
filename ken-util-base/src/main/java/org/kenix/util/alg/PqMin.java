/*
* Created at 13:36 on 17.04.17
*/
package org.kenix.util.alg;

/**
 * @author zzhao
 */
public class PqMin<T extends Comparable<T>> extends PQ<T> {

  @Override
  protected boolean isRightOrder(int leaf, int root) {
    return get(leaf).compareTo(get(root)) > 0;
  }
}
