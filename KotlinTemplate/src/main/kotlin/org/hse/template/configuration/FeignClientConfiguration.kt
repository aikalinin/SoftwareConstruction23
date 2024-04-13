package org.hse.template.configuration

import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Configuration

@Configuration
@EnableFeignClients(basePackages = ["org.hse.template.client.rest.api"])
class FeignClientConfiguration
