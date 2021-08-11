package com.tungvv.demo.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import com.tungvv.demo.model.Customer;
import lombok.SneakyThrows;
import org.springframework.data.jpa.domain.Specification;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


public class CustomerSpecification implements Specification {

    private final Customer customer;

    public CustomerSpecification(Customer customer) {
        this.customer = customer;
    }

    @SneakyThrows
    @Override
    public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        Field[] fields = this.customer.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.get(customer) == null)
                continue;
            Predicate predicate = criteriaBuilder.equal(root.get(field.getName()), field.get(customer));
            predicates.add(predicate);
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}