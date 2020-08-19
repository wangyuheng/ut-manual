package com.github.wangyuheng.utmanual.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommonRepository extends JpaRepository<CommonDo, Long> {

    List<CommonDo> findAllByName(String name);

}
