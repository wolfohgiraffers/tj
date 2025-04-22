package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class WebConfig implements WebMvcConfigurer {
    
    /*
        front에서 컨테이너를 띄워서 8011까지 테스트 해보고 안되는 걸 확인하고 docker-compose를 진행할 때 
        1. front에서 springboot-app:7777로 접근하는 것
        2. back에서 5173포트 살려서 진행하는 것
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
//                .allowedOrigins("http://localhost:5173")
                .allowedOrigins("http://localhost:8011")

                /* Ingress 적용 이전 프론트 워커노드 포트에 대한 CORS 처리 */
            //    .allowedOrigins("http://localhost:30000")

                /* Ingress 적용 이후 CORS 불필요로 인한 경로 제거 */
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}
