package com.github.wangyuheng.utmanual.service;

import com.github.wangyuheng.utmanual.repository.CommonDo;
import com.github.wangyuheng.utmanual.repository.CommonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.verification.Times;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.anyLong;

@RunWith(PowerMockRunner.class)
@PrepareForTest(BizService.class)
public class BizServiceTest {

    @Test
    public void count_handle_private_method_times() throws Exception {
        BizService bizService = PowerMockito.spy(new BizService(PowerMockito.mock(CommonRepository.class)));
        bizService.biz(10);
        PowerMockito.verifyPrivate(bizService, new Times(10)).invoke("secret");
    }

    @Test
    public void set_private_field() throws IllegalAccessException {
        BizService bizService = PowerMockito.spy(new BizService(PowerMockito.mock(CommonRepository.class)));
        assertEquals(null, bizService.getPeriod());
        PowerMockito.field(BizService.class, "period").set(bizService, 500);
        assertEquals(Integer.valueOf(500), bizService.getPeriod());
    }

    @Test
    public void mock_repo_with_unique_param(){
        CommonDo commonDo = new CommonDo();
        commonDo.setId(3L);
        commonDo.setName("mockName");

        CommonRepository commonRepository = PowerMockito.mock(CommonRepository.class);
        PowerMockito.when(commonRepository.findById(3L)).thenReturn(Optional.of(commonDo));

        BizService bizService = new BizService(commonRepository);
        assertNull(bizService.getNameById(1));
        assertEquals("mockName",bizService.getNameById(3));
    }

    @Test
    public void mock_repo_with_wildcard_param(){
        CommonDo commonDo = new CommonDo();
        commonDo.setId(3L);
        commonDo.setName("mockName");

        CommonRepository commonRepository = PowerMockito.mock(CommonRepository.class);
        PowerMockito.when(commonRepository.findById(anyLong())).thenReturn(Optional.of(commonDo));

        BizService bizService = new BizService(commonRepository);
        assertEquals("mockName", bizService.getNameById(1));
        assertEquals("mockName",bizService.getNameById(3));
    }

}