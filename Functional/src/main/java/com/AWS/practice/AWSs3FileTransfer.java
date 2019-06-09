package com.AWS.practice;

import java.io.File;

import com.amazonaws.auth.AWSCredentialsProviderChain;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3ObjectSummary;

public class AWSs3FileTransfer {
public static void main(String[] args) {
	
	
	String bucketName= "asim-dev-test1";

	/*AWSCredentials credentials = new BasicAWSCredentials(
	 "AKIAZD3X3PK46XMSXA6O", 
	 "E/FPF1AJhO1QaVPXGP1YGobFYt41Iy5de3se1MQ9"
	);
	AmazonS3 s3client = AmazonS3ClientBuilder
	 .standard()
	 .withCredentials(new AWSStaticCredentialsProvider(credentials))
	 .withRegion(Regions.US_EAST_2)
	 .build();*/
	
	/*AmazonS3Client s3client = new AmazonS3Client(new AWSCredentialsProviderChain(
	          new ProfileCredentialsProvider("default")));*/
	
	AmazonS3 s3client = AmazonS3ClientBuilder
			 .standard()
			 .withCredentials(new AWSCredentialsProviderChain(new ProfileCredentialsProvider("default")))
			 .withRegion(Regions.US_EAST_2)
			 .build();
	File f = new File("/Users/asim/java8completablefutures.pdf");
	System.out.println(f.exists());
	if(s3client.doesBucketExist(bucketName))
	{
	ObjectListing objectListing = s3client.listObjects(bucketName);
	for (S3ObjectSummary os : objectListing.getObjectSummaries()) {
	System.out.println(os.getKey());
	}

	s3client.putObject(bucketName,"dev/"+f.getName(),f);
	}
}
}
