package gov.irrigation.base.service;


import gov.irrigation.base.model.BaseEntity;
import gov.irrigation.exception.BusinessException;
import gov.irrigation.util.Constants;
import gov.irrigation.base.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.NoSuchMessageException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.persistence.MappedSuperclass;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;


/**
 * @param <T>
 * @param <ID>
 * @author nourshaheen
 */
@MappedSuperclass
public abstract class BaseServiceImpl<T extends BaseEntity<ID>, ID extends Serializable> implements BaseService<T, ID> {


	@Autowired
	private BaseRepository<T, ID> baseRepository;

	@Autowired
	private MessageSourceService messageSource;

	@Override
	public List<T> findAll() {
		return baseRepository.findAll();
	}

	/**
	 * @return
	 */
	@Override
	public Page<T> findAll(Pageable pageable) {
		return baseRepository.findAll(pageable);
	}

	/**
	 * @param id
	 * @return
	 */
	@Override
	public T findById(ID id) {
		String [] params = {id.toString()};
		return baseRepository.findById(id).orElseThrow(() -> new BusinessException(Constants.ErrorKeys.EXCEPTION_RECORD_NOT_FOUND, HttpStatus.NOT_FOUND, params));
	}

	public T getReferenceById(ID id){
		return baseRepository.getReferenceById(id);
	}


	@Override
	public Optional<T> getById(ID id) {
		return baseRepository.findById(id);
	}

	/**
	 * @param entity
	 * @return
	 */
	@Override
	public T insert(T entity) {
		return baseRepository.save(entity);

	}

	/**
	 * @param entity
	 * @return
	 */
	@Override
	public T persist(T entity) {
		return baseRepository.saveAndFlush(entity);

	}

	/**
	 *
	 */
	@Override
	public T update(T entity) {
		return baseRepository.save(entity);
	}

	/**
	 * @param entities
	 * @return
	 */
	@Override
	public List<T> saveAll(List<T> entities) {
		return baseRepository.saveAll(entities);
	}

	/**
	 * @param id
	 * @return
	 */
	@Override
	public void deleteById(ID id) {
		baseRepository.deleteById(id);
	}

	/**
	 * @param ids
	 */
	@Override
	public void deleteAll(List<ID> ids) {
		ids.forEach(id ->
			baseRepository.deleteById(id)
		);
	}

	public int updateIsDeleted(ID id, boolean isDeleted) {
		return baseRepository.updateIsDeleted(id, isDeleted);
	}

	public String getMessage(String code, String[] args) {
		return messageSource.getMessage(code, args);
	}

	public String getMessage(String code) throws NoSuchMessageException {
		return messageSource.getMessage(code);
	}

	public String getUserAgent() {
	    RequestAttributes attribs = RequestContextHolder.getRequestAttributes();
	    if (attribs != null) {
	        HttpServletRequest request = ((ServletRequestAttributes) attribs).getRequest();
	        return request.getHeader(HttpHeaders.USER_AGENT);
	    }
	    return null;
	}



}
