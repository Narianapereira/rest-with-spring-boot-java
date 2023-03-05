package br.com.erudio.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.data.vo.v2.PersonVOV2;
import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.mapper.DozerMapper;
import br.com.erudio.mapper.custom.PersonMapper;
import br.com.erudio.model.Person;
import br.com.erudio.repositories.PersonRepository;

@Service
public class PersonServices {
	
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	PersonRepository repository;
	
	@Autowired
	PersonMapper mapper;
	
	public List<PersonVO> findAll() {
		
		return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
	}
	
	public PersonVO findById(Long id) {
		
		logger.info("Finding one PersonVO");
			
		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID	"));
	return DozerMapper.parseObject(entity, PersonVO.class);
	}
	
	public PersonVO create(PersonVO person) {
		
		logger.info("Creating one person");
		Person entity = DozerMapper.parseObject(person, Person.class);
		PersonVO vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}
	public PersonVOV2 createV2(PersonVOV2 person) {
		
		logger.info("Creating one person with v2");
		Person entity = mapper.convertVoToEntity(person);
		PersonVOV2 vo = mapper.convertEntityToVo((repository.save(entity)));
		return vo;
	}
    
	public PersonVO update(PersonVO person) {
		
    	logger.info("Update one PersonVO");

    	Person entity = repository.findById(person.getId())
		.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID	"));
		
    	entity.setFirstName(person.getFirstName());
    	entity.setLastName(person.getLastName());
    	entity.setAddress(person.getAddress());
    	entity.setGender(person.getGender());

    	PersonVO vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}
    
    public void delete(Long id) {
		
		logger.info("Deleting one PersonVO");

		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID	"));
		repository.delete(entity);
    }

}
