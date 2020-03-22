package moe.zaun.prismriver.minor.service.aws;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.google.inject.Binder;
import com.google.inject.Module;


public class AwsModule implements Module {
    public void configure(final Binder binder) {
        binder.bind(AmazonDynamoDB.class).toInstance(this.getDynamoDB());
    }

    private AmazonDynamoDB getDynamoDB() {
        return AmazonDynamoDBClientBuilder
            .standard()
            .withRegion("us-east-2")
            .build();
    }
}
