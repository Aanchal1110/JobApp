package com.aanchal.JobApplication.Jobs;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Jobs, Long> {
//    A repository in spring data jpa in an interface that allows us to perform various activities involving database it can use JpaRepository or CrudRepository as the 2 interfaces. Jpa repository extends the functionalities of CrudRepository

}
