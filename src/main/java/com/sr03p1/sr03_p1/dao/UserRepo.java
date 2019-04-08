package com.sr03p1.sr03_p1.dao;

import com.sr03p1.sr03_p1.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {
    Long countBySexy(String sexy);

    void  deleteById(int id);

    List<User> findByIdAndName(int id, String name);

    List<User> findFirst10ByName(String name);
    List<User> findTop10ByName(String name);

    @Query("select p from Person p where  p.id=?1")
    List<User> findStudentById(int id);

    @Query("select p from Person p where  p.id=:stuId")
    List<User> findStudentByStuId(@Param("stuId") int stuId);


    /*public static Specification<User> personIsWeber(){
        return new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("name"),"weber");
            }
        };
    }*/

    List<User> findByMail(String mail);

}
