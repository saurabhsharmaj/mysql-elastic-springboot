package com.nrielastic.book.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.nrielastic.book.model.Book;




@Mapper
public interface BookDataStoreRepository {

    /* Insert into Item Json into table */
    @Insert("INSERT into book(id,title,author,releaseDate) values (#{id}, #{title},#{author},#{releaseDate})")
    public int insertBook(Book book);
    
    @Select("select * from book")
	public List<Book> findAll();

	@Select("SELECT * FROM book WHERE id = #{id}")
	public Book findById(long id);

	@Delete("DELETE FROM book WHERE id = #{id}")
	public int deleteById(long id);

	@Update("Update book set title=#{title}, author=#{author}, releaseDate=#{releaseDate} where id=#{id}")
	public int update(Book book);

}
