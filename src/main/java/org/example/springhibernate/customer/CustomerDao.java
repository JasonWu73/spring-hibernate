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
     * 保存客户。
     *
     * @param customer 需要保存的客户
     */
    public void save(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(customer);
    }
}
