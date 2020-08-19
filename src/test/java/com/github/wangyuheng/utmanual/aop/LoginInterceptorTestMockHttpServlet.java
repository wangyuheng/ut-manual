package com.github.wangyuheng.utmanual.aop;

import com.github.wangyuheng.utmanual.conf.UtProperties;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

/**
 * Mock HttpServlet header
 */
@RunWith(MockitoJUnitRunner.class)
public class LoginInterceptorTestMockHttpServlet {

    @InjectMocks
    private LoginInterceptor loginInterceptor;
    @Mock
    private UtProperties utProperties;
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;

    @Before
    public void setUp() {
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
    }

    @Test
    public void should_return_false_when_enable_and_header_auth_not_existed() throws Exception {
        when(utProperties.isEnable()).thenReturn(true);
        assertFalse(loginInterceptor.preHandle(request, response, null));
    }

    @Test
    public void should_return_true_when_enable_and_header_auth_existed() throws Exception {
        when(utProperties.isEnable()).thenReturn(true);
        request.addHeader("Authorization", "test");
        assertTrue(loginInterceptor.preHandle(request, response, null));
    }

    @Test
    public void should_return_true_when_not_enable_and_header_auth_not_existed() throws Exception {
        when(utProperties.isEnable()).thenReturn(false);
        assertTrue(loginInterceptor.preHandle(request, response, null));
    }

    @Test
    public void should_return_true_when_not_enable_and_header_auth_existed() throws Exception {
        when(utProperties.isEnable()).thenReturn(false);
        request.addHeader("Authorization", "test");
        assertTrue(loginInterceptor.preHandle(request, response, null));
    }

}
