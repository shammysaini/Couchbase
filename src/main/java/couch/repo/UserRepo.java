package couch.repo;

import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import couch.model.Employee;
import couch.model.User;

@Repository
public interface UserRepo extends CouchbaseRepository<User, String> {

	

}
