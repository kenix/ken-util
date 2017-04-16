/*
* Created at 18:22 on 14/04/2017
*/
package org.kenix.util.alg;

import java.util.Arrays;

/**
 * Weighted union find.
 *
 * @author zzhao
 */
public class WUF {

  protected final int[] id;

  protected final int[] weight;

  public WUF(int n) {
    this.id = new int[n];
    for (int i = 0; i < this.id.length; i++) {
      this.id[i] = i;
    }
    this.weight = new int[n];
    Arrays.fill(this.weight, 1);
  }

  protected int root(int p) {
    int r = p;
    while (r != this.id[r]) {
      r = this.id[r];
    }
    return r;
  }

  public boolean connected(int p, int q) {
    return root(p) == root(q);
  }

  public void union(int p, int q) {
    final int rootP = root(p);
    final int rootQ = root(q);

    if (rootP == rootQ) {
      return;
    }

    if (this.weight[rootP] < this.weight[rootQ]) {
      this.id[rootP] = rootQ;
      this.weight[rootQ] += this.weight[rootP];
    } else {
      this.id[rootQ] = rootP;
      this.weight[rootP] += this.weight[rootQ];
    }
  }
}
