/*
* Created at 13:36 on 17.04.17
*/
package org.kenix.util.alg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

/**
 * @author zzhao
 */
public abstract class PQ<T extends Comparable<T>> {

  private final ArrayList<T> nodes;

  public PQ() {
    this.nodes = new ArrayList<>();
    this.nodes.add(null); // left out
  }

  public void insert(T... nodes) {
    Arrays.stream(nodes).forEach(node -> {
      this.nodes.add(node);
      swim(this.nodes.size() - 1);
    });
  }

  private void swim(int k) {
    while (k > 1 && !isRightOrder(k, k / 2)) {
      exch(k, k / 2);
      k /= 2;
    }
  }

  public boolean isEmpty() {
    return this.nodes.size() <= 1;
  }

  protected T get(int idx) {
    return this.nodes.get(idx);
  }

  protected abstract boolean isRightOrder(int leaf, int root);

  private void exch(int a, int b) {
    if (a == b) {
      return;
    }
    final T t = this.nodes.get(a);
    this.nodes.set(a, this.nodes.get(b));
    this.nodes.set(b, t);
  }

  public Optional<T> root() {
    return Optional.ofNullable(this.nodes.get(Math.min(1, this.nodes.size() - 1)));
  }

  public T removeRoot() {
    final T r = this.nodes.get(Math.min(1, this.nodes.size() - 1));
    if (r == null) {
      return null;
    }

    exch(1, this.nodes.size() - 1);

    final T result = this.nodes.remove(this.nodes.size() - 1);
    if (this.nodes.size() > 1) {
      sink(1);
    }

    return result;
  }

  private void sink(int i) {
    while (i < this.nodes.size()) {
      int cIdx = i * 2;
      if (cIdx + 1 < this.nodes.size() && isRightOrder(cIdx, cIdx + 1)) {
        cIdx = cIdx + 1;
      }

      if (cIdx < this.nodes.size() && !isRightOrder(cIdx, i)) {
        exch(i, cIdx);
        i = cIdx;
      } else {
        return;
      }
    }
  }

  @Override
  public String toString() {
    return getClass().getSimpleName();
  }
}
