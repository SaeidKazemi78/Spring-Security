package com.techprimers.security.securitydbexample.repository;

import java.util.List;
import java.util.Optional;

import com.techprimers.security.securitydbexample.model.Users;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Repository(value = "userRepositoryImpl")
@Transactional(propagation = Propagation.NESTED)
public class UserRepositoryImpl implements UsersRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public UserRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory=sessionFactory;
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void delete(int id){
        Users user =getSession().get(Users.class, id);
        getSession().delete(user);
    }

    public void save(Users user) {
        getSession().saveOrUpdate(user);
    }

    public Users getUser(int id){
       return getSession().get(Users.class, id);
    }

    @Override
    public Optional<Users> findByUserName(final String username) {

        final Criteria criteria = getSession().createCriteria(Users.class);
        criteria.add(Restrictions.eq("username", username));
        final List<Users> user = criteria.list();
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User Not found");
        } else {
            return Optional.of(new Users(user.stream().findAny().get()));
        }
    }

}