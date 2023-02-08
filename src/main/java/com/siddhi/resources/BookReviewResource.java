package com.siddhi.resources;

import com.siddhi.dao.BookReviewEntityDAO;
import com.siddhi.entity.BookReviewEntity;
import io.dropwizard.hibernate.UnitOfWork;

import javax.validation.Valid;
import javax.ws.rs.*;
import java.util.Date;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.StreamingOutput;


@Path("/book")
@Produces(MediaType.APPLICATION_JSON)
public class BookReviewResource {
    private final BookReviewEntityDAO bookReviewEntityDAO;

    public BookReviewResource(BookReviewEntityDAO bookReviewEntityDAO) {
        this.bookReviewEntityDAO = bookReviewEntityDAO;
    }

    @GET
    @Path("/healthCheck")
    public String healthCheck() {
        return "Ping recieved at " + new Date();

    }

//    @GET
//    @Timed
//    @Path("{id}")
//    public BookReviewEntity getPart(@PathParam("id") final int id) {
//        return new BookReviewEntity(HttpStatus.OK_200, get(id));
//    }



    @POST
    @Path("/review")
    @UnitOfWork
    public String postReview(@Valid BookReviewEntity bookReviewEntity) {
        return bookReviewEntityDAO.save(bookReviewEntity).getId();

    }

    @GET
    @Path("/review")
    @UnitOfWork
    public BookReviewEntity getReview(@QueryParam("bookid") String bookid) {
        return bookReviewEntityDAO.find(bookid);

    }
    @PUT
    @Path("/review")
    @UnitOfWork
    public BookReviewEntity editReview(
            @QueryParam("id") String id,
            @QueryParam("bookid") String bookid,
            @QueryParam("rating") Integer rating,
            @QueryParam("review") String review
    ) {

        return bookReviewEntityDAO.edit(id,bookid,rating,review);
    }

    @DELETE
    @Path("/review")
    @UnitOfWork
    public String deleteReview(@QueryParam("id") String id) {

        return bookReviewEntityDAO.delete(id);

    }

}