package com.cnh.bluetooth.inter;

/**
 * Created by Administrator on 2017/4/6.
 */

public interface Pullable {

    /**
     * 是否可以下拉
     * @return
     */
    boolean canPullDown();


    /**
     * 是否可以上拉
     * @return
     */
    boolean canPullUp();

}
