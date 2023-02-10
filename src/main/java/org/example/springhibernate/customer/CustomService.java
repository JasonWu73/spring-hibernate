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
     * 根据客户 id 获取客户。
     *
     * @param customerId 客户 id
     * @return 客户
     */
    @Transactional(rollbackFor = Exception.class)
    public Customer getCustomer(long customerId) {
        return customerDao.getCustomer(customerId);
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

    /**
     * 更新客户。
     *
     * @param customer 最新的客户数据
     */
    @Transactional(rollbackFor = Exception.class)
    public void update(Customer customer) {
        customerDao.update(customer);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteCustomer(long customerId) {
        customerDao.delete(customerId);
    }
}
