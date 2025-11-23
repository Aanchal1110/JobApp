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

    @Override
    public boolean updateReview(Long companyId, Long reviewId, Reviews updatedReview) {
        // Check if company exists
        Company company = companyService.findCompanyById(companyId);
        if (company == null) {
            return false;
        }

        // Check if review exists and belongs to that company
        Reviews existingReview = getReviewById(companyId, reviewId);
        if (existingReview == null) {
            return false;
        }

        // Update fields
        existingReview.setTitle(updatedReview.getTitle());
        existingReview.setDescription(updatedReview.getDescription());
        existingReview.setRating(updatedReview.getRating());

        // Set the same company
        existingReview.setCompany(company);

        // Save updated review
        reviewsRepository.save(existingReview);

        return true;
    }
    public boolean deleteById(Long companyId, Long reviewId){
        if(companyService.findCompanyById(companyId)!=null && reviewsRepository.
        existsById(reviewId)){
            Reviews review =reviewsRepository.findById(reviewId).orElse(null);
            Company company=review.getCompany();
            company.getReviews().remove(review);
//            review.setCompany(null);
            companyService.updateCompany(companyId,company);
            reviewsRepository.deleteById(reviewId);
            return true;
        }else{
            return false;
        }
    }
}
