package org.example.springhibernate.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomService {

    private final CustomerDao customerDao;

    /**
     * 获取客户列表。
     *
     * @return 客户列表
     */
    @Transactional(rollbackFor = Exception.class)
    public List<Customer> getCustomers() {
        return customerDao.getCustomers();
    }

    /**
     * 保存客户。
     *
     * @param customer 需要保存的客户
     */
    @Transactional(rollbackFor = Exception.class)
    public void save(Customer customer) {
        customerDao.save(customer);
    }
}
