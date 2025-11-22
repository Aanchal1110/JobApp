package com.aanchal.JobApplication.Reviews;

import java.util.List;

public interface ReviewsService {

    List<Reviews> getAllReviews(Long companyId);

    boolean createReview(Long companyId, Reviews review);
}
