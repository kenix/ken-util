/*
* Created at 13:36 on 17.04.17
*/
package org.kenix.util.alg;

/**
 * @author zzhao
 */
public class PqMax<T extends Comparable<T>> extends PQ<T> {

  @Override
  protected boolean isRightOrder(int leaf, int root) {
    return get(root).compareTo(get(leaf)) > 0;
  }
}
