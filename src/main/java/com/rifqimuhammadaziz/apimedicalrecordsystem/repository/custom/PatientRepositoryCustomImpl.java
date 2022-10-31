package com.rifqimuhammadaziz.apimedicalrecordsystem.repository.custom;

import com.rifqimuhammadaziz.apimedicalrecordsystem.entity.Patient;
import com.rifqimuhammadaziz.apimedicalrecordsystem.model.response.PageDTO;
import com.rifqimuhammadaziz.apimedicalrecordsystem.validation.PageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PatientRepositoryCustomImpl implements PatientRepositoryCustom{

    private final EntityManager entityManager;

    @Override
    public PageDTO findAllWithPage(int size, int page, String direction, String properties, String name) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        // write query to get data
        CriteriaQuery<Patient> getPatientQuery = criteriaBuilder.createQuery(Patient.class);

        Root<Patient> from = getPatientQuery.from(Patient.class);

        CriteriaQuery<Patient> select = getPatientQuery.select(from);

        List<Predicate> predicates = new ArrayList<>();

        // solve searching LIKE operator
        if (!ObjectUtils.isEmpty(name)) {
            predicates.add(criteriaBuilder.like(from.get("fullname"), "%" + name + "%"));
        }

        select.select(from).where(predicates.toArray(new Predicate[]{}));

        // solve direction & sort
        if (direction.equalsIgnoreCase("desc") && !ObjectUtils.isEmpty(properties)) {
            getPatientQuery.orderBy(criteriaBuilder.desc(from.get(properties)));
        } else if (direction.equalsIgnoreCase("asc") && !ObjectUtils.isEmpty(properties)) {
            getPatientQuery.orderBy(criteriaBuilder.asc(from.get(properties)));
        }

        // solve page & size
        TypedQuery<Patient> typedQuery = entityManager.createQuery(select);

        // count total elements
        long totalCount = typedQuery.getResultList().size();

        int offset = (page - 1) * size;
        typedQuery.setFirstResult(offset);
        typedQuery.setMaxResults(size);

        // set data & return
        PageDTO<Patient> pageDTO = PageUtils.calculatePage(size, page, totalCount);
        pageDTO.setData(typedQuery.getResultList());

        return pageDTO;
    }
}
