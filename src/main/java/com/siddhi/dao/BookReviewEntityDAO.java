package com.siddhi.dao;

import com.siddhi.entity.BookReviewEntity;
import io.dropwizard.hibernate.AbstractDAO;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.http.HttpStatus;
import org.eclipse.jetty.server.session.Session;
import org.hibernate.SessionFactory;
//data access object - dao
import java.util.Objects;
import java.util.UUID;

public class BookReviewEntityDAO extends AbstractDAO<BookReviewEntity> {


    public BookReviewEntityDAO(SessionFactory sessionFactory) {
        super(sessionFactory);

    }
    public BookReviewEntity find(String id){
        return get(id);
    }

    public BookReviewEntity save(BookReviewEntity entity){
        if(StringUtils.isEmpty(entity.getId())) {
            entity.setId(UUID.randomUUID().toString());
        }
        return persist(entity);
    }

    public  BookReviewEntity edit(String id,String bookid, Integer rating, String review){
          BookReviewEntity newEntity= get(id);
//        return persist(newEntity);
        if(Objects.isNull(newEntity)){
            return null;
        }
        if(!Objects.isNull(bookid))newEntity.setBookid(bookid);
        if(!Objects.isNull(rating))newEntity.setRating(rating);
        if(!Objects.isNull(review))newEntity.setReview(review);
        return persist(newEntity);
    }

    public String delete(String id){
        BookReviewEntity newEntity=get(id);
        if(Objects.isNull(newEntity)){
            return "Data doesnt exist";
        }
        currentSession().remove(newEntity);
        return "deleted";
    }

}
