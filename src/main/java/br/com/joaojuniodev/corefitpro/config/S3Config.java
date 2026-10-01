package br.com.joaojuniodev.corefitpro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;

import java.net.URI;

@Configuration
public class S3Config {

    @Bean
    S3Presigner s3Presigner(B2Properties props) {
        return S3Presigner.builder()
            .region(Region.of("us-east-005"))
            .endpointOverride(URI.create("https://s3.us-east-005.backblazeb2.com"))
            .credentialsProvider(StaticCredentialsProvider.create(
                AwsBasicCredentials.create(props.getKeyId(), props.getApplicationKey())))
            .build();
    }
}