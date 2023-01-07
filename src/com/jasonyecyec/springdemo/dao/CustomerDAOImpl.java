package com.jasonyecyec.springdemo.dao;

import com.jasonyecyec.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

    //need to inject session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {

        // get the current hibernate session
        Session session = sessionFactory.getCurrentSession();

        //delete object with primary key
        Query query = session.createQuery("from Customer order by lastName", Customer.class);

        List<Customer> customers = query.getResultList();
        // return the results
        return customers;
    }


    @Override
    public Customer getCustomer(int customerId) {
        //get current hibernate session
        Session session = sessionFactory.getCurrentSession();

        //create query
        Customer customer = session .get(Customer.class,customerId);

        //return the results
        return customer;
    }

    @Override
    public void saveCustomer(Customer customer) {
        //get current hibernate session
        Session session = sessionFactory.getCurrentSession();

        //save/update the customer
        session.saveOrUpdate(customer);
    }

    @Override
    public void deleteCustomer(int customerId) {
        //get current hibernate session
        Session session = sessionFactory.getCurrentSession();

        //delete object with primary key
        Query query = session.createQuery("delete from Customer where id=:customerId");

        query.setParameter("customerId",customerId);

        query.executeUpdate();
    }

    @Override
    public List<Customer> searchCustomers(String theSearchName) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        Query theQuery = null;

        //
        // only search by name if theSearchName is not empty
        //
        if (theSearchName != null && theSearchName.trim().length() > 0) {
            // search for firstName or lastName ... case insensitive
            theQuery =currentSession.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName", Customer.class);
            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");
        }
        else {
            // theSearchName is empty ... so just get all customers
            theQuery =currentSession.createQuery("from Customer", Customer.class);
        }

        // execute query and get result list
        List<Customer> customers = theQuery.getResultList();

        // return the results
        return customers;

    }
}
