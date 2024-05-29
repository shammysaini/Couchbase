package couch.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

import lombok.Getter;
import lombok.Setter;

@Document
@Setter
@Getter
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationStrategy.UNIQUE)
	private String id;
	@Field
	private String name;
	@Field
	private String mobile;

}
