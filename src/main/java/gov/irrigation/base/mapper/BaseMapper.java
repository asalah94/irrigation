package gov.irrigation.base.mapper;

import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.Set;

/**
 *
 * @author nourshaheen
 *
 * @param <T>
 * @param <DTO>
 */
public interface BaseMapper<T , DTO > {
	/**
	 *
	 * @param t
	 * @return
	 */
	DTO map (T t);
	/**
	 *
	 * @param dto
	 * @return
	 */
	T unMap (DTO dto);

//	BaseDto mapToBase (T t);
//	List<BaseDto> mapToBase (List<T> t);
//	Set<BaseDto> mapToBase (Set<T> t);
	/**
	 *
	 * @param t
	 * @param dto
	 */
	T unMap (@MappingTarget T t , DTO dto);
	/**
	 *
	 * @param t
	 * @return
	 */
	List<DTO> map (List<T> t);

	Set<DTO> map (Set<T> t);
	/**
	 *
	 * @param dto
	 * @return
	 */
	List<T> unMap (List<DTO> dto);

}
