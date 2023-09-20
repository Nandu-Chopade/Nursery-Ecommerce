package com.nursery.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {
	 
	    private Long id;
	    private String comment;
	    private int rating;
	    @Temporal(TemporalType.TIMESTAMP)
	    private Date createdAt;
}
