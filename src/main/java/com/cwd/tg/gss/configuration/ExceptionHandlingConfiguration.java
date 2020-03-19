package com.cwd.tg.gss.configuration;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;

import com.cwd.tg.gss.errors.exceptions.AdventureNotFoundException;
import com.cwd.tg.gss.errors.exceptions.AwardsNotFoundException;
import com.cwd.tg.gss.errors.exceptions.BattleInfoNotFoundException;
import com.cwd.tg.gss.errors.exceptions.CharacterNotFoundException;
import com.cwd.tg.gss.errors.exceptions.MissingHeaderException;
import com.cwd.tg.gss.errors.exceptions.MonsterNotFoundException;
import com.cwd.tg.gss.errors.exceptions.UnauthorizedTokenException;
import com.cwd.tg.gss.errors.handlers.CommonExceptionHandler;
import com.cwd.tg.gss.errors.http.HttpErrorMessage;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.reactive.result.view.ViewResolver;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Configuration
public class ExceptionHandlingConfiguration {

    private static final Map<Class<? extends Throwable>, Function<Throwable, Mono<ServerResponse>>> EXCEPTION_MAPPINGS =
            Map.of(
                    MissingHeaderException.class, exception ->
                            ServerResponse.status(BAD_REQUEST)
                                    .body(fromObject(new HttpErrorMessage(1014000,
                                            BAD_REQUEST.getReasonPhrase(),
                                            exception.getMessage()))),
                    UnauthorizedTokenException.class, exception ->
                            ServerResponse.status(FORBIDDEN)
                                    .body(fromObject(new HttpErrorMessage(1014030,
                                            FORBIDDEN.getReasonPhrase(),
                                            FORBIDDEN.getReasonPhrase()))),
                    CharacterNotFoundException.class, exception ->
                            ServerResponse.status(NOT_FOUND)
                                    .body(fromObject(new HttpErrorMessage(1014040,
                                            NOT_FOUND.getReasonPhrase(),
                                            exception.getMessage()))),
                    AdventureNotFoundException.class, exception ->
                            ServerResponse.status(NOT_FOUND)
                                    .body(fromObject(new HttpErrorMessage(1014041,
                                            NOT_FOUND.getReasonPhrase(),
                                            exception.getMessage()))),
                    AwardsNotFoundException.class, exception ->
                            ServerResponse.status(NOT_FOUND)
                                    .body(fromObject(new HttpErrorMessage(1014042,
                                            NOT_FOUND.getReasonPhrase(),
                                            exception.getMessage()))),
                    BattleInfoNotFoundException.class, exception ->
                            ServerResponse.status(NOT_FOUND)
                                    .body(fromObject(new HttpErrorMessage(1014043,
                                            NOT_FOUND.getReasonPhrase(),
                                            exception.getMessage()))),
                    MonsterNotFoundException.class, exception ->
                            ServerResponse.status(NOT_FOUND)
                                    .body(fromObject(new HttpErrorMessage(1014044,
                                            NOT_FOUND.getReasonPhrase(),
                                            exception.getMessage())))
            );

    @Bean
    @Primary
    public AbstractErrorWebExceptionHandler exceptionHandler(
            ErrorAttributes errorAttributes,
            ResourceProperties resourceProperties,
            ApplicationContext applicationContext,
            ObjectProvider<ViewResolver> viewResolvers,
            ServerCodecConfigurer serverCodecConfigurer) {

        var exceptionHandler = new CommonExceptionHandler(errorAttributes,
                resourceProperties, applicationContext, EXCEPTION_MAPPINGS);
        exceptionHandler.setViewResolvers(viewResolvers.orderedStream().collect(Collectors.toList()));
        exceptionHandler.setMessageWriters(serverCodecConfigurer.getWriters());
        exceptionHandler.setMessageReaders(serverCodecConfigurer.getReaders());
        return exceptionHandler;
    }
}
