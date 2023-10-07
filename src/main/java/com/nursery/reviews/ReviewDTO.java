package com.nursery.reviews;

import java.util.Date;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewDTO {
	 
	    private Long id;
	    private String comment;
	    private int rating;
	    @Temporal(TemporalType.TIMESTAMP)
	    private Date createdAt;
}
