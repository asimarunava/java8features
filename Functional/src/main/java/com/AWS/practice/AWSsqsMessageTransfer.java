package com.AWS.practice;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProviderChain;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.InstanceProfileCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.AmazonSQSException;
import com.amazonaws.services.sqs.model.CreateQueueRequest;

public class AWSsqsMessageTransfer {

	public static void main(String[] args) {
		/*AWSCredentials credentials = new BasicAWSCredentials(
				 "AKIAZD3X3PK46XMSXA6O", 
				 "E/FPF1AJhO1QaVPXGP1YGobFYt41Iy5de3se1MQ9"
				);
		AmazonSQS sqs = AmazonSQSClientBuilder.standard()
				 .withCredentials(new AWSStaticCredentialsProvider(credentials))
				 .withRegion(Regions.US_EAST_2)
				 .build();
		
		/*AmazonSQSClient sqs = new AmazonSQSClient(new AWSCredentialsProviderChain(
		          new ProfileCredentialsProvider("default")));*/
		AmazonSQS sqs = AmazonSQSClientBuilder
				 .standard()
				 .withCredentials(new AWSCredentialsProviderChain(new ProfileCredentialsProvider("default")))
				 .withRegion(Regions.US_EAST_2)
				 .build();
		/*
		CreateQueueRequest create_request = new CreateQueueRequest("asim-dev-test-queue")
		        .addAttributesEntry("DelaySeconds", "60")
		        .addAttributesEntry("MessageRetentionPeriod", "86400");

		try {
		    sqs.createQueue(create_request);
		} catch (AmazonSQSException e) {
		    if (!e.getErrorCode().equals("QueueAlreadyExists")) {
		        throw e;
		    }
		}*/
		
		System.out.println(sqs.getQueueUrl("asim-dev-test-queue"));
	}
	
}
