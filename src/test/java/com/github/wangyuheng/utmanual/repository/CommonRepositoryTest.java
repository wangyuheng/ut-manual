package com.github.wangyuheng.utmanual.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Test DB with H2
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CommonRepositoryTest {

    @Autowired
    private CommonRepository commonRepository;

    @Test
    public void test_crud(){
        CommonDo commonDo = new CommonDo();
        commonDo.setName("abc");
        //create
        CommonDo item = commonRepository.save(commonDo);
        assertEquals(Long.valueOf(1), item.getId());
        assertEquals(commonDo.getName(), item.getName());
        //read
        item = commonRepository.findById(1L).orElseThrow(NullPointerException::new);
        assertEquals(Long.valueOf(1), item.getId());
        assertEquals(commonDo.getName(), item.getName());
        //update
        item.setName("bc");
        commonRepository.save(item);
        item = commonRepository.findById(1L).orElseThrow(NullPointerException::new);
        assertEquals(Long.valueOf(1), item.getId());
        assertEquals("bc", item.getName());
        //delete
        commonRepository.deleteById(1L);
        assertFalse(commonRepository.findById(1L).isPresent());
    }

}
