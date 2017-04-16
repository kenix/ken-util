/*
* Created at 18:22 on 14/04/2017
*/
package org.kenix.util.alg;

/**
 * Weighted union find with path compression.
 *
 * @author zzhao
 */
public class WUFWPC extends WUF {

  public WUFWPC(int n) {
    super(n);
  }

  protected int root(int p) {
    while (p != this.id[p]) {
      this.id[p] = this.id[this.id[p]];
      p = this.id[p];
    }

    return p;
  }
}
