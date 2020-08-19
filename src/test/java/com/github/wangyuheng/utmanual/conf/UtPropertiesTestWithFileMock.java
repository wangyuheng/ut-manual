package com.github.wangyuheng.utmanual.conf;

import com.github.wangyuheng.utmanual.conf.UtProperties;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.File;

import static org.mockito.BDDMockito.given;

/**
 * Mock File By Mockito
 */
public class UtPropertiesTestWithFileMock {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Mock
    private File fileMock;

    @Before
    public void setUp() {
        // before set mock value
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void should_throw_illegal_when_path_cannot_read() {
        given(this.fileMock.exists()).willReturn(true);
        given(this.fileMock.canRead()).willReturn(false);
        given(this.fileMock.canWrite()).willReturn(true);
        UtProperties properties = new UtProperties();
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("cannot be read");
        properties.setPath(fileMock);
    }

}
