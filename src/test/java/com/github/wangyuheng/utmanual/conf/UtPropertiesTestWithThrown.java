package com.github.wangyuheng.utmanual.conf;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * expected throw exception
 */
public class UtPropertiesTestWithThrown {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void should_throw_npe_when_path_is_null() {
        UtProperties properties = new UtProperties();
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("path is null");
        properties.setPath(null);
    }

}
