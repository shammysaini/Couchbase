package couch.repo;

import java.util.List;

import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.couchbase.repository.Query;
import org.springframework.stereotype.Repository;

import couch.model.Employee;

@Repository
public interface EmployeeRepo extends CouchbaseRepository<Employee, String> {

	Employee getEmployeeByIdAndMobile(String id, String name);

	@Query("SELECT * FROM #(#n1ql.bucket):")
	List<Employee> findAllEmployee();

}
