package gov.irrigation.base.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author nourshaheen
 *
 * @param <ID>
 */
@Setter
@Getter
@MappedSuperclass

public abstract class BaseEntity<ID extends Serializable>  implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 3855054033844070951L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private ID id;


	protected BaseEntity() {
		super();
	}
	protected BaseEntity(ID id) {
		this.id = id;
	}


}
