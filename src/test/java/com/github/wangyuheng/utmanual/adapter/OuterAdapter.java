package com.github.wangyuheng.utmanual.adapter;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertNull;

@Ignore
public class OuterAdapter {

    @Test
    public void request_for_debug(){
        String result = new RestTemplate().getForObject("http://www.baidu.com", String.class);
        assertNull(result);
    }

}
