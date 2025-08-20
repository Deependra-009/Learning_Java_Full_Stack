````markdown
# Filters vs Interceptors in Spring Boot

This project demonstrates the difference between **Filters** and **Interceptors** in a Spring Boot application, and how to define their order in the request lifecycle.

---

## 🔹 Filters
- Operate at the **Servlet container level** (before Spring MVC).  
- Best for:
  - Authentication
  - Logging
  - Request/Response transformation
- Can be ordered using:
  - `@Order` annotation  
  - `FilterRegistrationBean`

### Example
```java
@Component
@Order(1) // Lower value = higher priority
public class FirstFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("First Filter");
        chain.doFilter(request, response);
    }
}
````

---

## 🔹 Interceptors

* Operate at the **Spring MVC layer** (after Filters, before Controllers).
* Best for:

  * Authorization
  * Business logic validations
  * Measuring execution time of controller methods
* Ordered when registering with `WebMvcConfigurer`.

### Example

```java
@Component
public class FirstInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.out.println("First Interceptor");
        return true;
    }
}
```

### Registering with Order

```java
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private FirstInterceptor firstInterceptor;

    @Autowired
    private SecondInterceptor secondInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(firstInterceptor).order(1);
        registry.addInterceptor(secondInterceptor).order(2);
    }
}
```

---

## 🔹 Execution Flow

```
Client Request 
   ↓
[Filters] (Servlet level)  
   ↓
[Interceptors] (Spring MVC level)  
   ↓
[Controller]  
   ↓
[View/Response]  
```

---

## 🔹 Rule of Thumb

* Use **Filters** for request/response transformations.
* Use **Interceptors** for controller-specific cross-cutting concerns.

---

## 📌 References

* [Spring Boot Docs – Filters](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#web.servlet.filters)
* [Spring Docs – HandlerInterceptor](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/servlet/HandlerInterceptor.html)

