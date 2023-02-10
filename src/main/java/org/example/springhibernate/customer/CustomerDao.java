package org.example.springhibernate.customer;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CustomerDao {

    private final SessionFactory sessionFactory;

    /**
     * 获取客户列表。
     *
     * @return 客户列表
     */
    public List<Customer> getCustomers() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery(
                "from Customer c order by c.lastName",
                Customer.class
            )
            .getResultList();
    }

    /**
     * 根据客户 id 获取客户。
     *
     * @param customerId 客户 id
     * @return 客户
     */
    public Customer getCustomer(long customerId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Customer.class, customerId);
    }

    /**
     * 保存客户。
     *
     * @param customer 需要保存的客户
     */
    public void save(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(customer);
    }

    /**
     * 更新客户。
     *
     * @param customer 最新的客户数据
     */
    public void update(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(customer);
    }

    public void delete(long customerId) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = session.get(Customer.class, customerId);
        session.remove(customer);
    }
}
