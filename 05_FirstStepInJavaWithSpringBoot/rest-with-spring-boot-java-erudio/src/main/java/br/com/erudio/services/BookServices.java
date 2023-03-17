package br.com.erudio.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


import org.springframework.stereotype.Service;

import br.com.erudio.controllers.PersonController;
import br.com.erudio.data.vo.v1.BookVO;
import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.exceptions.RequiredObjectIsNullException;
import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.mapper.DozerMapper;
import br.com.erudio.model.Book;
import br.com.erudio.model.Person;
import br.com.erudio.repositories.BookRepository;
import br.com.erudio.repositories.PersonRepository;

@Service
public class BookServices {
	
	private Logger logger = Logger.getLogger(BookServices.class.getName());
	
	@Autowired
	BookRepository repository;
	
	public List<BookVO> findAll() {
		
		var books = DozerMapper.parseListObjects(repository.findAll(), BookVO.class);
	/*books.stream().forEach(b -> {
		try {
			b.add(linkTo(methodOn(PersonController.class).findById(b.getKey())).
					withSelfRel());
		} catch (Exception e) {
			e.printStackTrace();
		}
	});*/
	return books;
	}
	
	public BookVO findById(Long id) throws Exception {
		
		logger.info("Finding one book!");
		
		var entity = repository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		var vo = DozerMapper.parseObject(entity, BookVO.class);
		//vo.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
		return vo;
	}
	
	public BookVO create(BookVO book) throws Exception {
		
		if(book == null) throw new RequiredObjectIsNullException();
		
		logger.info("Creating one book");
		Book entity = DozerMapper.parseObject(book, Book.class);
		BookVO vo = DozerMapper.parseObject(repository.save(entity), BookVO.class);
		//vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());
		return vo;
	}
	
    public BookVO update(BookVO book) throws Exception {
		
    	if(book == null) throw new RequiredObjectIsNullException();
    	
    	logger.info("Update one book");

    	Book entity = repository.findById(book.getKey())
		.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID	"));
		
    	entity.setAuthor(book.getAuthor());
    	entity.setLaunchDate(book.getLaunchDate());
    	entity.setPrice(book.getPrice());
    	entity.setTitle(book.getTitle());

    	var vo = DozerMapper.parseObject(repository.save(entity), BookVO.class);
    	//vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());
		return vo;
	}
    
    public void delete(Long id) {
		
		logger.info("Deleting one book");

		Book entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID	"));
		repository.delete(entity);
    }

}
