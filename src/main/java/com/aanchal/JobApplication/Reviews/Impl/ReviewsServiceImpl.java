package com.aanchal.JobApplication.Reviews.Impl;

import com.aanchal.JobApplication.Company.Company;
import com.aanchal.JobApplication.Company.CompanyService;
import com.aanchal.JobApplication.Reviews.Reviews;
import com.aanchal.JobApplication.Reviews.ReviewsRepository;
import com.aanchal.JobApplication.Reviews.ReviewsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewsServiceImpl implements ReviewsService {

    private ReviewsRepository reviewsRepository;
    private CompanyService companyService;

    public ReviewsRepository getReviewsRepository() {
        return reviewsRepository;
    }

    public void setReviewsRepository(ReviewsRepository reviewsRepository) {
        this.reviewsRepository = reviewsRepository;
    }

    public ReviewsServiceImpl(ReviewsRepository reviewsRepository, CompanyService companyService) {
        this.reviewsRepository = reviewsRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Reviews> getAllReviews(Long companyId) {
        List<Reviews> reviews= reviewsRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public boolean createReview(Long companyId, Reviews review) {
        Company company=companyService.findCompanyById(companyId);
        if(company!=null){
            review.setCompany(company);
            reviewsRepository.save(review);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Reviews getReviewById(Long companyId, Long reviewId) {
        List<Reviews> reviews=reviewsRepository.findByCompanyId(companyId);
        return reviews.stream().filter(review->review.getId().equals(reviewId)).
                findFirst().orElse(null);
    }
}
