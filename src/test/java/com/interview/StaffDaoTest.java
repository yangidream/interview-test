package com.interview;

import com.interview.dao.StaffExtendDao;
import com.interview.entity.StaffExtendDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StaffDaoTest {

    @Autowired
    private StaffExtendDao staffExtendDao;

    @Test
    public void testSelectAllWithGroup() {
        List<StaffExtendDO> staffDOList = staffExtendDao.selectAllExtend();
        for (StaffExtendDO staffDO : staffDOList) {
            System.out.println(staffDO.getId() + ":" + staffDO.getAge() + ":" + staffDO.getUsername() + ":" +
                    staffDO.getDepartment() + ":" + staffDO.getSalary() + ":" + staffDO.getCountUsername() + ":" + staffDO.getSumSalary());
        }
    }
}
