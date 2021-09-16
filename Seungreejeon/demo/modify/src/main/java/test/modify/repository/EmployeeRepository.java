package test.modify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import test.modify.domain.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

    public Employee findByEmployeeNo(Long id);

    @Query("select e.name from Employee e where e.name = :value")
    public String EmployeeName(@Param(value = "value")String value);

}
