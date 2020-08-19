package com.github.wangyuheng.utmanual.service;

import com.github.wangyuheng.utmanual.repository.CommonDo;
import com.github.wangyuheng.utmanual.repository.CommonRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class BizService {

    @Value("${period:100}")
    public Integer period;

    private final CommonRepository commonRepository;

    public BizService(CommonRepository commonRepository) {
        this.commonRepository = commonRepository;
    }

    public void biz(int times) {
        while (times-- > 0) {
            this.secret();
        }
    }

    public String getNameById(long id) {
        Assert.isTrue(id > 0, "id must greater than zero");
        return commonRepository.findById(id)
                .map(CommonDo::getName)
                .orElse(null);
    }

    public Integer getPeriod() {
        return period;
    }

    private void secret() {
        System.out.println("do private");
    }

}
