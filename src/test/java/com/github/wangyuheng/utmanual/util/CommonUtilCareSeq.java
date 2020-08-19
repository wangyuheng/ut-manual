package com.github.wangyuheng.utmanual.util;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CommonUtilCareSeq {

    private static int i = 0;

    @Test
    public void b() {
        assertEquals(2, ++i);
    }

    @Test
    public void a() {
        assertEquals(1, ++i);
    }

    @Test
    public void c1() {
        assertEquals(3, ++i);
    }
}
